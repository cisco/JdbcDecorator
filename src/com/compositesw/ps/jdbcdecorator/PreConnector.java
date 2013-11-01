package com.compositesw.ps.jdbcdecorator;

import java.util.Properties;
import java.sql.SQLException;

public class PreConnector {
    protected Properties props;
    protected String url;

    public PreConnector() {
    }

    public void setProperties(Properties props) {
        this.props = props;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean process()
        throws SQLException
    {
        return true;
    }

    public Properties getProperties()
        throws SQLException
    {
        return props;
    }

    public String getUrl()
        throws SQLException
    {
        return url;
    }

}
