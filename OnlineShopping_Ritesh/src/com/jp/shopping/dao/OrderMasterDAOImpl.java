package com.jp.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.jp.shopping.entity.OrderMaster;
import com.jp.shopping.exceptions.ShoppingException;
import com.jp.shopping.utilities.ConnectionFactoryTomcat;

public class OrderMasterDAOImpl implements OrderMasterDAO {

	private DataSource dataSource = null;

	public OrderMasterDAOImpl() throws ShoppingException {
		ConnectionFactoryTomcat factory = ConnectionFactoryTomcat.getConnectionFactory();
		dataSource = factory.getDataSource();
	}

	@Override
	public ArrayList<OrderMaster> getOrderList() throws ShoppingException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<OrderMaster> orderList = new ArrayList<OrderMaster>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT CUSTOMERID,ORDERID,ITEMID FROM ORDERMASTER");
			while (rs.next()) {

				String itemId = rs.getString("ITEMID");
				int customerId = rs.getInt("CUSTOMERID");
				int orderId = rs.getInt("ORDERID");

				orderList.add(new OrderMaster(customerId, orderId, itemId));
			}

		} catch (SQLException e) {
			throw new ShoppingException("Problem in fetching data.", e);
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
				throw new ShoppingException("Problem in closing resources.", e);
			}

		}
		return orderList;
	}

	@Override
	public boolean insertOrderDetails(ArrayList<OrderMaster> orderList) throws ShoppingException {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean transactionSuccess = true;
		String strQuery = "INSERT INTO ORDERMASTER (CUSTOMERID,ORDERID,ITEMID) VALUES(?,ORDER_SEQ.nextval,?)";
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(strQuery);
			for (OrderMaster orderMaster : orderList) {
				stmt.setInt(1, orderMaster.getCustomerId());
				stmt.setString(2, orderMaster.getItemId());
				int recInserted = stmt.executeUpdate();
				if (recInserted != 1) {
					transactionSuccess = false;
					break;
				}
			}
			if (transactionSuccess) {
				conn.commit();
			} else {
				conn.rollback();
			}
			return transactionSuccess;

		} catch (SQLException e) {
			throw new ShoppingException("Problem in fetching data.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShoppingException("Problem in closing resources.", e);
			}

		}

	}

}
