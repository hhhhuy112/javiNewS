package bo;

import java.util.ArrayList;

import bean.Category;
import dao.CatDAO;

public class CatBO {
	CatDAO catDAO=new CatDAO();

	public ArrayList<Category> getListCatByPage(int offset, int numberPage) {
		return catDAO.getListCatByPage(offset,numberPage) ;
	}
	public int numberAllNews() {
		return catDAO.numberAllNews() ;
	}
	public boolean addCat(String nameCat) {
		return catDAO.addCat(nameCat) ;
	}
	public boolean editCat(Category cat) {
		return catDAO.editCat(cat);
	}
	public boolean delCat(int id) {
		return catDAO.delCat(id);
	}
	public Category getCatDetail(int idCat) {
		return catDAO.getCatDetail(idCat);
	}
	public ArrayList<Category> getListCat() {
		return catDAO.getListCat();
	}
	public ArrayList<Integer> getListIdNewsCheckBox(String value){
		ArrayList<Integer> listIdNews =new ArrayList<Integer>();
		for(String vl :value.split(",")){
			listIdNews.add(Integer.parseInt(vl.trim()));
		}
		return listIdNews;
	}
}
