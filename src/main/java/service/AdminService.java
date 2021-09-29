package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
public class AdminService {
    private String query;
    ResultSet rs;
	private Connection connection = JDBCConnection.getJDBCConnection();
    
    public List<Admin> getAllAdmin(){

    	List<Admin> admin = new ArrayList<Admin>();
    	try {
    		Statement statement = connection.createStatement();
    		query = "SELECT * FROM admin";
    		rs = statement.executeQuery(query);
    		while(rs.next()) {
    			String username = rs.getString("username");
    			String password = rs.getString("password");
    		    System.out.printf("%s %s\n", username, password);
    			Admin a = new Admin(username, password);
    		    admin.add(a);

    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    
		return admin;
    }
    
    public boolean checkLoginAdmin(String username, String pass) {
    	List<Admin> admin = getAllAdmin();
    	for(Admin i : admin) {
    		if(i.getUsername().equals(username) && i.getPassword().equals(pass))
    			return true;	
    	}
    	return false;
    }
    
    public Admin getAdminById(String username) {
    	List<Admin> admin = getAllAdmin();
    	Admin a = new Admin();
    	for(Admin i : admin) {
    		if(i.getUsername().equals(username)) {
    			a = i;
    			break;
    		}
    	}
    	return a;
    }
    
    
}
