package bo;

import java.util.ArrayList;

import bean.Support;
import bean.Users;
import dao.NewsDAO;
import dao.UsersDAO;


public class UsersBO {
	UsersDAO userDAO=new UsersDAO();
	public ArrayList<Users> getListUsers() {
		return userDAO.getListUsers() ;
	}
	public Users checkLogin(Users user) {
		return userDAO.checkLogin(user);
	}
	public int numberAllNews() {
		return userDAO.numberAllNews(); 
	}
	public ArrayList<Users> getListUsersByPage(int offset, int nUMBER_NEWS_PER_PAGE) {
		return userDAO.getListUsersByPage( offset, nUMBER_NEWS_PER_PAGE); 
	}
	public boolean editUser(Users users) {
		return userDAO.editUser(users); 
	}
	public Users getUserDetail(String username) {
		return userDAO.getUserDetail(username); 
	}
	public boolean addUser(Users users) {
		return userDAO.addUser(users);
	}
	public boolean deleteUser(String username) {
		return userDAO.deleteUser(username); 
	}

}
