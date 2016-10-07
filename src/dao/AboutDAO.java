package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.About;
import bean.Category;
import bean.News;

public class AboutDAO {
	Database db=new Database();
	public int numberAllNews() {
		String query = "SELECT count(*) as sotin FROM about ";
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
	public ArrayList<About> getListAboutByPage(int offset, int numberNewsPerPage) {
		ArrayList<About>  listAbout =new ArrayList<About>();
		About about;
		String query = "SELECT id_about,titleabout,detailabout FROM `about` "+" ORDER BY id_about DESC "+" LIMIT "+offset+","+numberNewsPerPage; 
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				about=new About(rs.getInt(1), rs.getString(2), rs.getString(3));
				listAbout.add(about);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listAbout;
	}
	public boolean editAbout(About about) {
		String query = "UPDATE `about` SET `titleabout`=?,`detailabout`=? WHERE id_about=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,about.getTitleAbout());
			pstm.setString(2,about.getDetailAbout());
			pstm.setInt(3,about.getIdAbout());
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
	public About getAboutDetail(int idAbout) {
		String query = "SELECT id_about,titleabout,detailabout from about where id_about= "+idAbout;
		About about=null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				about =new About(rs.getInt(1), rs.getString(2), rs.getString(3));   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return about;
	}
	public boolean delAbout(int idAbout) {
		String query = "delete from about where id_about=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1, idAbout);
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
