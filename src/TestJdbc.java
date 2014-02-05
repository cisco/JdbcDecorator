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
