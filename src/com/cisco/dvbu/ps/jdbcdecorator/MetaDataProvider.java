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

import java.util.Properties;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;

public class MetaDataProvider implements DatabaseMetaData {

    protected Connection conn;
    private DatabaseMetaData dbmd;

    public MetaDataProvider(Connection conn)
        throws SQLException
    {
        this.conn = conn;
        dbmd = conn.getMetaData();
    }

    public boolean allProceduresAreCallable()
       throws SQLException
    {
        return dbmd.allProceduresAreCallable();
    }

    public boolean allTablesAreSelectable()
       throws SQLException
    {
        return dbmd.allTablesAreSelectable();
    }

    public String getURL()
       throws SQLException
    {
        return dbmd.getURL();
    }

    public String getUserName()
       throws SQLException
    {
        return dbmd.getUserName();
    }

    public boolean isReadOnly()
       throws SQLException
    {
        return dbmd.isReadOnly();
    }

    public boolean nullsAreSortedHigh()
       throws SQLException
    {
        return dbmd.nullsAreSortedHigh();
    }

    public boolean nullsAreSortedLow()
       throws SQLException
    {
        return dbmd.nullsAreSortedLow();
    }

    public boolean nullsAreSortedAtStart()
       throws SQLException
    {
        return dbmd.nullsAreSortedAtStart();
    }

    public boolean nullsAreSortedAtEnd()
       throws SQLException
    {
        return dbmd.nullsAreSortedAtEnd();
    }

    public String getDatabaseProductName()
       throws SQLException
    {
        return dbmd.getDatabaseProductName();
    }

    public String getDatabaseProductVersion()
       throws SQLException
    {
        return dbmd.getDatabaseProductVersion();
    }

    public String getDriverName()
       throws SQLException
    {
        return dbmd.getDriverName();
    }

    public String getDriverVersion()
       throws SQLException
    {
        return dbmd.getDriverVersion();
    }

    public int getDriverMajorVersion()

    {
        return dbmd.getDriverMajorVersion();
    }

    public int getDriverMinorVersion()

    {
        return dbmd.getDriverMinorVersion();
    }

    public boolean usesLocalFiles()
       throws SQLException
    {
        return dbmd.usesLocalFiles();
    }

    public boolean usesLocalFilePerTable()
       throws SQLException
    {
        return dbmd.usesLocalFilePerTable();
    }

    public boolean supportsMixedCaseIdentifiers()
       throws SQLException
    {
        return dbmd.supportsMixedCaseIdentifiers();
    }

    public boolean storesUpperCaseIdentifiers()
       throws SQLException
    {
        return dbmd.storesUpperCaseIdentifiers();
    }

    public boolean storesLowerCaseIdentifiers()
       throws SQLException
    {
        return dbmd.storesLowerCaseIdentifiers();
    }

    public boolean storesMixedCaseIdentifiers()
       throws SQLException
    {
        return dbmd.storesMixedCaseIdentifiers();
    }

    public boolean supportsMixedCaseQuotedIdentifiers()
       throws SQLException
    {
        return dbmd.supportsMixedCaseQuotedIdentifiers();
    }

    public boolean storesUpperCaseQuotedIdentifiers()
       throws SQLException
    {
        return dbmd.storesUpperCaseQuotedIdentifiers();
    }

    public boolean storesLowerCaseQuotedIdentifiers()
       throws SQLException
    {
        return dbmd.storesLowerCaseQuotedIdentifiers();
    }

    public boolean storesMixedCaseQuotedIdentifiers()
       throws SQLException
    {
        return dbmd.storesMixedCaseQuotedIdentifiers();
    }

    public String getIdentifierQuoteString()
       throws SQLException
    {
        return dbmd.getIdentifierQuoteString();
    }

    public String getSQLKeywords()
       throws SQLException
    {
        return dbmd.getSQLKeywords();
    }

    public String getNumericFunctions()
       throws SQLException
    {
        return dbmd.getNumericFunctions();
    }

