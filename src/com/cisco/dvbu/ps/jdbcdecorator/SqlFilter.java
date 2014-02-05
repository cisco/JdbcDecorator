package com.cisco.dvbu.ps.jdbcdecorator;

import java.util.Properties;
import java.sql.SQLException;

public class SqlFilter {
    private Properties props;

    public SqlFilter() {
    }

    public void setProperties(Properties props) {
        this.props = props;
    }

    public String filterExecute(String sqlTxt)
        throws SQLException
    {
        return sqlTxt;
    }

    public String filterExecuteQuery(String sqlTxt)
        throws SQLException
    {
        return filterExecute(sqlTxt);
    }

    public String filterExecuteUpdate(String sqlTxt)
        throws SQLException
    {
        return filterExecute(sqlTxt);
    }

}

