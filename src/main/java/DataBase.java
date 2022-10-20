import java.sql.*;
import java.util.ArrayList;

public class DataBase {
	
	Connection con;			// Connection Object
	Statement st;			// Statement Object
	
	String url = "jdbc:mysql://localhost:3306/employeemanagment";
	
	// constructor | Make connection
	DataBase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");			// Register Driver
		con = DriverManager.getConnection(url ,"root","851438"); // get Connection
		st = con.createStatement();					// get statement	
	}
	
	// function for checking the credentials
	boolean login(String name, String password) throws Exception {
		String queryString = "select * from login where name = ? and password = ?";
		
		PreparedStatement pr = con.prepareStatement(queryString);
		pr.setString(1, name);
		pr.setString(2, password);
		
		ResultSet rSet = pr.executeQuery();
		
		if(rSet.next()) {
			return true;
		}
		
		return false;
	}
	
}
