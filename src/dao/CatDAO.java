package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Category;

public class CatDAO {
	Database db=new Database();
	public int numberAllNews() {
		String query = "SELECT count(*) as soCat FROM category";
		int soCat = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				soCat=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soCat;
	}
	public ArrayList<Category> getListCatByPage(int offset, int numberPage) {
		ArrayList<Category> listCat = new ArrayList<Category>();
		Category cat;
		String query = "SELECT id_cat,namecat FROM category "
				+  " LIMIT "+offset+" , "+numberPage+" ; ";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				 cat =new Category(rs.getInt(1), rs.getString(2));	
				 listCat.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCat;
	}
	public boolean addCat(String nameCat) {
		String query = "INSERT INTO category(namecat) VALUES (?)";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, nameCat);
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
	public boolean editCat(Category cat) {
		String query = "UPDATE category set namecat= '"+cat.getNameCat()+"' where id_cat= "+cat.getIdCat();
				
				int check=0;
				try {
					Statement pstm = db.connectDB().createStatement();
					check = pstm.executeUpdate(query);
					
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
	public Category getCatDetail(int idCat) {
		String query = "SELECT id_cat,namecat from category where id_cat = "+idCat;
		Category cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				cat = new Category(rs.getInt("id_cat"),rs.getString("namecat"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}
	public boolean delCat(int id) {
		// TODO Auto-generated method stub
		String query = "delete from category where id_cat=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1, id);
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
	public ArrayList<Category> getListCat() {
		ArrayList<Category> listCat = new ArrayList<Category>();
		String query = "SELECT id_cat,namecat from category ORDER BY id_cat DESC";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Category cat;
			while(rs.next()){
				cat = new Category(rs.getInt("id_cat"),rs.getString("namecat"));
				listCat.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCat;
	}
}
