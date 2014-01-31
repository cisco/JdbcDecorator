package com.compositesw.ps.jdbcdecorator;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;


public class DecoratorConnection implements Connection {

    public static final String DECORATOR_DRIVER_CLASS_NAME = "com.compositesw.ps.jdbcdecorator.DecoratorDriver";
    public static final String JDBC_URL_PREFIX = "jdbcdecorator:";
    public static final String PROPERTY_PREFIX = "jdbcdecorator.";
    public static final String DRIVER_CLASS_NAME = PROPERTY_PREFIX + "driverclassname";
    public static final String SQL_FILTER_CLASS_NAME = PROPERTY_PREFIX + "sqlfilterclassname";
    public static final String META_DATA_PROVIDER_CLASS_NAME = PROPERTY_PREFIX + "metadataproviderclassname";
    public static final String PRE_CONNECTOR_CLASS_NAME = PROPERTY_PREFIX + "preconnectorclassname";
    public static final String RESULT_SET_CLASS_NAME = PROPERTY_PREFIX + "resultsetclassname";
    public static final String LOG_FILE = PROPERTY_PREFIX + "logfile";


    private String url;
    private Properties props;
    private Properties decoratorProps;
    private PreConnector preConnector;
    private Connection conn;
    private SqlFilter sqlFilter;

    private Class drsClass;
    private boolean autoCommit = true;
    private boolean closed = false;
    private int transactionIsolation = TRANSACTION_READ_UNCOMMITTED;
    public PrintStream logStream;

    public DecoratorConnection(String url, Properties props)
        throws SQLException 
    {
        decoratorProps = new Properties();
        Set propsSet = props.keySet();

        for (Object propObj : propsSet) {
            if (!(propObj instanceof String))
                continue;
            String propName = (String)propObj;
            if (propName.startsWith(PROPERTY_PREFIX)) {
                decoratorProps.setProperty(propName,props.getProperty(propName));
            }
        }

        String logFileName = decoratorProps.getProperty(LOG_FILE);
        if (logFileName == null) {
            logStream = null;
        }
        else if (logFileName.equals("-")) {
            logStream = System.out;
        }
        else {
            try {
                File logFile = new File(logFileName);
                if (logFile.isDirectory()) {
                    logFile = File.createTempFile("DecoratorConnection_",".log",logFile);
                }
                else {
                    logFile.createNewFile();
                }
                if (!logFile.canWrite()) {
                    System.err.println("DecoratorConnection: can't write to log file " + logFile.getCanonicalPath());
                }
                logStream = new PrintStream(logFile);
            }
            catch (IOException ioe) {
                ioe.printStackTrace(System.err);
            }
        }

        propsSet = decoratorProps.keySet();
        for (Object propObj : propsSet) {
            props.remove(propObj);
        }
        this.url = url.substring(JDBC_URL_PREFIX.length());
        this.props = props;

        String driverClassName = decoratorProps.getProperty(DRIVER_CLASS_NAME);
        if (driverClassName == null) {
            throw new SQLException("Property " + DRIVER_CLASS_NAME + " must be defined!");
        }
        try {
            Class.forName(driverClassName);
        }
        catch (ClassNotFoundException cnfe) {
            throw new SQLException(cnfe);
        }

        if (logStream != null) {
            logStream.println("DecoratorConnection: new connection");
            logStream.println("DecoratorConnection: url = " + this.url);
            logStream.println("DecoratorConnection: properties = ");
            for (String name : this.props.stringPropertyNames()) {
                logStream.print("\t");
                logStream.print(name);
                logStream.print(" = ");
                if ("password".equals(name)) {
                    logStream.println("********");
                }
                else {
                    logStream.println(this.props.getProperty(name));
                }
            }
        }
        String preConnectorClassName = decoratorProps.getProperty(PRE_CONNECTOR_CLASS_NAME);
        if (preConnectorClassName != null) {
            try {
                Class preConnectorClass = Class.forName(preConnectorClassName);
                this.preConnector = (PreConnector)preConnectorClass.newInstance();
            }
            catch (ClassNotFoundException cnfe) {
                throw new SQLException(cnfe);
            }
            catch (InstantiationException ie) {
                throw new SQLException(ie);
            }
            catch (IllegalAccessException iae) {
                throw new SQLException(iae);
            }
        }
        else {
            preConnector = new PreConnector();
        }
        if (preConnectorClassName != null) {
            preConnector.setProperties(this.props);
            preConnector.setUrl(this.url);
            preConnector.process();
            this.props = preConnector.getProperties();
            this.url = preConnector.getUrl();
            if (logStream != null) {
                logStream.println("DecoratorConnection: after preconnector");
                logStream.println("DecoratorConnection: url = " + this.url);
                logStream.println("DecoratorConnection: properties = ");
                for (String name : this.props.stringPropertyNames()) {
                    logStream.print("\t");
                    logStream.print(name);
                    logStream.print(" = ");
                    if ("password".equals(name)) {
                        logStream.println("********");
                    }
                    else {
                        logStream.println(this.props.getProperty(name));
                    }
                }
            }
        }
            
        this.conn = DriverManager.getConnection(this.url, this.props);

        String sqlFilterClassName = decoratorProps.getProperty(SQL_FILTER_CLASS_NAME);
        if (sqlFilterClassName != null) {
            try {
                Class sqlFilterClass = Class.forName(sqlFilterClassName);
                this.sqlFilter = (SqlFilter)sqlFilterClass.newInstance();
            }
            catch (ClassNotFoundException cnfe) {
                throw new SQLException(cnfe);
            }
            catch (InstantiationException ie) {
                throw new SQLException(ie);
            }
            catch (IllegalAccessException iae) {
                throw new SQLException(iae);
            }
        }
        else {
            sqlFilter = new SqlFilter();
        }

        String drsClassName = decoratorProps.getProperty(DecoratorConnection.RESULT_SET_CLASS_NAME);
        if (drsClassName != null) {
            try {
                drsClass = Class.forName(drsClassName);
            }
            catch (ClassNotFoundException cnfe) {
                throw new SQLException(cnfe);
            }
        }
        else {
            drsClass = DecoratorResultSet.class;
        }
    };

