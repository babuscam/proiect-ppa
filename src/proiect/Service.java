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

import shared.ConnectionFailException;

/**
 *
 * @author
 */
public class Service {
	protected static Connection getConnection(){
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?autoReconnect=true&useSSL=false",
					"root", "Parola12#");
			if (con.isClosed()) {
				System.out.println("conexiune esuata.");
				throw new ConnectionFailException("Conexiunea la baza de date a esuat.");
			}
			
			return con;
		} catch (SQLException e) {
			throw new ConnectionFailException("A aparut o eroare la conectarea cu baza de date.");
		}
	}
}
