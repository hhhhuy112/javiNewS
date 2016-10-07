package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Category;
import bean.News;
import bean.Users;

public class NewsDAO {
	Database db=new Database();
	public int numberAllNews1() {
		String query = "SELECT count(*) as sotin FROM news ";
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
	public ArrayList<News> getListNewsByPage1(int offset, int numberNewsPerPage) {
		ArrayList<News> listNews =new ArrayList<News>();
		News news;
		String query = " SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) " + " ORDER BY id_news DESC "+ " LIMIT "+offset+" , "+numberNewsPerPage;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNews;
	}
	public boolean addNews(News news) {
		String query = "INSERT INTO news(title,description,detail,picture,datecreate,username,id_cat,view) VALUES (?,?,?,?,?,?,?,?)";
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, news.getTitle());
			pstm.setString(2, news.getDescription());
			pstm.setString(3, news.getDetail());
			pstm.setString(4, news.getPicture());
			pstm.setString(5, news.getDatecreat());
			pstm.setString(6, news.getUsername());
			pstm.setInt(7, news.getIdCat());
			pstm.setInt(8, 0);

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
	public boolean deleteCheckBox(ArrayList<Integer> listIdNews) {
		String query = "delete from news where id_news=?";
		for(int i=1; i<listIdNews.size();i++){
			query+="|| id_news=?";
		}			
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			for(int i=0;i<listIdNews.size();i++){
			pstm.setInt(i+1, listIdNews.get(i));
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
	public News getDetail(int idNews) {
		String query = "SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+"WHERE id_news="+idNews + " ORDER BY id_news DESC ";
				
		News news = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}
	public boolean delNews(int idnews) {
		String query = "delete from news where id_news=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1, idnews);
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
	public boolean editNews(News news) {
		String query = "UPDATE `news` SET `title` = ? , `description`= ?, `detail` = ?,`id_cat`= ?,`picture`= ?,`datecreate`=?  WHERE id_news = ?; ";
		
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, news.getTitle());
			pstm.setString(2, news.getDescription());
			pstm.setString(3, news.getDetail());
			pstm.setInt(4, news.getIdCat());
			pstm.setString(5, news.getPicture());
			pstm.setString(6, news.getDatecreat());
			pstm.setInt(7, news.getIdNews());

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
	public ArrayList<News> getListNewsByPage2(int offset, int numberNewsPerPage, String nameNews) {
		ArrayList<News> listNews =new ArrayList<News>();
		News news;
		String query = " SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+"WHERE title LIKE '%"+nameNews.trim()+"%'"+" ORDER BY id_news DESC "+" LIMIT "+offset+","+numberNewsPerPage;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNews;
	}
	public int numberAllNews2(String nameNews) {
		String query = "SELECT COUNT(*) FROM `news` WHERE title LIKE '%"+nameNews.trim()+"%'";
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
	public int numberAllNews(int idCat) {
		String query = "SELECT count(*) as sotin FROM news WHERE id_cat="+idCat;
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
	public ArrayList<News> getListNewsByPage(int offset, int numPerPage, int idCat) {
		ArrayList<News> listNews =new ArrayList<>();
		News news;
		String query = " SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+"WHERE id_cat ="+idCat+" ORDER BY id_news DESC "+" LIMIT "+offset+","+numPerPage;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNews;
	}
	public ArrayList<ArrayList<News>> getList(ArrayList<Category> listCat, int nUMBER_NEWS_PER_PAGE) {
		ArrayList<ArrayList<News>> listget=new ArrayList<ArrayList<News>>();
		for(Category cat:listCat){
		ArrayList<News> listNews =new ArrayList<>();
		News news;
		String query = " SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+"WHERE id_cat ="+cat.getIdCat()+" ORDER BY id_news DESC "+" LIMIT 0,"+nUMBER_NEWS_PER_PAGE;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listNews.size()>0){
		listget.add(listNews);
		}
		}
		return listget;
	}
	public ArrayList<News> getListNewsByCat(int offset, int numPerPage, int idCat) {
		ArrayList<News> listNews =new ArrayList<>();
		News news;
		String query=" SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+" WHERE id_cat="+idCat+" ORDER BY id_news DESC "+" LIMIT "+offset+" , "+numPerPage;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNews;
	}
	public boolean setView(int idNews) {
		String query = "UPDATE `news` SET `view`=`view`+1  WHERE id_news = ?; ";
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1, idNews);

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
	public ArrayList<News> getlistRel(int idCat,int idNews,int NUM_PER_PAGE) {
		ArrayList<News> listNews =new ArrayList<>();
		News news;
		String query=" SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+" WHERE id_cat="+idCat+"&&id_news<>"+idNews+" ORDER BY id_news DESC "+" LIMIT 0, "+NUM_PER_PAGE;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNews;
	}
	public ArrayList<News> getlistUnRel(int idCat,int NUM_PER_PAGE) {
		ArrayList<News> listNews =new ArrayList<>();
		News news;
		String query=" SELECT n.id_news,n.title,n.description,n.detail,n.picture,n.datecreate,n.username,n.id_cat,c.namecat as cnamecat ,n.view from news as n "
				+ " inner join category as c using(id_cat) "+" WHERE id_cat<>"+idCat+" ORDER BY id_news DESC "+" LIMIT 0,"+NUM_PER_PAGE;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
				listNews.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNews;
	}

	
	
	
}
