package bean;

public class Category {
	private int idCat;
	private String nameCat;
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
	public Category(int idCat, String nameCat) {
		super();
		this.idCat = idCat;
		this.nameCat = nameCat;
	}
	public Category() {
		super();
	}
	
}
