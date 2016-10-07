package bean;

public class News {
private int idNews;
private String title;
private String description;
private String detail;
private String picture;
private String datecreat;
private String username;
private int idCat;
private String nameCat;
private int view;
public int getIdNews() {
	return idNews;
}
public void setIdNews(int idNews) {
	this.idNews = idNews;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getDatecreat() {
	return datecreat;
}
public void setDatecreat(String datecreat) {
	this.datecreat = datecreat;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getIdCat() {
	return idCat;
}
public void setIdCat(int idCat) {
	this.idCat = idCat;
}
public String getNameCat() {
	return nameCat;
}
public void setNameCat(String nameCat) {
	this.nameCat = nameCat;
}
public int getView() {
	return view;
}
public void setView(int view) {
	this.view = view;
}
public News() {
	super();
	// TODO Auto-generated constructor stub
}
public News(int idNews, String title, String description, String detail, String picture, String datecreat,
		String username, int idCat, String nameCat, int view) {
	super();
	this.idNews = idNews;
	this.title = title;
	this.description = description;
	this.detail = detail;
	this.picture = picture;
	this.datecreat = datecreat;
	this.username = username;
	this.idCat = idCat;
	this.nameCat = nameCat;
	this.view = view;
}


}
