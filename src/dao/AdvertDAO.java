package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Advert;
import bean.News;
import bean.Support;

public class AdvertDAO {
	Database db=new Database();
	public int numberAllNews1() {
		String query = "SELECT count(*) as sotin FROM advert";
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

	public ArrayList<Advert> getListNewsByPage1(int offset, int numberNewsPerPage) {
		ArrayList<Advert> listAdvert=new ArrayList<Advert>();
		Advert advert;
		String query = " SELECT id_advert,name,link,picture from advert" + " ORDER BY id_advert DESC "+ " LIMIT "+offset+" , "+numberNewsPerPage;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				advert=new Advert(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				listAdvert.add(advert);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listAdvert;
	}

	public Advert getDetail(int idAdvert) {
		String query=" SELECT id_advert,name,link,picture from advert" +" Where id_advert="+idAdvert ;		
		Advert advert= null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				advert=new Advert(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advert;
	}

	public boolean deleteCheckBox(ArrayList<Integer> listIdAdvert) {
		String query = "delete from advert where id_advert=?";
		for(int i=1; i<listIdAdvert.size();i++){
			query+="|| id_advert=?";
		}			
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			for(int i=0;i<listIdAdvert.size();i++){
			pstm.setInt(i+1, listIdAdvert.get(i));
			}
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

	public boolean addAdvert(Advert advert) {
		String query = "INSERT INTO advert(name,link,picture) VALUES (?,?,?)";
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, advert.getName());
			pstm.setString(2, advert.getLink());
			pstm.setString(3, advert.getPicture());

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

	public boolean editAdvert(Advert advert) {
String query = "UPDATE `advert` SET `name` = ? , `link`= ?,`picture`= ? WHERE id_advert= ?; ";
		
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, advert.getName());
			pstm.setString(2, advert.getLink());
			pstm.setString(3, advert.getPicture());
			pstm.setInt(4, advert.getIdAdvert());
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

	public ArrayList<Advert> getListAdvert() {
		ArrayList<Advert> listAdvert= new ArrayList<Advert>();
		String query = "SELECT id_advert,name,link,picture from advert" ;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Advert advert;
			while(rs.next()){
				advert=new Advert(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				listAdvert.add(advert);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAdvert;
	}
}


