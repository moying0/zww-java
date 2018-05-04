package com.bfei.icrane.core.dao;

import java.sql.Connection;
import java.sql.Statement;

//import com.mchange.v2.c3p0.AbstractConnectionCustomizer;

public class UTF8MB4ConnectionCustomizer //extends AbstractConnectionCustomizer
{
	
	public void onAcquire(Connection c, String parentDataSourceIdentityToken) throws java.lang.Exception {
		Statement stmt = null;       
		try {           
			stmt = c.createStatement();            
			stmt.executeUpdate("SET names utf8mb4");        
			} finally {           
				if (stmt != null) stmt.close();        
				}
	}
}