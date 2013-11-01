package com.compositesw.ps.jdbcdecorator;

import java.sql.*;
import java.util.Properties;

public class DecoratorDriver implements Driver {
    static {
        try {
            DriverManager.registerDriver(new DecoratorDriver());
        }
        catch(SQLException sqle) {
            System.err.println("Unable to register com.compositesw.ps.jdbcdecorator.DecoratorDriver.");
            System.err.println(sqle);
        }
    };

    public DecoratorDriver() {
    };

    public boolean acceptsURL(String url) {
        if (url.startsWith("jdbcdecorator:")) {
            return true;
        }

        return false;
    };

    public Connection connect(String url, Properties props)
        throws SQLException 
    {
        if (!acceptsURL(url))
            return null;

        return new DecoratorConnection(url, props);
    };

    public int getMajorVersion() {
        return 0;
    };

    public int getMinorVersion() {
        return 0;
    };

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties props) {
        return null;
    };

    public boolean jdbcCompliant() {
        return false;
    };
}
