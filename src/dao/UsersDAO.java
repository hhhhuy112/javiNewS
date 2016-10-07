package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Category;
import bean.Users;

public class UsersDAO {
	Database db=new Database();
	public ArrayList<Users> getListUsers() {
		ArrayList<Users> listUsers = new ArrayList<Users>();
		String query = "Select username , password , fullname,address,phone from users";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Users users;
			while(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				listUsers.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUsers;
	}
	public Users checkLogin(Users user) {
		Users users = null;
		String query = "Select username , password , fullname,address,phone from users where username = '"+user.getUsername()+"' and password = '"+user.getPassword()+"'";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	public int numberAllNews() {
		String query = "SELECT count(*) as soUser FROM users";
		int soUsers = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				soUsers=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soUsers;
	}
	public ArrayList<Users> getListUsersByPage(int offset, int nUMBER_NEWS_PER_PAGE) {
		ArrayList<Users> listUsers= new ArrayList<Users>();
		Users user;
		String query = "SELECT username,password,fullname,address,phone FROM users"
				+  " LIMIT "+offset+" , "+nUMBER_NEWS_PER_PAGE+" ; ";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				user=new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				listUsers.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listUsers;
	}
	public boolean editUser(Users users) {
		String query = "UPDATE users set  password=? ,fullname =?,phone =?,address=? where username= ?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,users.getPassword());
			pstm.setString(2,users.getFullname());
			pstm.setInt(3,users.getPhone());
			pstm.setString(4,users.getAddress());
			pstm.setString(5,users.getUsername());
			
			check=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check>0){
			return true;
		}
		else{
			return false;
		}
	}
	public Users getUserDetail(String username) {
		Users users = null;
		String query = "Select username , password , fullname,address,phone from users where username = '"+username+"'";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				users=new Users(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	public boolean addUser(Users users) {
		String query = "INSERT INTO users(username,password,fullname,address,phone) VALUES (?,?,?,?,?)";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,users.getUsername());
			pstm.setString(2, users.getPassword());
			pstm.setString(3, users.getFullname());
			pstm.setString(4, users.getAddress());
			pstm.setInt(5, users.getPhone());
			check=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check>0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean deleteUser(String username) {
		String query = "delete from users where username=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,username);
			check=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check>0){
			return true;
		}
		else{
			return false;
		}
	}
}
