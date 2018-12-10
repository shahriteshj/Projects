package com.jp.hr.utilities;


import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class ConnectionFactory {

	private static ConnectionFactory factory = null;
	private OracleDataSource dataSource;

	private ConnectionFactory() throws SQLException {
		dataSource = new OracleDataSource();
		dataSource.setDriverType("thin");
		dataSource.setPortNumber(1521);
		dataSource.setUser("hr");
		dataSource.setPassword("hr");
		dataSource.setServerName("localhost");
		dataSource.setServiceName("orcl");
		dataSource.getConnection();

	}

	public static ConnectionFactory getConnectionFactory() throws ClassNotFoundException, SQLException {
		if (factory == null) {
			factory = new ConnectionFactory();
		}
		return factory;
	}

	public OracleDataSource getDataSource() {
		return this.dataSource;
	}

}
