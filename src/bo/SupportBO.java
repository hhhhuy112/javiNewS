package bo;

import java.util.ArrayList;

import bean.Contact;
import bean.Support;
import dao.SupportDAO;
public class SupportBO {
	SupportDAO supportDAO=new SupportDAO(); 
	public int numberAllNews() {
		return supportDAO.numberAllSupport(); 
	}

	public ArrayList<Support> getListSupportByPage(int offset, int numberNewsPerPage) {
		return supportDAO.getListSupportByPage(offset,numberNewsPerPage) ;
	}

	public boolean editSupport(Support support) {
		return supportDAO.editSupport(support); 
	}

	public Support getAboutDetail(int idSupport) {
		return supportDAO.getAboutDetail(idSupport); 
	}

	public ArrayList<Support> getListSupport() {
		return supportDAO.getListSupport(); 
	}

}
