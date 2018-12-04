package com.jp.shopping.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.sql.DataSource;
import com.jp.shopping.entities.Product;
import com.jp.shopping.exceptions.CartException;
import com.jp.shopping.utilities.ConnectionFactoryTomcat;

public class ProductDAOImpl implements ProductDAO {
	private DataSource dataSource = null;

	public ProductDAOImpl() throws CartException {
		ConnectionFactoryTomcat factory = ConnectionFactoryTomcat.getConnectionFactory();
		dataSource = factory.getDataSource();
	}

	@Override
	public ArrayList<Product> getProductList() throws CartException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			byte[] imgData = null;
			Blob img = null;
			rs = stmt.executeQuery("SELECT ID,CATEGORY,NAME,PRICE,IMAGE FROM PRODUCT");
			while (rs.next()) {
				String encodeBase64="";
				int prodID = rs.getInt("ID");
				String category = rs.getString("CATEGORY");
				String name = rs.getString("NAME");
				Float price = rs.getFloat("PRICE");
				img = rs.getBlob("IMAGE");
				if (img == null) {
					imgData = new byte[0];
				} else {
					imgData = img.getBytes(1, (int) img.length());
					encodeBase64 = Base64.getEncoder().encodeToString(imgData);
					
				}
				prodList.add(new Product(prodID, category, name, price, imgData,encodeBase64));
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
				if (conn != null) {
					conn.close();
				}
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
		byte[] imgData = null;
		Blob img = null;
		String encodeBase64="";
		String strQuery = "SELECT id, category, name, price,IMAGE FROM PRODUCT WHERE id=?";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String category = rs.getString("category");
				String name = rs.getString("name");
				Float price = rs.getFloat("price");
				img = rs.getBlob("IMAGE");
				
				if (img == null) {
					imgData = new byte[0];
				} else {
					imgData = img.getBytes(1, (int) img.length());
					encodeBase64 = Base64.getEncoder().encodeToString(imgData);
				}
				
				return new Product(productId, category, name, price, imgData,encodeBase64);
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
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}

	}

	@Override
	public boolean insertNewRecord(Product product) throws CartException {
		Connection conn = null;
		PreparedStatement stmt = null;
		byte[] imgData = null;
		String strQuery = "INSERT INTO PRODUCT (id,category,name,price,image) VALUES(?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setInt(1, product.getProdID());
			stmt.setString(2, product.getCategory());
			stmt.setString(3, product.getName());
			stmt.setFloat(4, product.getPrice());

			imgData = product.getImage();
			stmt.setBytes(5, imgData);

			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
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
			conn = dataSource.getConnection();
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
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}
	}

	@Override
	public boolean updateRecord(Product product) throws CartException {
		Connection conn = null;
		PreparedStatement stmt = null;
		byte[] imgData = null;

		String strQuery = "UPDATE PRODUCT SET category=?, name=?, price=? WHERE id=?";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(strQuery);
			stmt.setString(1, product.getCategory());
			stmt.setString(2, product.getName());
			stmt.setFloat(3, product.getPrice());
			stmt.setInt(4, product.getProdID());

			imgData = product.getImage();
			stmt.setBytes(5, imgData);

			int recUpdated = stmt.executeUpdate();
			return recUpdated == 1 ? true : false;

		} catch (SQLException e) {
			throw new CartException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new CartException("Problem in closing resources.", e);
			}

		}

	}
}
