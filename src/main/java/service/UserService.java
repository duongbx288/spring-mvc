package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserService {
    private String query;
    ResultSet rs;
    private Connection connection = JDBCConnection.getJDBCConnection();

    public List<User> getAllUser(){
    	List<User> user = new ArrayList<User>();
    	try {
    		Statement statement = connection.createStatement();
    		query = "SELECT * FROM user";
    		rs = statement.executeQuery(query);
    		while(rs.next()) {
    			String username = rs.getString("username");
    			String password = rs.getString("password");
    			String fullname = rs.getString("fullname");
    			String address = rs.getString("address");
    			String phone = rs.getString("phone");
    			String email = rs.getString("email");
    			Date birthday = rs.getDate("birthday");
    			System.out.print(email + birthday);
    			User u = new User(username, password, fullname, address, phone, email, birthday);
    			user.add(u);
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return user;
    }
    
    public boolean addUser(User u) {
    	   try {
    		   query = "INSERT INTO user(user_id, username, password, fullname, address, phone, email, birthday)"
                        +" VALUES(?,?,?,?,?,?,?)";
    		   PreparedStatement ps = connection.prepareStatement(query);
    		   ps.setString(2, u.getUsername());
    		   ps.setString(3, u.getPassword());
    		   ps.setString(4, u.getFullname());
    		   ps.setString(5, u.getAddress());
    		   ps.setString(6, u.getPhone());
    		   ps.setString(7, u.getEmail());
    		   ps.setDate(8, new Date(u.getBirthday().getTime()));
    		   
    		   return ps.executeUpdate() > 0;
    	   } catch (SQLException e) {
    		   e.printStackTrace();
    	       }
    	return false;
    }
    
    public void deleteUser(int userid) {
    	try {
    		query = "DELETE * FROM user WHERE user_id = '" + userid +"'";
    		PreparedStatement ps = connection.prepareStatement(query);
    		ps.executeUpdate();
    	} catch (SQLException e3) {
    		e3.printStackTrace();
    	}
    }
    
    public boolean checkLoginUser(String username, String pass) {
    	List<User> user = getAllUser();
    	for(User i : user) {
    		if(i.getUsername().equals(username) && i.getPassword().equals(pass))
    			return true;
    	}
    	return false;
    }
    
    public User getUserById(String username) {
    	User a = new User();
    	List<User> user = getAllUser();
    	for(User i : user) {
    		if(i.getUsername().equals(username)) {
    			a = i;
    			break;
    		}
    	}
    	return a;
    }
    
    
}
