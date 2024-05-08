package loginpackagedou1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import loginpackagebean1.Loginbean;

public class Logindou {
private String dbUrl="jdbc:mysql://localhost:3306/login";
private String dbUname="root";
private String dbPassword="sam1312";
private String dbDriver="com.mysql.cj.jdbc.Driver";

public void loadDriver(String dbDriver) {
	try {
		Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public Connection getConnection() {
	Connection con= null;
	try {
	con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return con;
}

public boolean validate (Loginbean beanobj) {
	loadDriver(dbDriver);
	Connection con= getConnection();
	boolean status=false;
	String query="select * from login.log where username=? and password=?";
	PreparedStatement ps;
	try {
	ps=con.prepareStatement(query);
	ps.setString(1, beanobj.getUsername());
	ps.setString(2, beanobj.getPassword());
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	return status;
	
}
}
