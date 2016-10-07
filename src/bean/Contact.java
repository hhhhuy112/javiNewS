package bean;

public class Contact {
	private int idContact;
	private String fullname;
	private String email;
	private int phone;
	private String webSite;
	private String detail;
	private String datecreate;
	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int idContact, String fullname, String email, int phone, String webSite, String detail,
			String datecreate) {
		super();
		this.idContact = idContact;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.webSite = webSite;
		this.detail = detail;
		this.datecreate = datecreate;
	}
	
}
