package com.jp.shopping.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;
import com.jp.shopping.services.ProductService;
import com.jp.shopping.services.ProductServiceImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;

	@Override
	public void init() throws ServletException {
		try {
			productService = new ProductServiceImpl();
		} catch (CartException e) {
			throw new ServletException("Init method failed",e);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Product> productList = new ArrayList<Product>();
		RequestDispatcher rd = null;
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

			case "login": {
				jspName = "Login";
				break;
			}
			
			case "register": {
				jspName = "Registration";
				break;
			}

			case "authenticate": {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				if (username.equalsIgnoreCase("a") && password.equals("a")) {
					String userFullName = "John Smith";
					HttpSession session = request.getSession();
					session.setAttribute("userFullName", userFullName);
					jspName = "MainMenu";
				} else {
					String msg = "Invalid Credentials. Please enter again";
					request.setAttribute("errMsg", msg);
					jspName = "Login";
				}

				break;
			}

			case "mainMenu": {
				jspName = "MainMenu";
				break;
			}
			case "logout": {
				HttpSession session = request.getSession();
				request.setAttribute("userFullName", session.getAttribute("userFullName"));
				session.invalidate();
				jspName = "ThanksPage";
				break;
			}
						case "productList": {

				productList = productService.getProductList();
				System.out.println(productList);
				request.setAttribute("productList", productList);
				jspName = "ProductList";
				break;
			}
			case "prodDetails": {
				String strId = request.getParameter("prodId");
				System.out.println(strId);
				int prodid = Integer.parseInt(strId);
				Product prod = productService.getProductDetails(prodid);
				request.setAttribute("prodDetails", prod);
				jspName = "ProductDetails";
				break;
			}
			case "newProduct": {
				jspName = "NewProduct";
				break;
			}
			case "addProduct": {
				String strProdId = request.getParameter("prodID");
				String category = request.getParameter("category");
				String name = request.getParameter("name");
				String strPrice = request.getParameter("price");
				Float price = Float.parseFloat(strPrice);
				int prodId = Integer.parseInt(strProdId);
				Product p = new Product(prodId, category, name, price);
				boolean isSuccessful = productService.addNewProduct(p);
				String msg = isSuccessful ? "Product Inserted" : "Insertion failed";
				request.setAttribute("message", msg);
				jspName = "NewProduct";
				break;
			}
			case "editProduct": {
				String strProdId = request.getParameter("prodID");
				int prodId = Integer.parseInt(strProdId);
				Product prod = productService.getProductDetails(prodId);
				request.setAttribute("productDetails", prod);
				jspName = "EditProduct";
				break;
			}
			case "modifyProduct": {
				String strProdId = request.getParameter("prodID");
				String category = request.getParameter("category");
				String name = request.getParameter("name");
				String strPrice = request.getParameter("price");
				Float price = Float.parseFloat(strPrice);
				int prodId = Integer.parseInt(strProdId);
				System.out.println(price);
				Product p = new Product(prodId, category, name, price);
				boolean isSuccessful = productService.modifyProduct(p);
				String msg = isSuccessful ? "Product Update" : "Updation failed";
				request.setAttribute("message", msg);
				productList = productService.getProductList();
				request.setAttribute("productList", productList);
				jspName = "ProductList";
				break;
			}
			case "deleteProduct": {
				String strProdId = request.getParameter("prodID");
				int productId = Integer.parseInt(strProdId);
				boolean isSuccessful = productService.removeProduct(productId);
				String msg = isSuccessful ? "Product Deleted" : "Deletion failed";
				request.setAttribute("message", msg);
				productList = productService.getProductList();
				request.setAttribute("productList", productList);

				jspName = "ProductList";
				break;
			}
			}

		} catch (CartException e) {
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher(prefix + jspName + postfix);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getAction(String uri) {
		int leftPosition = uri.lastIndexOf("/");
		int rightPosition = uri.lastIndexOf(".");
		if (rightPosition == -1 || leftPosition == -1) {
			return "login";
		} else {
			return uri.substring(leftPosition + 1, rightPosition);
		}
	}
}
