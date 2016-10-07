package bo;

import java.util.ArrayList;

import bean.Contact;
import dao.ContactDAO;

public class ContactBO {
	ContactDAO contactDAO=new ContactDAO();
	public int numberAllNews() {
		return contactDAO.numberAllNews();  
	}

	public ArrayList<Contact> getListContactByPage(int offset, int numberNewsPerPage) {
		return contactDAO.getListContactByPage( offset,  numberNewsPerPage); 
	}

	public ArrayList<Integer> getListIdContactCheckBox(String value){
		ArrayList<Integer> listIdContact=new ArrayList<Integer>();
		for(String vl :value.split(",")){
			listIdContact.add(Integer.parseInt(vl.trim()));
		}
		return listIdContact;
	}

	public boolean deleteCheckBox(ArrayList<Integer> listIdContact) {
		return contactDAO.deleteCheckBox(listIdContact); 
	}

	public boolean delContact(int idContact) {
		return contactDAO.delContact(idContact) ;
	}

	public Contact getContact(int idContact) {
		return contactDAO.getContact(idContact) ;
	}

	public boolean addContact(Contact contact) {
		return contactDAO.addContact(contact) ;
	}

}