    public String getStringFunctions()
       throws SQLException
    {
        return dbmd.getStringFunctions();
    }

    public String getSystemFunctions()
       throws SQLException
    {
        return dbmd.getSystemFunctions();
    }

    public String getTimeDateFunctions()
       throws SQLException
    {
        return dbmd.getTimeDateFunctions();
    }

    public String getSearchStringEscape()
       throws SQLException
    {
        return dbmd.getSearchStringEscape();
    }

    public String getExtraNameCharacters()
       throws SQLException
    {
        return dbmd.getExtraNameCharacters();
    }

    public boolean supportsAlterTableWithAddColumn()
       throws SQLException
    {
        return dbmd.supportsAlterTableWithAddColumn();
    }

    public boolean supportsAlterTableWithDropColumn()
       throws SQLException
    {
        return dbmd.supportsAlterTableWithDropColumn();
    }

    public boolean supportsColumnAliasing()
       throws SQLException
    {
        return dbmd.supportsColumnAliasing();
    }

    public boolean nullPlusNonNullIsNull()
       throws SQLException
    {
        return dbmd.nullPlusNonNullIsNull();
    }

    public boolean supportsConvert()
       throws SQLException
    {
        return dbmd.supportsConvert();
    }

    public boolean supportsConvert(int int1, int int2)
       throws SQLException
    {
        return dbmd.supportsConvert(int1, int2);
    }

    public boolean supportsTableCorrelationNames()
       throws SQLException
    {
        return dbmd.supportsTableCorrelationNames();
    }

    public boolean supportsDifferentTableCorrelationNames()
       throws SQLException
    {
        return dbmd.supportsDifferentTableCorrelationNames();
    }

    public boolean supportsExpressionsInOrderBy()
       throws SQLException
    {
        return dbmd.supportsExpressionsInOrderBy();
    }

    public boolean supportsOrderByUnrelated()
       throws SQLException
    {
        return dbmd.supportsOrderByUnrelated();
    }

    public boolean supportsGroupBy()
       throws SQLException
    {
        return dbmd.supportsGroupBy();
    }

    public boolean supportsGroupByUnrelated()
       throws SQLException
    {
        return dbmd.supportsGroupByUnrelated();
    }

    public boolean supportsGroupByBeyondSelect()
       throws SQLException
    {
        return dbmd.supportsGroupByBeyondSelect();
    }

    public boolean supportsLikeEscapeClause()
       throws SQLException
    {
        return dbmd.supportsLikeEscapeClause();
    }

    public boolean supportsMultipleResultSets()
       throws SQLException
    {
        return dbmd.supportsMultipleResultSets();
    }

    public boolean supportsMultipleTransactions()
       throws SQLException
    {
        return dbmd.supportsMultipleTransactions();
    }

    public boolean supportsNonNullableColumns()
       throws SQLException
    {
        return dbmd.supportsNonNullableColumns();
    }

    public boolean supportsMinimumSQLGrammar()
       throws SQLException
    {
        return dbmd.supportsMinimumSQLGrammar();
    }

    public boolean supportsCoreSQLGrammar()
       throws SQLException
    {
        return dbmd.supportsCoreSQLGrammar();
    }

    public boolean supportsExtendedSQLGrammar()
       throws SQLException
    {
        return dbmd.supportsExtendedSQLGrammar();
    }

    public boolean supportsANSI92EntryLevelSQL()
       throws SQLException
    {
        return dbmd.supportsANSI92EntryLevelSQL();
    }

    public boolean supportsANSI92IntermediateSQL()
       throws SQLException
    {
        return dbmd.supportsANSI92IntermediateSQL();
    }

    public boolean supportsANSI92FullSQL()
       throws SQLException
    {
        return dbmd.supportsANSI92FullSQL();
    }

    public boolean supportsIntegrityEnhancementFacility()
       throws SQLException
    {
        return dbmd.supportsIntegrityEnhancementFacility();
    }

    public boolean supportsOuterJoins()
       throws SQLException
    {
        return dbmd.supportsOuterJoins();
    }