    public Statement createStatement() 
        throws SQLException
    {
        Statement stmt = conn.createStatement();
        DecoratorStatement ds = new DecoratorStatement(this, stmt);
        ds.setDecoratorProperties(decoratorProps);
        ds.setDecoratorResultSetClass(drsClass);
        ds.setSqlFilter(sqlFilter);
        return ds;
    };

    public Statement createStatement(int resultSetType, int resultSetConcurrency) 
        throws SQLException
    {
        Statement stmt = conn.createStatement(resultSetType, resultSetConcurrency);
        DecoratorStatement ds = new DecoratorStatement(this, stmt);
        ds.setDecoratorProperties(decoratorProps);
        ds.setDecoratorResultSetClass(drsClass);
        ds.setSqlFilter(sqlFilter);
        return ds;
    };

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) 
        throws SQLException
    {
        Statement stmt = conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        DecoratorStatement ds = new DecoratorStatement(this, stmt);
        ds.setDecoratorProperties(decoratorProps);
        ds.setDecoratorResultSetClass(drsClass);
        ds.setSqlFilter(sqlFilter);
        return ds;
    };

    public void setAutoCommit(boolean autoCommit) 
        throws SQLException
    {
        conn.setAutoCommit(autoCommit);
    };

    public boolean getAutoCommit() 
        throws SQLException
    {
        return conn.getAutoCommit();
    };

    public void commit() 
        throws SQLException
    {
        conn.commit();
    };

    public void rollback() 
        throws SQLException
    {
        conn.rollback();
    };

    public void close() 
        throws SQLException
    {
        conn.close();
    };

    public boolean isClosed() 
        throws SQLException
    {
        return conn.isClosed();
    };

    public DatabaseMetaData getMetaData() 
        throws SQLException
    {
        DatabaseMetaData dbmd = null;
        String metaDataProviderClassName = decoratorProps.getProperty(META_DATA_PROVIDER_CLASS_NAME);
        Class metaDataProviderClass;
        
        if (metaDataProviderClassName == null) {
            metaDataProviderClassName = "com.compositesw.ps.jdbcdecorator.MetaDataProvider";
        }

        try {
            metaDataProviderClass = Class.forName(metaDataProviderClassName);
            java.lang.reflect.Constructor constructor = metaDataProviderClass.getConstructor(Connection.class);
            dbmd = (DatabaseMetaData)constructor.newInstance(conn);
        }
        catch (ClassNotFoundException cnfe) {
            throw new SQLException(cnfe);
        }
        catch (NoSuchMethodException nsme) {
            throw new SQLException(nsme);
        }
        catch (InstantiationException ie) {
            throw new SQLException(ie);
        }
        catch (IllegalAccessException iae) {
            throw new SQLException(iae);
        }
        catch (IllegalArgumentException iarge) {
            throw new SQLException(iarge);
        }
        catch (java.lang.reflect.InvocationTargetException ite) {
            throw new SQLException(ite);
        }
        return dbmd;
    };

    public void setTransactionIsolation(int isolation) 
        throws SQLException
    {
        conn.setTransactionIsolation(isolation);
    };

    public int getTransactionIsolation() 
        throws SQLException
    {
        return conn.getTransactionIsolation();
    };

    public PreparedStatement prepareStatement(String stmt, int int1, int int2, int int3) 
        throws SQLException
    {
        return conn.prepareStatement(stmt, int1, int2, int3); 
    };

    public CallableStatement prepareCall(String stmt, int int1, int int2, int int3) 
        throws SQLException
    {
        return conn.prepareCall(stmt, int1, int2, int3);
    };

    public PreparedStatement prepareStatement(String stmt) 
        throws SQLException
    {
        return conn.prepareStatement(stmt);
    };

    public CallableStatement prepareCall(String stmt) 
        throws SQLException
    {
        return conn.prepareCall(stmt);
    };

    public String nativeSQL(String stmt) 
        throws SQLException
    {
        return conn.nativeSQL(stmt);
    };

    public void setReadOnly(boolean readonly) 
        throws SQLException
    {
        conn.setReadOnly(readonly);
    };

    public boolean isReadOnly() 
        throws SQLException
    {
        return conn.isReadOnly();
    };

    public void setCatalog(String catalog) 
        throws SQLException
    {
        conn.setCatalog(catalog);
    };

    public String getCatalog() 
        throws SQLException
    {
        return conn.getCatalog();
    };

    public SQLWarning getWarnings() 
        throws SQLException
    {
        return conn.getWarnings();
    };

    public void clearWarnings() 
        throws SQLException
    {
        conn.clearWarnings();
    };

    public PreparedStatement prepareStatement(String stmt, int int1, int int2) 
        throws SQLException
    {
        return conn.prepareStatement(stmt, int1, int2);
    };

    public CallableStatement prepareCall(String stmt, int int1, int int2) 
        throws SQLException
    {
        return conn.prepareCall(stmt, int1, int2);
    };

    public java.util.Map getTypeMap() 
        throws SQLException
    {
        return conn.getTypeMap();
    };

    public void setTypeMap(Map typeMap) 
        throws SQLException
    {
        conn.setTypeMap(typeMap);
    };

    public void setHoldability(int holdability) 
        throws SQLException
    {
        conn.setHoldability(holdability);
    };

    public int getHoldability() 
        throws SQLException
    {
        return conn.getHoldability();
    };

    public Savepoint setSavepoint() 
        throws SQLException
    {
        return conn.setSavepoint();
    };

    public Savepoint setSavepoint(String savepoint) 
        throws SQLException
    {
        return conn.setSavepoint(savepoint);
    };

    public void rollback(Savepoint savepoint) 
        throws SQLException
    {
        conn.rollback(savepoint);
    };

    public void releaseSavepoint(Savepoint savepoint) 
        throws SQLException
    {
        conn.releaseSavepoint(savepoint);
    };

    public PreparedStatement prepareStatement(String stmt, int int1) 
        throws SQLException
    {
        return conn.prepareStatement(stmt, int1);
    };

    public PreparedStatement prepareStatement(String stmt, int[] intarray) 
        throws SQLException
    {
        return conn.prepareStatement(stmt, intarray);
    };

    public PreparedStatement prepareStatement(String stmt, String[] stringarray) 
        throws SQLException
    {
        return conn.prepareStatement(stmt, stringarray);
    };

    public Clob createClob() 
        throws SQLException
    {
        return conn.createClob();
    };

    public Blob createBlob() 
        throws SQLException
    {
        return conn.createBlob();
    };

    public NClob createNClob() 
        throws SQLException
    {
        return conn.createNClob();
    };

    public SQLXML createSQLXML() 
        throws SQLException
    {
        return conn.createSQLXML();
    };

    public boolean isValid(int valid) 
        throws SQLException
    {
        return conn.isValid(valid);
    };

    public void setClientInfo(String string1, String string2) 
        throws SQLClientInfoException
    {
        conn.setClientInfo(string1, string2);
    };

    public void setClientInfo(Properties clientInfo) 
        throws SQLClientInfoException
    {
        conn.setClientInfo(clientInfo);
    };

    public String getClientInfo(String clientInfo) 
        throws SQLException
    {
        return conn.getClientInfo(clientInfo);
    };

    public Properties getClientInfo() 
        throws SQLException
    {
        return conn.getClientInfo();
    };

    public Array createArrayOf(String string1, Object[] objectarray1) 
        throws SQLException
    {
        return conn.createArrayOf(string1,objectarray1);
    };

    public Struct createStruct(String string1, Object[] objectarray1) 
        throws SQLException
    {
        return conn.createStruct(string1,objectarray1);
    };

    public Object unwrap(Class cls)
        throws SQLException
    {
        return conn.unwrap(cls);
    };

    public boolean isWrapperFor(Class cls)
        throws SQLException
    {
        return conn.isWrapperFor(cls);
    };
}


