package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.About;
import bean.Contact;
import bean.News;

public class ContactDAO {
	Database db=new Database();
	public int numberAllNews() {
		String query = "SELECT count(*) as sotin FROM contact";
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

	public ArrayList<Contact> getListContactByPage(int offset, int numberNewsPerPage) {
		ArrayList<Contact>  listContact=new ArrayList<Contact>();
		Contact contact;
		String query = "SELECT id_contact,fullname,email,phone,website,detail,datecreate FROM `contact` "+" ORDER BY id_contact DESC "+" LIMIT "+offset+","+numberNewsPerPage; 
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				contact=new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
				listContact.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listContact;
	}

	public boolean deleteCheckBox(ArrayList<Integer> listIdContact) {
		String query = "delete from contact where id_contact=?";
		for(int i=1; i<listIdContact.size();i++){
			query+="|| id_contact=?";
		}			
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			for(int i=0;i<listIdContact.size();i++){
			pstm.setInt(i+1, listIdContact.get(i));
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

	public boolean delContact(int idContact) {
		String query = "delete from contact where id_contact=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1, idContact);
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

	public Contact getContact(int idContact) {
		String query ="SELECT `id_contact`, `fullname`, `email`, `phone`, `website`, `detail`, `datecreate` FROM `contact` WHERE id_contact="+idContact ;
				
		Contact contact = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				contact=new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}

	public boolean addContact(Contact contact) {
		String query = "INSERT INTO `contact`( `fullname`, `email`, `phone`, `website`, `detail`, `datecreate`) VALUES (?,?,?,?,?,?)";
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,contact.getFullname());
			pstm.setString(2,contact.getEmail());
			pstm.setInt(3,contact.getPhone() );
			pstm.setString(4,contact.getWebSite());
			pstm.setString(5,contact.getDetail());
			pstm.setString(6,contact.getDatecreate());
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

}
