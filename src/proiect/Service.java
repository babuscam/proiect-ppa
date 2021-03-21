/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class Service {
	protected static Connection getConnection(){
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?autoReconnect=true&useSSL=false",
					"root", "123456");
			if (con.isClosed()) {
				System.out.println("conexiune esuata.");
			}
			
			return con;
		} catch (SQLException e) {
			return null;
		}
	}
}