    public boolean supportsFullOuterJoins()
       throws SQLException
    {
        return dbmd.supportsFullOuterJoins();
    }

    public boolean supportsLimitedOuterJoins()
       throws SQLException
    {
        return dbmd.supportsLimitedOuterJoins();
    }

    public String getSchemaTerm()
       throws SQLException
    {
        return dbmd.getSchemaTerm();
    }

    public String getProcedureTerm()
       throws SQLException
    {
        return dbmd.getProcedureTerm();
    }

    public String getCatalogTerm()
       throws SQLException
    {
        return dbmd.getCatalogTerm();
    }

    public boolean isCatalogAtStart()
       throws SQLException
    {
        return dbmd.isCatalogAtStart();
    }

    public String getCatalogSeparator()
       throws SQLException
    {
        return dbmd.getCatalogSeparator();
    }

    public boolean supportsSchemasInDataManipulation()
       throws SQLException
    {
        return dbmd.supportsSchemasInDataManipulation();
    }

    public boolean supportsSchemasInProcedureCalls()
       throws SQLException
    {
        return dbmd.supportsSchemasInProcedureCalls();
    }

    public boolean supportsSchemasInTableDefinitions()
       throws SQLException
    {
        return dbmd.supportsSchemasInTableDefinitions();
    }

    public boolean supportsSchemasInIndexDefinitions()
       throws SQLException
    {
        return dbmd.supportsSchemasInIndexDefinitions();
    }

    public boolean supportsSchemasInPrivilegeDefinitions()
       throws SQLException
    {
        return dbmd.supportsSchemasInPrivilegeDefinitions();
    }

    public boolean supportsCatalogsInDataManipulation()
       throws SQLException
    {
        return dbmd.supportsCatalogsInDataManipulation();
    }

    public boolean supportsCatalogsInProcedureCalls()
       throws SQLException
    {
        return dbmd.supportsCatalogsInProcedureCalls();
    }

    public boolean supportsCatalogsInTableDefinitions()
       throws SQLException
    {
        return dbmd.supportsCatalogsInTableDefinitions();
    }

    public boolean supportsCatalogsInIndexDefinitions()
       throws SQLException
    {
        return dbmd.supportsCatalogsInIndexDefinitions();
    }

    public boolean supportsCatalogsInPrivilegeDefinitions()
       throws SQLException
    {
        return dbmd.supportsCatalogsInPrivilegeDefinitions();
    }

    public boolean supportsPositionedDelete()
       throws SQLException
    {
        return dbmd.supportsPositionedDelete();
    }

    public boolean supportsPositionedUpdate()
       throws SQLException
    {
        return dbmd.supportsPositionedUpdate();
    }

    public boolean supportsSelectForUpdate()
       throws SQLException
    {
        return dbmd.supportsSelectForUpdate();
    }

    public boolean supportsStoredProcedures()
       throws SQLException
    {
        return dbmd.supportsStoredProcedures();
    }

    public boolean supportsSubqueriesInComparisons()
       throws SQLException
    {
        return dbmd.supportsSubqueriesInComparisons();
    }

    public boolean supportsSubqueriesInExists()
       throws SQLException
    {
        return dbmd.supportsSubqueriesInExists();
    }

    public boolean supportsSubqueriesInIns()
       throws SQLException
    {
        return dbmd.supportsSubqueriesInIns();
    }

    public boolean supportsSubqueriesInQuantifieds()
       throws SQLException
    {
        return dbmd.supportsSubqueriesInQuantifieds();
    }

    public boolean supportsCorrelatedSubqueries()
       throws SQLException
    {
        return dbmd.supportsCorrelatedSubqueries();
    }

    public boolean supportsUnion()
       throws SQLException
    {
        return dbmd.supportsUnion();
    }

    public boolean supportsUnionAll()
       throws SQLException
    {
        return dbmd.supportsUnionAll();
    }

    public boolean supportsOpenCursorsAcrossCommit()
       throws SQLException
    {
        return dbmd.supportsOpenCursorsAcrossCommit();
    }

