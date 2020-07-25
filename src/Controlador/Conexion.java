/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adriana Abad
 */
public class Conexion {
	
	private static Connection conexion = null;
	     
	static{
	  String URL ="jdbc:mysql://localhost/a_prueba?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	  String User = "root";
	  String Pass = "";
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection(URL, User, Pass);
	}
	catch(ClassNotFoundException e){
        e.printStackTrace();
	  } catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public Connection getConnection(){
		return conexion;            
	}   
   
	
}
