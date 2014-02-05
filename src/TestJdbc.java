import java.sql.*;
import java.util.Properties;

public class TestJdbc {
    public static void main(String[] args)
        throws Exception
    {
        Class.forName("com.cisco.dvbu.ps.jdbcdecorator.DecoratorDriver");

        Properties props = new Properties();
        props.setProperty("jdbcdecorator.driverclassname","com.mysql.jdbc.Driver");
        props.setProperty("jdbcdecorator.sqlfilterclassname","MySqlFilter");
        props.setProperty("user","root");
        props.setProperty("password","composite");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        DatabaseMetaData dbmd = null;
        try {
            conn = DriverManager.getConnection("jdbcdecorator:jdbc:mysql://localhost:3306/mysql", props);
            try {
                dbmd = conn.getMetaData();
                rs = dbmd.getColumns("","","","");

                while(rs.next()) {
                    System.out.print(rs.getString(1));
                    System.out.print('\t');
                    System.out.print(rs.getString(2));
                    System.out.print('\t');
                    System.out.print(rs.getString(3));
                    System.out.print('\t');
                    System.out.print(rs.getString(4));
                    System.out.print('\t');
                    System.out.print(rs.getString(5));
                    System.out.print('\t');
                    System.out.print(rs.getString(6));
                    System.out.print('\n');
                }
                
                stmt = conn.createStatement();
                try {
                    rs = stmt.executeQuery("SELECT DISTINCT Db from db");

                    while(rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                }
                finally {
                    if (rs != null) {
                        rs.close();
                    }
                }
            }
            finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        finally {
            if (conn != null) {
                if (!conn.isClosed())
                    conn.close();
            }
        }

    };
}