    public boolean supportsOpenCursorsAcrossRollback()
       throws SQLException
    {
        return dbmd.supportsOpenCursorsAcrossRollback();
    }

    public boolean supportsOpenStatementsAcrossCommit()
       throws SQLException
    {
        return dbmd.supportsOpenStatementsAcrossCommit();
    }

    public boolean supportsOpenStatementsAcrossRollback()
       throws SQLException
    {
        return dbmd.supportsOpenStatementsAcrossRollback();
    }

    public int getMaxBinaryLiteralLength()
       throws SQLException
    {
        return dbmd.getMaxBinaryLiteralLength();
    }

    public int getMaxCharLiteralLength()
       throws SQLException
    {
        return dbmd.getMaxCharLiteralLength();
    }

    public int getMaxColumnNameLength()
       throws SQLException
    {
        return dbmd.getMaxColumnNameLength();
    }

    public int getMaxColumnsInGroupBy()
       throws SQLException
    {
        return dbmd.getMaxColumnsInGroupBy();
    }

    public int getMaxColumnsInIndex()
       throws SQLException
    {
        return dbmd.getMaxColumnsInIndex();
    }

    public int getMaxColumnsInOrderBy()
       throws SQLException
    {
        return dbmd.getMaxColumnsInOrderBy();
    }

    public int getMaxColumnsInSelect()
       throws SQLException
    {
        return dbmd.getMaxColumnsInSelect();
    }

    public int getMaxColumnsInTable()
       throws SQLException
    {
        return dbmd.getMaxColumnsInTable();
    }

    public int getMaxConnections()
       throws SQLException
    {
        return dbmd.getMaxConnections();
    }

    public int getMaxCursorNameLength()
       throws SQLException
    {
        return dbmd.getMaxCursorNameLength();
    }

    public int getMaxIndexLength()
       throws SQLException
    {
        return dbmd.getMaxIndexLength();
    }

    public int getMaxSchemaNameLength()
       throws SQLException
    {
        return dbmd.getMaxSchemaNameLength();
    }

    public int getMaxProcedureNameLength()
       throws SQLException
    {
        return dbmd.getMaxProcedureNameLength();
    }

    public int getMaxCatalogNameLength()
       throws SQLException
    {
        return dbmd.getMaxCatalogNameLength();
    }

    public int getMaxRowSize()
       throws SQLException
    {
        return dbmd.getMaxRowSize();
    }

    public boolean doesMaxRowSizeIncludeBlobs()
       throws SQLException
    {
        return dbmd.doesMaxRowSizeIncludeBlobs();
    }

    public int getMaxStatementLength()
       throws SQLException
    {
        return dbmd.getMaxStatementLength();
    }

    public int getMaxStatements()
       throws SQLException
    {
        return dbmd.getMaxStatements();
    }

    public int getMaxTableNameLength()
       throws SQLException
    {
        return dbmd.getMaxTableNameLength();
    }

    public int getMaxTablesInSelect()
       throws SQLException
    {
        return dbmd.getMaxTablesInSelect();
    }

    public int getMaxUserNameLength()
       throws SQLException
    {
        return dbmd.getMaxUserNameLength();
    }

    public int getDefaultTransactionIsolation()
       throws SQLException
    {
        return dbmd.getDefaultTransactionIsolation();
    }

    public boolean supportsTransactions()
       throws SQLException
    {
        return dbmd.supportsTransactions();
    }

    public boolean supportsTransactionIsolationLevel(int int1)
       throws SQLException
    {
        return dbmd.supportsTransactionIsolationLevel(int1);
    }

    public boolean supportsDataDefinitionAndDataManipulationTransactions()
       throws SQLException
    {
        return dbmd.supportsDataDefinitionAndDataManipulationTransactions();
    }

    public boolean supportsDataManipulationTransactionsOnly()
       throws SQLException
    {
        return dbmd.supportsDataManipulationTransactionsOnly();
    }

    public boolean dataDefinitionCausesTransactionCommit()
       throws SQLException
    {
        return dbmd.dataDefinitionCausesTransactionCommit();
    }

