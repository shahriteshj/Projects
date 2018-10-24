package com.ca.app;

import com.ca.db.OracleConnection;

import java.sql.*;


public class DBConnection {
    public static void main(String[] args) {
        Connection conn = OracleConnection.getConnection();

        Statement s = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            s = conn.createStatement();

            //test Select
            rs = s.executeQuery("Select * from Employees");
            ResultSetMetaData rsMetadata = rs.getMetaData();
            System.out.println(rsMetadata.getTableName(1));
            System.out.println(rsMetadata.getColumnName(1));
            System.out.println(rsMetadata.getColumnType(1));
            System.out.println(rsMetadata.getColumnCount());
            System.out.println(rsMetadata.getColumnClassName(2));
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2));
////            Log.info(rs.getInt(1) + " " + rs.getString(2));
//            }

            //test insert
//            int rows = s.executeUpdate("INSERT INTO REGIONS VALUES(5,'ANTARTICA')");
//            System.out.println(rows);

            //test update
//            int rows = s.executeUpdate("UPDATE REGIONS SET REGION_NAME = '' WHERE REGION_ID = 5");
//            System.out.println(rows);


            //test Delete
//            System.out.println(s.executeUpdate("DELETE FROM REGIONS WHERE REGION_ID = 5"));

            //Prepared Statement
            st=conn.prepareStatement("INSERT INTO REGIONS VALUES(?,?");
            st.setInt(1,6);
            st.setString(2,"Antartica");
            int r = st.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if ( rs != null )
                    rs.close();
                if ( s != null )
                    s.close();
                if ( conn != null )
                    conn.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }
}