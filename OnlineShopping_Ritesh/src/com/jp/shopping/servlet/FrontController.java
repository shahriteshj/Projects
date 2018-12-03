package com.jp.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.shopping.entity.ItemMaster;
import com.jp.shopping.entity.OrderMaster;
import com.jp.shopping.exceptions.ShoppingException;
import com.jp.shopping.service.ItemMasterService;
import com.jp.shopping.service.ItemMasterServiceImpl;
import com.jp.shopping.service.OrderMasterService;
import com.jp.shopping.service.OrderMasterServiceImpl;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemMasterService itemMasterService;
	private OrderMasterService orderMasterService;

	@Override
	public void init() throws ServletException {
		try {
			itemMasterService = new ItemMasterServiceImpl();
			orderMasterService = new OrderMasterServiceImpl();

		} catch (ShoppingException e) {
			throw new ServletException("Init method failed", e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		ArrayList<ItemMaster> itemList = new ArrayList<ItemMaster>();

		System.out.println(request.getRequestURI());
		String action = getAction(request.getRequestURI());

		String jspName = "";
		String prefix = "/WEB-INF/jsps/";
		String postfix = ".jsp";
		System.out.println(action);
		try {
			switch (action) {
			case "*":
			case "home": {
				jspName = "Home";
				break;
			}
			case "itemList": {
				itemList = itemMasterService.getItemList();
				request.setAttribute("itemList", itemList);
				jspName = "ItemList";
				break;
			}

			case "itemDetails": {
				String itemId = request.getParameter("itemId");
				ItemMaster item = itemMasterService.getItemDetails(itemId);
				request.setAttribute("itemDetails", item);
				jspName = "ItemDetails";
				break;
			}

			case "addToCart": {
				String itemId = request.getParameter("itemId");
				ItemMaster item = itemMasterService.getItemDetails(itemId);
				HttpSession session = request.getSession();
				itemList = (ArrayList<ItemMaster>) session.getAttribute("shoppingcart");
				if (itemList == null) {
					itemList = new ArrayList<ItemMaster>();
				}
				displayItems(itemList);
				itemList.add(item);
				session.setAttribute("shoppingcart", itemList);
				displayItems(itemList);
				

				itemList = itemMasterService.getItemList();
				request.setAttribute("itemList", itemList);
				jspName = "ItemList";
				break;
			}

			case "cart": {
				HttpSession session = request.getSession();
				itemList = (ArrayList<ItemMaster>) session.getAttribute("shoppingcart");
				if (itemList == null) {
					itemList = new ArrayList<ItemMaster>();
				}
				Float totalPrice = 0f;
				for(ItemMaster item : itemList){
					totalPrice+=item.getPrice();
				}
				request.setAttribute("TotalPrice", totalPrice);
				
				jspName = "Cart";
				break;
			}
			case "placeOrder":{
				HttpSession session = request.getSession();
				itemList = (ArrayList<ItemMaster>) session.getAttribute("shoppingcart");
				ArrayList<OrderMaster> orderList = new ArrayList<OrderMaster>();
				for(ItemMaster item : itemList){
					OrderMaster order = new OrderMaster(101,item.getItemId());
					orderList.add(order);
				}
				
				
				boolean isSuccessful = orderMasterService.placeOrder(orderList);
				String msg = isSuccessful ? "Order Placed Successfully" : "Order failed. Try again";
				request.setAttribute("message", msg);
				jspName = "ThanksPage";
				break;
			}
			}
		} catch (ShoppingException e) {
			throw new ServletException(e.getMessage());
		}
		rd = request.getRequestDispatcher(prefix + jspName + postfix);
		rd.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getAction(String uri) {
		int leftPosition = uri.lastIndexOf("/");
		int rightPosition = uri.lastIndexOf(".");
		if (rightPosition == -1 || leftPosition == -1) {
			return "home";
		} else {
			return uri.substring(leftPosition + 1, rightPosition);
		}
	}

	private void displayItems(ArrayList<ItemMaster> a) {
		if (a != null) {
			for (ItemMaster i : a) {
				System.out.println(i.toString());
			}
		}
	}

}
