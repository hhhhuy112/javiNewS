package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Contact;
import bean.News;
import bean.Support;
import bean.Users;

public class SupportDAO {
	Database db=new Database();
	public int numberAllSupport() {
		String query = "SELECT count(*) as sotin FROM support";
		int sotin = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				sotin=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sotin;
	}

	public ArrayList<Support> getListSupportByPage(int offset, int numberNewsPerPage) {
		ArrayList<Support> listSupport=new ArrayList<Support>();
		String query = "SELECT id_support,fullname,yahoo,skype FROM `support` "+" ORDER BY id_support DESC "+" LIMIT "+offset+","+numberNewsPerPage; 
		Support support =new Support();
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				support=new Support(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				listSupport.add(support);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listSupport;
	}

	public boolean editSupport(Support support) {
String query = "UPDATE `support` SET  `fullname`= ?, `skype` = ?,`yahoo`= ? WHERE id_support= ?; ";
		
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,support.getFulname());
			pstm.setString(2,support.getSkype());
			pstm.setString(3, support.getYahoo());
			pstm.setInt(4,support.getIdSupport());

			check = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Support getAboutDetail(int idSupport) {
			String query="SELECT id_support,fullname,skype,yahoo FROM `support` WHERE id_Support="+idSupport;	
		Support support= null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				support =new Support(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return support;
	}

	public ArrayList<Support> getListSupport() {
		ArrayList<Support> listSupport= new ArrayList<Support>();
		String query = "Select id_support,fullname,yahoo,skype from support";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Support support;
			while(rs.next()){
				support=new Support(rs.getInt(1), rs.getString(1), rs.getString(3), rs.getString(4));
				listSupport.add(support);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listSupport;
	}
}
