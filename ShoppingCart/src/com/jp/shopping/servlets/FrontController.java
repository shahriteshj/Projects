package com.jp.shopping.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jp.shopping.entities.User;
import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;
import com.jp.shopping.services.ProductService;
import com.jp.shopping.services.ProductServiceImpl;
import com.jp.shopping.services.UserService;
import com.jp.shopping.services.UserServiceImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		try {
			productService = new ProductServiceImpl();
			userService = new UserServiceImpl();
		} catch (CartException e) {
			throw new ServletException("Init method failed", e);
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

			case "authenticate": {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				User user = userService.findByUsername(username.toLowerCase());
				System.out.println(user);
				if (user != null && password.equals(user.getPassword())) {
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

			case "register": {
				jspName = "Registration";
				break;
			}

			case "registration": {
				String name = request.getParameter("name");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");

				User user = new User(name, username, password, email, "");
				boolean isSuccessful = userService.addNewUser(user);
				String msg = isSuccessful ? "User Registered" : "Registration failed";
				request.setAttribute("message", msg);
				jspName = "login";
				break;
			}

			case "mainMenu": {
				jspName = "MainMenu";
				break;
			}
			case "logout": {
				HttpSession session = request.getSession(false);
				if (session == null) {
					jspName = "Login";
				} else {
					request.setAttribute("userFullName", session.getAttribute("userFullName"));
					session.invalidate();
					jspName = "ThanksPage";
				}
				break;
			}
			case "productList": {

				productList = productService.getProductList();
				System.out.println(productList);
				request.setAttribute("productList", productList);
				jspName = "ProductList";
				break;
			}
/*			case "prodDetails": {
				String strId = request.getParameter("prodId");
				System.out.println(strId);
				int prodid = Integer.parseInt(strId);
				Product prod = productService.getProductDetails(prodid);
				System.out.println(prod.getImage());
				String encodeBase64 = Base64.getEncoder().encodeToString(prod.getImage());
				prod.setBase64Image(encodeBase64);		
				request.setAttribute("prodDetails", prod);
				jspName = "ProductDetails";
				break;
			}
*/			case "newProduct": {
				jspName = "NewProduct";
				break;
			}
			case "addProduct": {
				String strProdId = null;
				String category = null;
				String name = null;
				String strPrice = null;
				Float price = 0f;
				byte[] bytesArray;

				Product p = new Product();

				if (ServletFileUpload.isMultipartContent(request)) {

					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String fileName = item.getName();
							if(fileName == null || fileName.equals("")){
								throw new ServletException("File Name can't be null or empty");
							}
							File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
							if(!file.exists()){
								throw new ServletException("File doesn't exists on server.");
							}
							System.out.println("File location on server::"+file.getAbsolutePath());
							bytesArray = new byte[(int) file.length()];
							FileInputStream fis = new FileInputStream(file);
							fis.read(bytesArray); // read file into bytes[]
							fis.close();
							p.setImage(bytesArray);

						} else {
							if (item.getFieldName().equals("prodID")) {
								strProdId = item.getString();
								int prodId = Integer.parseInt(strProdId);
								p.setProdID(prodId);
							} else if (item.getFieldName().equals("category")) {
								category = item.getString();
								p.setCategory(category);
							} else if (item.getFieldName().equals("name")) {
								name = item.getString();
								p.setName(name);
							} else if (item.getFieldName().equals("price")) {
								strPrice = item.getString();
								price = Float.parseFloat(strPrice);
								p.setPrice(price);
							}
						}

					}
				}

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
				String strProdId = null;
				String category = null;
				String name = null;
				String strPrice = null;
				Float price = 0f;
				byte[] bytesArray;
				Product p = new Product();

				if (ServletFileUpload.isMultipartContent(request)) {

					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String fileName = item.getName();
							if(fileName == null || fileName.equals("")){
								
							}
							File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
							if(!file.exists()){
								
							}
							System.out.println("File location on server::"+file.getAbsolutePath());
							bytesArray = new byte[(int) file.length()];
							FileInputStream fis = new FileInputStream(file);
							fis.read(bytesArray); // read file into bytes[]
							fis.close();
							p.setImage(bytesArray);

						} else {
							if (item.getFieldName().equals("prodID")) {
								strProdId = item.getString();
								int prodId = Integer.parseInt(strProdId);
								p.setProdID(prodId);
							} else if (item.getFieldName().equals("category")) {
								category = item.getString();
								p.setCategory(category);
							} else if (item.getFieldName().equals("name")) {
								name = item.getString();
								p.setName(name);
							} else if (item.getFieldName().equals("price")) {
								strPrice = item.getString();
								price = Float.parseFloat(strPrice);
								p.setPrice(price);
							}
						}

					}
				}

				boolean isSuccessful = productService.modifyProduct(p);
				String msg = isSuccessful ? "Product Updated" : "Updation failed";
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
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			return "login";
		} else {
			return uri.substring(leftPosition + 1, rightPosition);
		}
	}
}
