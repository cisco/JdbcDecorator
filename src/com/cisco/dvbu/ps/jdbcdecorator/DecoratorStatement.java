package com.cisco.dvbu.ps.jdbcdecorator;

import java.sql.*;
import java.util.Properties;

public class DecoratorStatement implements Statement {

    private Connection conn;
    private Statement stmt;
    private Properties decoratorProps;
    private SqlFilter sqlFilter;
    private Class drsClass;

    public DecoratorStatement(Connection connection, Statement stmt) {
        this.conn = conn;
        this.stmt = stmt;
    };

    public void setDecoratorProperties(Properties props)
    {
        this.decoratorProps = props;
    }

    public void setSqlFilter(SqlFilter sqlFilter) {
        this.sqlFilter = sqlFilter;
    }

    public void setDecoratorResultSetClass(Class drsClass) {
        this.drsClass = drsClass;
    }

    private ResultSet newResultSet(ResultSet rs)
        throws SQLException
    {
        DecoratorResultSet instance;
        try {
            instance = (DecoratorResultSet)drsClass.newInstance();
        }
        catch (Exception e) {
            throw new SQLException(e);
        }
        instance.setDecoratorProperties(decoratorProps);
        instance.setStatement(this);
        instance.setResultSet(rs);

        return instance;
    }


    public boolean execute(String queryTxt) 
        throws SQLException
    {
        String sql = sqlFilter.filterExecute(queryTxt);
        return stmt.execute(sql);
    };
    public ResultSet executeQuery(String queryTxt) 
        throws SQLException
    {
        String sql = sqlFilter.filterExecuteQuery(queryTxt);
        ResultSet rs = stmt.executeQuery(sql);
        return newResultSet(rs);
    };

    public int executeUpdate(String queryTxt) 
        throws SQLException
    {
        String sql = sqlFilter.filterExecuteUpdate(queryTxt);
        return stmt.executeUpdate(sql);
    };
    public void close() 
        throws SQLException
    {
        stmt.close();
    };
    public int getMaxFieldSize() 
        throws SQLException
    {
        return stmt.getMaxFieldSize();
    };
    public void setMaxFieldSize(int fieldSize) 
        throws SQLException
    {
        stmt.setMaxFieldSize(fieldSize);
    };
    public int getMaxRows() 
        throws SQLException
    {
        return stmt.getMaxRows();
    };
    public void setMaxRows(int maxRows) 
        throws SQLException
    {
        stmt.setMaxRows(maxRows);
    };
    public void setEscapeProcessing(boolean escapeProcessing) 
        throws SQLException
    {
        stmt.setEscapeProcessing(escapeProcessing);
    };
    public int getQueryTimeout() 
        throws SQLException
    {
        return stmt.getQueryTimeout();
    };
    public void setQueryTimeout(int timeout) 
        throws SQLException
    {
        stmt.setQueryTimeout(timeout);
    };
    public void cancel() 
        throws SQLException
    {
        stmt.cancel();
    };
    public SQLWarning getWarnings() 
        throws SQLException
    {
        return stmt.getWarnings();
    };
    public void clearWarnings() 
        throws SQLException
    {
        stmt.clearWarnings();
    };
    public void setCursorName(String cursorName) 
        throws SQLException
    {
        stmt.setCursorName(cursorName);
    };
    public ResultSet getResultSet() 
        throws SQLException
    {
        ResultSet rs = stmt.getResultSet();
        return newResultSet(rs);
    };
    public int getUpdateCount() 
        throws SQLException
    {
        return stmt.getUpdateCount();
    };
    public boolean getMoreResults() 
        throws SQLException
    {
        return stmt.getMoreResults();
    };
    public void setFetchDirection(int fetchDirection) 
        throws SQLException
    {
        stmt.setFetchDirection(fetchDirection);
    };
    public int getFetchDirection() 
        throws SQLException
    {
        return stmt.getFetchDirection();
    };
    public void setFetchSize(int fetchSize) 
        throws SQLException
    {
        stmt.setFetchSize(fetchSize);
    };
    public int getFetchSize() 
        throws SQLException
    {
        return stmt.getFetchSize();
    };
    public int getResultSetConcurrency() 
        throws SQLException
    {
        return stmt.getResultSetConcurrency();
    };
    public int getResultSetType() 
        throws SQLException
    {
        return stmt.getResultSetType();
    };
    public void addBatch(String queryTxt) 
        throws SQLException
    {
        stmt.addBatch(queryTxt);
    };
    public void clearBatch() 
        throws SQLException
    {
        stmt.clearBatch();
    };
    public int[] executeBatch() 
        throws SQLException
    {
        return stmt.executeBatch();
    };
    public Connection getConnection() 
        throws SQLException
    {
        return conn;
    };
    public boolean getMoreResults(int current) 
        throws SQLException
    {
        return stmt.getMoreResults(current);
    };
    public ResultSet getGeneratedKeys() 
        throws SQLException
    {
        return stmt.getGeneratedKeys();
    };
    public int executeUpdate(String queryTxt, int autoGeneratedKeys) 
        throws SQLException
    {
        return stmt.executeUpdate(queryTxt, autoGeneratedKeys); 
    };
    public int executeUpdate(String queryTxt, int[] columnIndexes) 
        throws SQLException
    {
        return stmt.executeUpdate(queryTxt, columnIndexes); 
    };
    public int executeUpdate(String queryTxt, String[] columnNames) 
        throws SQLException
    {
        return stmt.executeUpdate(queryTxt, columnNames); 
    };
    public boolean execute(String queryTxt, int autoGeneratedKeys) 
        throws SQLException
    {
        return stmt.execute(queryTxt, autoGeneratedKeys); 
    };
    public boolean execute(String queryTxt, int[] columnIndexes) 
        throws SQLException
    {
        return stmt.execute(queryTxt, columnIndexes); 
    };
    public boolean execute(String queryTxt, String[] columnNames) 
        throws SQLException
    {
        return stmt.execute(queryTxt, columnNames); 
    };
    public int getResultSetHoldability() 
        throws SQLException
    {
        return stmt.getResultSetHoldability();
    };
    public boolean isClosed() 
        throws SQLException
    {
        return stmt.isClosed();
    };
    public void setPoolable(boolean poolable) 
        throws SQLException
    {
        stmt.setPoolable(poolable);
    };
    public boolean isPoolable() 
        throws SQLException
    {
        return stmt.isPoolable();
    };

    public Object unwrap(Class cls)
        throws SQLException
    {
        return stmt.unwrap(cls);
    };

    public boolean isWrapperFor(Class cls)
        throws SQLException
    {
        return stmt.isWrapperFor(cls);
    };
}
