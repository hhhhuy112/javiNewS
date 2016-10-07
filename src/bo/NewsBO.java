package bo;

import java.util.ArrayList;

import bean.Category;
import bean.News;
import dao.NewsDAO;

public class NewsBO {
	NewsDAO newsDAO= new NewsDAO();
	public int numberAllNews1() {
		return newsDAO.numberAllNews1() ;
	}

	public ArrayList<News> getListNewsByPage1(int offset, int numberNewsPerPage) {
		return newsDAO.getListNewsByPage1(offset,numberNewsPerPage );
	}

	public boolean addNews(News news) {
		return newsDAO.addNews(news); 
	}

	public boolean deleteCheckBox(ArrayList<Integer> idNews) {
		return newsDAO.deleteCheckBox(idNews) ;
	}
	public ArrayList<Integer> getListIdNewsCheckBox(String value){
		ArrayList<Integer> listIdNews =new ArrayList<Integer>();
		for(String vl :value.split(",")){
			listIdNews.add(Integer.parseInt(vl.trim()));
		}
		return listIdNews;
	}

	public News getDetail(int idNews) {
		return newsDAO.getDetail(idNews);
	}

	public boolean delNews(int idnews) {
		return newsDAO.delNews( idnews)  ;
	}

	public boolean editNews(News news) {
		return newsDAO.editNews(news)  ;
	}

	public ArrayList<News> getListNewsByPage2(int offset, int numberNewsPerPage, String nameNews) {
		return newsDAO.getListNewsByPage2(offset, numberNewsPerPage, nameNews) ;
	}

	public int numberAllNews2(String nameNews) {
		return newsDAO.numberAllNews2(nameNews) ;
	}

	public int numberAllNews(int idCat) {
		return newsDAO.numberAllNews(idCat); 
	}

	public ArrayList<News> getListNewsByPage(int offset, int numPerPage, int idCat) {
		return newsDAO.getListNewsByPage( offset, numPerPage, idCat); 
	}

	public ArrayList<ArrayList<News>> getList(ArrayList<Category> listCat,int NUMBER_NEWS_PER_PAGE) {
		return newsDAO.getList(listCat,NUMBER_NEWS_PER_PAGE); 
	}

	public ArrayList<News> getListNewsByCat(int offset, int numPerPage, int idCat) {
		return newsDAO.getListNewsByCat(offset, numPerPage,idCat); 
	}

	public boolean setView(int idNews) {
		return newsDAO.setView(idNews); 
	}

	public ArrayList<News> getlistRel(int idCat,int idNews,int NUM_PER_PAGE) {
		return newsDAO.getlistRel(idCat,idNews,NUM_PER_PAGE); 
	}

	public ArrayList<News> getlistUnRel(int idCat,int NUM_PER_PAGE) {
		return newsDAO.getlistUnRel(idCat, NUM_PER_PAGE); 
	}

	

}
