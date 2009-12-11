/**
 * GeradorTesteDB.java
 *
 * Data: 10/12/2009
 */
package br.com.ap.gerador;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author adriano.pamplona
 * 
 */
public class GeradorTesteDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new org.postgresql.Driver();
		String url = "jdbc:postgresql://ARCTURUS:5432/tjgo_copes_desenv";
		String user = "frotasweb";
		String pass = "frotasweb";
		Connection c = null;
		try {
			DriverManager.registerDriver(driver);
			c = DriverManager.getConnection(url, user, pass);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {}
			c = null;
		}

	}

}