    public boolean dataDefinitionIgnoredInTransactions()
       throws SQLException
    {
        return dbmd.dataDefinitionIgnoredInTransactions();
    }

    public ResultSet getProcedures(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getProcedures(string1, string2, string3);
    }

    public ResultSet getProcedureColumns(String string1, String string2, String string3, String string4)
       throws SQLException
    {
        return dbmd.getProcedureColumns(string1, string2, string3, string4);
    }

    public ResultSet getTables(String string1, String string2, String string3, String[] strings)
       throws SQLException
    {
        return dbmd.getTables(string1, string2, string3, strings);
    }

    public ResultSet getSchemas()
       throws SQLException
    {
        return dbmd.getSchemas();
    }

    public ResultSet getCatalogs()
       throws SQLException
    {
        return dbmd.getCatalogs();
    }

    public ResultSet getTableTypes()
       throws SQLException
    {
        return dbmd.getTableTypes();
    }

    public ResultSet getColumns(String string1, String string2, String string3, String string4)
       throws SQLException
    {
        return dbmd.getColumns(string1, string2, string3, string4);
    }

    public ResultSet getColumnPrivileges(String string1, String string2, String string3, String string4)
       throws SQLException
    {
        return dbmd.getColumnPrivileges(string1, string2, string3, string4);
    }

    public ResultSet getTablePrivileges(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getTablePrivileges(string1, string2, string3);
    }

    public ResultSet getBestRowIdentifier(String string1, String string2, String string3, int int1, boolean boolean1)
       throws SQLException
    {
        return dbmd.getBestRowIdentifier(string1, string2, string3, int1, boolean1);
    }

    public ResultSet getVersionColumns(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getVersionColumns(string1, string2, string3);
    }

    public ResultSet getPrimaryKeys(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getPrimaryKeys(string1, string2, string3);
    }

    public ResultSet getImportedKeys(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getImportedKeys(string1, string2, string3);
    }

    public ResultSet getExportedKeys(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getExportedKeys(string1, string2, string3);
    }

    public ResultSet getCrossReference(String string1, String string2, String string3, String string4, String string5, String string6)
       throws SQLException
    {
        return dbmd.getCrossReference(string1, string2, string3, string4, string5, string6);
    }

    public ResultSet getTypeInfo()
       throws SQLException
    {
        return dbmd.getTypeInfo();
    }

    public ResultSet getIndexInfo(String string1, String string2, String string3, boolean boolean1, boolean boolean2)
       throws SQLException
    {
        return dbmd.getIndexInfo(string1, string2, string3, boolean1, boolean2);
    }

    public boolean supportsResultSetType(int int1)
       throws SQLException
    {
        return dbmd.supportsResultSetType(int1);
    }

    public boolean supportsResultSetConcurrency(int int1, int int2)
       throws SQLException
    {
        return dbmd.supportsResultSetConcurrency(int1, int2);
    }

    public boolean ownUpdatesAreVisible(int int1)
       throws SQLException
    {
        return dbmd.ownUpdatesAreVisible(int1);
    }

    public boolean ownDeletesAreVisible(int int1)
       throws SQLException
    {
        return dbmd.ownDeletesAreVisible(int1);
    }

    public boolean ownInsertsAreVisible(int int1)
       throws SQLException
    {
        return dbmd.ownInsertsAreVisible(int1);
    }

    public boolean othersUpdatesAreVisible(int int1)
       throws SQLException
    {
        return dbmd.othersUpdatesAreVisible(int1);
    }

    public boolean othersDeletesAreVisible(int int1)
       throws SQLException
    {
        return dbmd.othersDeletesAreVisible(int1);
    }

    public boolean othersInsertsAreVisible(int int1)
       throws SQLException
    {
        return dbmd.othersInsertsAreVisible(int1);
    }

    public boolean updatesAreDetected(int int1)
       throws SQLException
    {
        return dbmd.updatesAreDetected(int1);
    }

