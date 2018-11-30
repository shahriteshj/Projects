package com.jp.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;
import com.jp.shopping.utilities.ConnectionFactory;

public class ProductDAOImpl implements ProductDAO {
	private ConnectionFactory factory;

	public ProductDAOImpl() throws CartException {
		try {
			factory = new ConnectionFactory();
		} catch (ClassNotFoundException | SQLException e) {
			throw new CartException("Problem in creating database connection",e);
		}

	}

	private void closeConnection(Connection conn) throws CartException {
//		try {
//			factory.closeConnection();
//		} catch (SQLException e) {
//			throw new HRException("Problem in releasing database connection",e);
//		}
	}

	@Override
	public ArrayList<Product> getProductList() throws CartException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			conn = factory.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ID,CATEGORY,NAME,PRICE FROM PRODUCT");
			while (rs.next()) {

				int prodID = rs.getInt("ID");
				String category = rs.getString("CATEGORY");
				String name = rs.getString("NAME");
				Float price = rs.getFloat("PRICE");
				;
				prodList.add(new Product(prodID, category, name, price));
			}

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				closeConnection(conn);
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}
		return prodList;
	}

	@Override
	public Product getProductDetails(int productId) throws CartException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String strQuery = "SELECT id, category, name, price FROM PRODUCT WHERE id=?";
		try {
			conn = factory.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String category = rs.getString("category");
				String name = rs.getString("name");
				Float price = rs.getFloat("price");
				return new Product(productId, category, name, price);
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				closeConnection(conn);
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}

	}

	@Override
	public boolean insertNewRecord(Product product) throws CartException {
		Connection conn = null;
		PreparedStatement stmt = null;

		String strQuery = "INSERT INTO PRODUCT (id,category,name,price) VALUES(?,?,?,?)";
		try {
			conn = factory.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, product.getProdID());
			stmt.setString(2, product.getCategory());
			stmt.setString(3, product.getName());
			stmt.setFloat(4, product.getPrice());
			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				closeConnection(conn);
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}
	}

	@Override
	public boolean deleteRecord(int productId) throws CartException {
		Connection conn = null;
		PreparedStatement stmt = null;

		String strQuery = "DELETE FROM PRODUCT where ID = ? ";
		try {
			conn = factory.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, productId);
			int recDeleted = stmt.executeUpdate();
			return recDeleted == 1 ? true : false;

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				closeConnection(conn);
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}
	}

	@Override
	public boolean updateRecord(Product product) throws CartException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String strQuery = "UPDATE PRODUCT SET category=?, name=?, price=? WHERE id=?";
		try {
			conn = factory.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setString(1, product.getCategory());
			stmt.setString(2, product.getName());
			stmt.setFloat(3, product.getPrice());
			stmt.setInt(4, product.getProdID());
			int recUpdated = stmt.executeUpdate();
			return recUpdated == 1 ? true : false;

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				closeConnection(conn);
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}

	}

	@Override
	protected void finalize() throws Throwable {
		factory.closeConnection();
		super.finalize();
	}
	
	

}
