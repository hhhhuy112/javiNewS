package bo;

import java.util.ArrayList;

import bean.Advert;
import dao.AdvertDAO;

public class AdvertBO {
	 AdvertDAO advertDAO =new AdvertDAO();
	public int numberAllNews1() {
		return advertDAO.numberAllNews1() ;
	}

	public ArrayList<Advert> getListNewsByPage1(int offset, int numberNewsPerPage) {
		return advertDAO.getListNewsByPage1(offset, numberNewsPerPage) ;
	}

	public ArrayList<Integer> getListIdAdvertCheckBox(String value) {
		ArrayList<Integer> listIdAdvert=new ArrayList<Integer>();
		for(String vl :value.split(",")){
			listIdAdvert.add(Integer.parseInt(vl.trim()));
		}
		return listIdAdvert;  
	}

	public Advert getDetail(int idAdvert) {
		return advertDAO.getDetail(idAdvert) ;
	}

	public boolean deleteCheckBox(ArrayList<Integer> listIdAdvert) {
		return advertDAO.deleteCheckBox(listIdAdvert); 
	}

	public  boolean addAdvert(Advert advert) {
		return advertDAO.addAdvert(advert); 
	}

	public  boolean editAdvert(Advert advert) {
		return advertDAO.editAdvert(advert) ;
	}

	public ArrayList<Advert> getListAdvert() {
		return advertDAO.getListAdvert(); 
	}

	

}
