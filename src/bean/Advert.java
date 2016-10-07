package bean;

public class Advert {
	private int idAdvert;
	private String name;
	private String link;
	private String picture;
	public int getIdAdvert() {
		return idAdvert;
	}
	public void setIdAdvert(int idAdvert) {
		this.idAdvert = idAdvert;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Advert(int idAdvert, String name, String link, String picture) {
		super();
		this.idAdvert = idAdvert;
		this.name = name;
		this.link = link;
		this.picture = picture;
	}
	public Advert() {
		super();
	}
	
}
