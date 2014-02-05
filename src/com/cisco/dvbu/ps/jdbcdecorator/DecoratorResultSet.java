/*
Copyright (c) 2014, Cisco Systems
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, this
  list of conditions and the following disclaimer in the documentation and/or
  other materials provided with the distribution.

* Neither the name of the {organization} nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/


package com.cisco.dvbu.ps.jdbcdecorator;

import java.sql.*;
import java.util.Properties;


public class DecoratorResultSet implements ResultSet {

    //private static Logger logger = Logger.getLogger(HistorianStatement.class.getName());

    protected Statement stmt;
    protected ResultSet rs;
    protected Properties decoratorProps;

    public DecoratorResultSet() {
        super();
    }

    public DecoratorResultSet(Statement stmt, ResultSet rs) {
        this();
        this.stmt = stmt;
        this.rs = rs;
    };

    public void setStatement(Statement stmt) {
        this.stmt = stmt;
    }

    public void setResultSet(ResultSet rs) {
        this.rs = rs;
    }

    public void setDecoratorProperties(Properties props)
    {
        this.decoratorProps = props;
    }

    public boolean next()
       throws SQLException
    {
        return rs.next();
    }


    public void close()
       throws SQLException
    {
        rs.close();
    }


    public boolean wasNull()
       throws SQLException
    {
        return rs.wasNull();
    }


    public String getString(int column)
       throws SQLException
    {
        return rs.getString(column);
    }


    public boolean getBoolean(int column)
       throws SQLException
    {
        return rs.getBoolean(column);
    }


    public byte getByte(int column)
       throws SQLException
    {
        return rs.getByte(column);
    }


    public short getShort(int column)
       throws SQLException
    {
        return rs.getShort(column);
    }


    public int getInt(int column)
       throws SQLException
    {
        return rs.getInt(column);
    }


    public long getLong(int column)
       throws SQLException
    {
        return rs.getLong(column);
    }


    public float getFloat(int column)
       throws SQLException
    {
        return rs.getFloat(column);
    }


    public double getDouble(int column)
       throws SQLException
    {
        return rs.getDouble(column);
    }


    public java.math.BigDecimal getBigDecimal(int column, int scale)
       throws SQLException
    {
        return rs.getBigDecimal(column, scale);
    }


    public byte[] getBytes(int column)
       throws SQLException
    {
        return rs.getBytes(column);
    }


    public Date getDate(int column)
       throws SQLException
    {
        return rs.getDate(column);
    }


    public Time getTime(int column)
       throws SQLException
    {
        return rs.getTime(column);
    }


    public Timestamp getTimestamp(int column)
       throws SQLException
    {
        return rs.getTimestamp(column);
    }


    public java.io.InputStream getAsciiStream(int column)
       throws SQLException
    {
        return rs.getAsciiStream(column);
    }


    public java.io.InputStream getUnicodeStream(int column)
       throws SQLException
    {
        return rs.getUnicodeStream(column);
    }


    public java.io.InputStream getBinaryStream(int column)
       throws SQLException
    {
        return rs.getBinaryStream(column);
    }


    public String getString(String columnName)
       throws SQLException
    {
        return rs.getString(columnName);
    }


    public boolean getBoolean(String columnName)
       throws SQLException
    {
        return rs.getBoolean(columnName);
    }


    public byte getByte(String columnName)
       throws SQLException
    {
        return rs.getByte(columnName);
    }


    public short getShort(String columnName)
       throws SQLException
    {
        return rs.getShort(columnName);
    }


    public int getInt(String columnName)
       throws SQLException
    {
        return rs.getInt(columnName);
    }


    public long getLong(String columnName)
       throws SQLException
    {
        return rs.getLong(columnName);
    }


    public float getFloat(String columnName)
       throws SQLException
    {
        return rs.getFloat(columnName);
    }


    public double getDouble(String columnName)
       throws SQLException
    {
        return rs.getDouble(columnName);
    }


    public java.math.BigDecimal getBigDecimal(String columnName, int scale)
       throws SQLException
    {
        return rs.getBigDecimal(columnName, scale);
    }


    public byte[] getBytes(String columnName)
       throws SQLException
    {
        return rs.getBytes(columnName);
    }


    public Date getDate(String columnName)
       throws SQLException
    {
        return rs.getDate(columnName);
    }


    public Time getTime(String columnName)
       throws SQLException
    {
        return rs.getTime(columnName);
    }


    public Timestamp getTimestamp(String columnName)
       throws SQLException
    {
        return rs.getTimestamp(columnName);
    }


    public java.io.InputStream getAsciiStream(String columnName)
       throws SQLException
    {
        return rs.getAsciiStream(columnName);
    }


    public java.io.InputStream getUnicodeStream(String columnName)
       throws SQLException
    {
        return rs.getUnicodeStream(columnName);
    }


    public java.io.InputStream getBinaryStream(String columnName)
       throws SQLException
    {
        return rs.getBinaryStream(columnName);
    }


    public SQLWarning getWarnings()
       throws SQLException
    {
        return rs.getWarnings();
    }


    public void clearWarnings()
       throws SQLException
    {
        rs.clearWarnings();
    }


    public String getCursorName()
       throws SQLException
    {
        return rs.getCursorName();
    }


    public ResultSetMetaData getMetaData()
       throws SQLException
    {
        return rs.getMetaData();
    }


    public Object getObject(int column)
       throws SQLException
    {
        return rs.getObject(column);
    }


    public Object getObject(String columnName)
       throws SQLException
    {
        return rs.getObject(columnName);
    }


    public int findColumn(String columnName)
       throws SQLException
    {
        return rs.findColumn(columnName);
    }


    public java.io.Reader getCharacterStream(int column)
       throws SQLException
    {
        return rs.getCharacterStream(column);
    }


    public java.io.Reader getCharacterStream(String columnName)
       throws SQLException
    {
        return rs.getCharacterStream(columnName);
    }


    public java.math.BigDecimal getBigDecimal(int column)
       throws SQLException
    {
        return rs.getBigDecimal(column);
    }


    public java.math.BigDecimal getBigDecimal(String columnName)
       throws SQLException
    {
        return rs.getBigDecimal(columnName);
    }


    public boolean isBeforeFirst()
       throws SQLException
    {
        return rs.isBeforeFirst();
    }


    public boolean isAfterLast()
       throws SQLException
    {
        return rs.isAfterLast();
    }


    public boolean isFirst()
       throws SQLException
    {
        return rs.isFirst();
    }


    public boolean isLast()
       throws SQLException
    {
        return rs.isLast();
    }


    public void beforeFirst()
       throws SQLException
    {
        rs.beforeFirst();
    }


    public void afterLast()
       throws SQLException
    {
        rs.afterLast();
    }


    public boolean first()
       throws SQLException
    {
        return rs.first();
    }


    public boolean last()
       throws SQLException
    {
        return rs.last();
    }


    public int getRow()
       throws SQLException
    {
        return rs.getRow();
    }


    public boolean absolute(int row)
       throws SQLException
    {
        return rs.absolute(row);
    }


    public boolean relative(int row)
       throws SQLException
    {
        return rs.relative(row);
    }


    public boolean previous()
       throws SQLException
    {
        return rs.previous();
    }


    public void setFetchDirection(int direction)
       throws SQLException
    {
        rs.setFetchDirection(direction);
    }


    public int getFetchDirection()
       throws SQLException
    {
        return rs.getFetchDirection();
    }


    public void setFetchSize(int size)
       throws SQLException
    {
        rs.setFetchSize(size);
    }


    public int getFetchSize()
       throws SQLException
    {
        return rs.getFetchSize();
    }


    public int getType()
       throws SQLException
    {
        return rs.getType();
    }


    public int getConcurrency()
       throws SQLException
    {
        return rs.getConcurrency();
    }


    public boolean rowUpdated()
       throws SQLException
    {
        return rs.rowUpdated();
    }


    public boolean rowInserted()
       throws SQLException
    {
        return rs.rowInserted();
    }


    public boolean rowDeleted()
       throws SQLException
    {
        return rs.rowDeleted();
    }


    public void updateNull(int column)
       throws SQLException
    {
        rs.updateNull(column);
    }


    public void updateBoolean(int column, boolean value)
       throws SQLException
    {
        rs.updateBoolean(column, value);
    }


    public void updateByte(int column, byte value)
       throws SQLException
    {
        rs.updateByte(column, value);
    }


    public void updateShort(int column, short value)
       throws SQLException
    {
        rs.updateShort(column, value);
    }


    public void updateInt(int column, int value)
       throws SQLException
    {
        rs.updateInt(column, value);
    }


    public void updateLong(int column, long value)
       throws SQLException
    {
        rs.updateLong(column, value);
    }


    public void updateFloat(int column, float value)
       throws SQLException
    {
        rs.updateFloat(column, value);
    }


    public void updateDouble(int column, double value)
       throws SQLException
    {
        rs.updateDouble(column, value);
    }


    public void updateBigDecimal(int column, java.math.BigDecimal value)
       throws SQLException
    {
        rs.updateBigDecimal(column, value);
    }


    public void updateString(int column, String value)
       throws SQLException
    {
        rs.updateString(column, value);
    }


    public void updateBytes(int column, byte[] value)
       throws SQLException
    {
        rs.updateBytes(column, value);
    }


    public void updateDate(int column, Date value)
       throws SQLException
    {
        rs.updateDate(column, value);
    }


    public void updateTime(int column, Time value)
       throws SQLException
    {
        rs.updateTime(column, value);
    }


    public void updateTimestamp(int column, Timestamp value)
       throws SQLException
    {
        rs.updateTimestamp(column, value);
    }


    public void updateAsciiStream(int column, java.io.InputStream value, int length)
       throws SQLException
    {
        rs.updateAsciiStream(column, value, length);
    }


    public void updateBinaryStream(int column, java.io.InputStream value, int length)
       throws SQLException
    {
        rs.updateBinaryStream(column, value, length);
    }


    public void updateCharacterStream(int column, java.io.Reader value, int length)
       throws SQLException
    {
        rs.updateCharacterStream(column, value, length);
    }


    public void updateObject(int column, Object value, int scaleOrLength)
       throws SQLException
    {
        rs.updateObject(column, value, scaleOrLength);
    }


    public void updateObject(int column, Object value)
       throws SQLException
    {
        rs.updateObject(column, value);
    }


    public void updateNull(String columnName)
       throws SQLException
    {
        rs.updateNull(columnName);
    }


    public void updateBoolean(String columnName, boolean value)
       throws SQLException
    {
        rs.updateBoolean(columnName, value);
    }


    public void updateByte(String columnName, byte value)
       throws SQLException
    {
        rs.updateByte(columnName, value);
    }


    public void updateShort(String columnName, short value)
       throws SQLException
    {
        rs.updateShort(columnName, value);
    }


    public void updateInt(String columnName, int value)
       throws SQLException
    {
        rs.updateInt(columnName, value);
    }


    public void updateLong(String columnName, long value)
       throws SQLException
    {
        rs.updateLong(columnName, value);
    }


    public void updateFloat(String columnName, float value)
       throws SQLException
    {
        rs.updateFloat(columnName, value);
    }


    public void updateDouble(String columnName, double value)
       throws SQLException
    {
        rs.updateDouble(columnName, value);
    }


    public void updateBigDecimal(String columnName, java.math.BigDecimal value)
       throws SQLException
    {
        rs.updateBigDecimal(columnName, value);
    }


    public void updateString(String columnName, String value)
       throws SQLException
    {
        rs.updateString(columnName, value);
    }


    public void updateBytes(String columnName, byte[] value)
       throws SQLException
    {
        rs.updateBytes(columnName, value);
    }


    public void updateDate(String columnName, Date value)
       throws SQLException
    {
        rs.updateDate(columnName, value);
    }


    public void updateTime(String columnName, Time value)
       throws SQLException
    {
        rs.updateTime(columnName, value);
    }


    public void updateTimestamp(String columnName, Timestamp value)
       throws SQLException
    {
        rs.updateTimestamp(columnName, value);
    }


    public void updateAsciiStream(String columnName, java.io.InputStream value, int length)
       throws SQLException
    {
        rs.updateAsciiStream(columnName, value, length);
    }


    public void updateBinaryStream(String columnName, java.io.InputStream value, int length)
       throws SQLException
    {
        rs.updateBinaryStream(columnName, value, length);
    }


    public void updateCharacterStream(String columnName, java.io.Reader value, int length)
       throws SQLException
    {
        rs.updateCharacterStream(columnName, value, length);
    }


    public void updateObject(String columnName, Object value, int scaleOrLength)
       throws SQLException
    {
        rs.updateObject(columnName, value, scaleOrLength);
    }


    public void updateObject(String columnName, Object value)
       throws SQLException
    {
        rs.updateObject(columnName, value);
    }


    public void insertRow()
       throws SQLException
    {
        rs.insertRow();
    }


    public void updateRow()
       throws SQLException
    {
        rs.updateRow();
    }


    public void deleteRow()
       throws SQLException
    {
        rs.deleteRow();
    }


    public void refreshRow()
       throws SQLException
    {
        rs.refreshRow();
    }


    public void cancelRowUpdates()
       throws SQLException
    {
        rs.cancelRowUpdates();
    }


    public void moveToInsertRow()
       throws SQLException
    {
        rs.moveToInsertRow();
    }


    public void moveToCurrentRow()
       throws SQLException
    {
        rs.moveToCurrentRow();
    }


    public Statement getStatement()
       throws SQLException
    {
        return stmt;
    }


    public Object getObject(int column, java.util.Map map)
       throws SQLException
    {
        return rs.getObject(column, map);
    }


    public Ref getRef(int column)
       throws SQLException
    {
        return rs.getRef(column);
    }


    public Blob getBlob(int column)
       throws SQLException
    {
        return rs.getBlob(column);
    }


    public Clob getClob(int column)
       throws SQLException
    {
        return rs.getClob(column);
    }


    public Array getArray(int column)
       throws SQLException
    {
        return rs.getArray(column);
    }


    public Object getObject(String columnName, java.util.Map map)
       throws SQLException
    {
        return rs.getObject(columnName, map);
    }


    public Ref getRef(String columnName)
       throws SQLException
    {
        return rs.getRef(columnName);
    }


    public Blob getBlob(String columnName)
       throws SQLException
    {
        return rs.getBlob(columnName);
    }


    public Clob getClob(String columnName)
       throws SQLException
    {
        return rs.getClob(columnName);
    }


    public Array getArray(String columnName)
       throws SQLException
    {
        return rs.getArray(columnName);
    }


    public Date getDate(int column, java.util.Calendar calendar)
       throws SQLException
    {
        return rs.getDate(column, calendar);
    }


    public Date getDate(String columnName, java.util.Calendar calendar)
       throws SQLException
    {
        return rs.getDate(columnName, calendar);
    }


    public Time getTime(int column, java.util.Calendar calendar)
       throws SQLException
    {
        return rs.getTime(column, calendar);
    }


    public Time getTime(String columnName, java.util.Calendar calendar)
       throws SQLException
    {
        return rs.getTime(columnName, calendar);
    }


    public Timestamp getTimestamp(int column, java.util.Calendar calendar)
       throws SQLException
    {
        return rs.getTimestamp(column, calendar);
    }


    public Timestamp getTimestamp(String columnName, java.util.Calendar calendar)
       throws SQLException
    {
        return rs.getTimestamp(columnName, calendar);
    }


    public java.net.URL getURL(int column)
       throws SQLException
    {
        return rs.getURL(column);
    }


    public java.net.URL getURL(String columnName)
       throws SQLException
    {
        return rs.getURL(columnName);
    }


    public void updateRef(int column, Ref value)
       throws SQLException
    {
        rs.updateRef(column, value);
    }


    public void updateRef(String columnName, Ref value)
       throws SQLException
    {
        rs.updateRef(columnName, value);
    }


    public void updateBlob(int column, Blob value)
       throws SQLException
    {
        rs.updateBlob(column, value);
    }


    public void updateBlob(String columnName, Blob value)
       throws SQLException
    {
        rs.updateBlob(columnName, value);
    }


    public void updateClob(int column, Clob value)
       throws SQLException
    {
        rs.updateClob(column, value);
    }


    public void updateClob(String columnName, Clob value)
       throws SQLException
    {
        rs.updateClob(columnName, value);
    }


    public void updateArray(int column, Array value)
       throws SQLException
    {
        rs.updateArray(column, value);
    }


    public void updateArray(String columnName, Array value)
       throws SQLException
    {
        rs.updateArray(columnName, value);
    }


    public RowId getRowId(int column)
       throws SQLException
    {
        return rs.getRowId(column);
    }


    public RowId getRowId(String columnName)
       throws SQLException
    {
        return rs.getRowId(columnName);
    }


    public void updateRowId(int column, RowId value)
       throws SQLException
    {
        rs.updateRowId(column, value);
    }


    public void updateRowId(String columnName, RowId value)
       throws SQLException
    {
        rs.updateRowId(columnName, value);
    }


    public int getHoldability()
       throws SQLException
    {
        return rs.getHoldability();
    }


    public boolean isClosed()
       throws SQLException
    {
        return rs.isClosed();
    }


    public void updateNString(int column, String value)
       throws SQLException
    {
        rs.updateNString(column, value);
    }


    public void updateNString(String columnName, String value)
       throws SQLException
    {
        rs.updateNString(columnName, value);
    }


    public void updateNClob(int column, NClob value)
       throws SQLException
    {
        rs.updateNClob(column, value);
    }


    public void updateNClob(String columnName, NClob value)
       throws SQLException
    {
        rs.updateNClob(columnName, value);
    }


    public NClob getNClob(int column)
       throws SQLException
    {
        return rs.getNClob(column);
    }


    public NClob getNClob(String columnName)
       throws SQLException
    {
        return rs.getNClob(columnName);
    }


    public SQLXML getSQLXML(int column)
       throws SQLException
    {
        return rs.getSQLXML(column);
    }


    public SQLXML getSQLXML(String columnName)
       throws SQLException
    {
        return rs.getSQLXML(columnName);
    }


    public void updateSQLXML(int column, SQLXML value)
       throws SQLException
    {
        rs.updateSQLXML(column, value);
    }


    public void updateSQLXML(String columnName, SQLXML value)
       throws SQLException
    {
        rs.updateSQLXML(columnName, value);
    }


    public String getNString(int column)
       throws SQLException
    {
        return rs.getNString(column);
    }


    public String getNString(String columnName)
       throws SQLException
    {
        return rs.getNString(columnName);
    }


    public java.io.Reader getNCharacterStream(int column)
       throws SQLException
    {
        return rs.getNCharacterStream(column);
    }


    public java.io.Reader getNCharacterStream(String columnName)
       throws SQLException
    {
        return rs.getNCharacterStream(columnName);
    }


    public void updateNCharacterStream(int column, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateNCharacterStream(column, value, length);
    }


    public void updateNCharacterStream(String columnName, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateNCharacterStream(columnName, value, length);
    }


    public void updateAsciiStream(int column, java.io.InputStream value, long length)
       throws SQLException
    {
        rs.updateAsciiStream(column, value, length);
    }


    public void updateBinaryStream(int column, java.io.InputStream value, long length)
       throws SQLException
    {
        rs.updateBinaryStream(column, value, length);
    }


    public void updateCharacterStream(int column, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateCharacterStream(column, value, length);
    }


    public void updateAsciiStream(String columnName, java.io.InputStream value, long length)
       throws SQLException
    {
        rs.updateAsciiStream(columnName, value, length);
    }


    public void updateBinaryStream(String columnName, java.io.InputStream value, long length)
       throws SQLException
    {
        rs.updateBinaryStream(columnName, value, length);
    }


    public void updateCharacterStream(String columnName, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateCharacterStream(columnName, value, length);
    }


    public void updateBlob(int column, java.io.InputStream value, long length)
       throws SQLException
    {
        rs.updateBlob(column, value, length);
    }


    public void updateBlob(String columnName, java.io.InputStream value, long length)
       throws SQLException
    {
        rs.updateBlob(columnName, value, length);
    }


    public void updateClob(int column, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateClob(column, value, length);
    }


    public void updateClob(String columnName, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateClob(columnName, value, length);
    }


    public void updateNClob(int column, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateNClob(column, value, length);
    }


    public void updateNClob(String columnName, java.io.Reader value, long length)
       throws SQLException
    {
        rs.updateNClob(columnName, value, length);
    }


    public void updateNCharacterStream(int column, java.io.Reader value)
       throws SQLException
    {
        rs.updateNCharacterStream(column, value);
    }


    public void updateNCharacterStream(String columnName, java.io.Reader value)
       throws SQLException
    {
        rs.updateNCharacterStream(columnName, value);
    }


    public void updateAsciiStream(int column, java.io.InputStream value)
       throws SQLException
    {
        rs.updateAsciiStream(column, value);
    }


    public void updateBinaryStream(int column, java.io.InputStream value)
       throws SQLException
    {
        rs.updateBinaryStream(column, value);
    }


    public void updateCharacterStream(int column, java.io.Reader value)
       throws SQLException
    {
        rs.updateCharacterStream(column, value);
    }


    public void updateAsciiStream(String columnName, java.io.InputStream value)
       throws SQLException
    {
        rs.updateAsciiStream(columnName, value);
    }


    public void updateBinaryStream(String columnName, java.io.InputStream value)
       throws SQLException
    {
        rs.updateBinaryStream(columnName, value);
    }


    public void updateCharacterStream(String columnName, java.io.Reader value)
       throws SQLException
    {
        rs.updateCharacterStream(columnName, value);
    }


    public void updateBlob(int column, java.io.InputStream value)
       throws SQLException
    {
        rs.updateBlob(column, value);
    }


    public void updateBlob(String columnName, java.io.InputStream value)
       throws SQLException
    {
        rs.updateBlob(columnName, value);
    }


    public void updateClob(int column, java.io.Reader value)
       throws SQLException
    {
        rs.updateClob(column, value);
    }


    public void updateClob(String columnName, java.io.Reader value)
       throws SQLException
    {
        rs.updateClob(columnName, value);
    }


    public void updateNClob(int column, java.io.Reader value)
       throws SQLException
    {
        rs.updateNClob(column, value);
    }


    public void updateNClob(String columnName, java.io.Reader value)
       throws SQLException
    {
        rs.updateNClob(columnName, value);
    }

    public Object unwrap(Class cls)
        throws SQLException
    {
        return rs.unwrap(cls);
    };

    public boolean isWrapperFor(Class cls)
        throws SQLException
    {
        return rs.isWrapperFor(cls);
    };
}