    public boolean deletesAreDetected(int int1)
       throws SQLException
    {
        return dbmd.deletesAreDetected(int1);
    }

    public boolean insertsAreDetected(int int1)
       throws SQLException
    {
        return dbmd.insertsAreDetected(int1);
    }

    public boolean supportsBatchUpdates()
       throws SQLException
    {
        return dbmd.supportsBatchUpdates();
    }

    public ResultSet getUDTs(String string1, String string2, String string3, int[] ints)
       throws SQLException
    {
        return dbmd.getUDTs(string1, string2, string3, ints);
    }

    public Connection getConnection()
       throws SQLException
    {
        return dbmd.getConnection();
    }

    public boolean supportsSavepoints()
       throws SQLException
    {
        return dbmd.supportsSavepoints();
    }

    public boolean supportsNamedParameters()
       throws SQLException
    {
        return dbmd.supportsNamedParameters();
    }

    public boolean supportsMultipleOpenResults()
       throws SQLException
    {
        return dbmd.supportsMultipleOpenResults();
    }

    public boolean supportsGetGeneratedKeys()
       throws SQLException
    {
        return dbmd.supportsGetGeneratedKeys();
    }

    public ResultSet getSuperTypes(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getSuperTypes(string1, string2, string3);
    }

    public ResultSet getSuperTables(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getSuperTables(string1, string2, string3);
    }

    public ResultSet getAttributes(String string1, String string2, String string3, String string4)
       throws SQLException
    {
        return dbmd.getAttributes(string1, string2, string3, string4);
    }

    public boolean supportsResultSetHoldability(int int1)
       throws SQLException
    {
        return dbmd.supportsResultSetHoldability(int1);
    }

    public int getResultSetHoldability()
       throws SQLException
    {
        return dbmd.getResultSetHoldability();
    }

    public int getDatabaseMajorVersion()
       throws SQLException
    {
        return dbmd.getDatabaseMajorVersion();
    }

    public int getDatabaseMinorVersion()
       throws SQLException
    {
        return dbmd.getDatabaseMinorVersion();
    }

    public int getJDBCMajorVersion()
       throws SQLException
    {
        return dbmd.getJDBCMajorVersion();
    }

    public int getJDBCMinorVersion()
       throws SQLException
    {
        return dbmd.getJDBCMinorVersion();
    }

    public int getSQLStateType()
       throws SQLException
    {
        return dbmd.getSQLStateType();
    }

    public boolean locatorsUpdateCopy()
       throws SQLException
    {
        return dbmd.locatorsUpdateCopy();
    }

    public boolean supportsStatementPooling()
       throws SQLException
    {
        return dbmd.supportsStatementPooling();
    }

    public RowIdLifetime getRowIdLifetime()
       throws SQLException
    {
        return dbmd.getRowIdLifetime();
    }

    public ResultSet getSchemas(String string1, String string2)
       throws SQLException
    {
        return dbmd.getSchemas(string1, string2);
    }

    public boolean supportsStoredFunctionsUsingCallSyntax()
       throws SQLException
    {
        return dbmd.supportsStoredFunctionsUsingCallSyntax();
    }

    public boolean autoCommitFailureClosesAllResultSets()
       throws SQLException
    {
        return dbmd.autoCommitFailureClosesAllResultSets();
    }

    public ResultSet getClientInfoProperties()
       throws SQLException
    {
        return dbmd.getClientInfoProperties();
    }

    public ResultSet getFunctions(String string1, String string2, String string3)
       throws SQLException
    {
        return dbmd.getFunctions(string1, string2, string3);
    }

    public ResultSet getFunctionColumns(String string1, String string2, String string3, String string4)
       throws SQLException
    {
        return dbmd.getFunctionColumns(string1, string2, string3, string4);
    }

    public Object unwrap(Class class1)
        throws java.sql.SQLException
    {
        return dbmd.unwrap(class1);
    }

    public boolean isWrapperFor(Class class1)
        throws java.sql.SQLException
    {
        return dbmd.isWrapperFor(class1);
    }
}



