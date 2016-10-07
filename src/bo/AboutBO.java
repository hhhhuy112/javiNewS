package bo;

import java.util.ArrayList;

import bean.About;
import dao.AboutDAO;

public class AboutBO {
	AboutDAO aboutDAO=new AboutDAO();
	public int numberAllNews() {
		return aboutDAO.numberAllNews() ;
	}
	public ArrayList<About> getListAboutByPage(int offset, int numberNewsPerPage) {
		return aboutDAO.getListAboutByPage(offset, numberNewsPerPage) ;
	}
	public  boolean editAbout(About about) {
		// TODO Auto-generated method stub
		return aboutDAO.editAbout(about) ;
	}
	public About getAboutDetail(int idAbout) {
		return aboutDAO.getAboutDetail (idAbout); 
	}
	public boolean delAbout(int idAbout) {
		return aboutDAO.delAbout(idAbout); 
	}

}
