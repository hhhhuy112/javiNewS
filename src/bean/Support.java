package bean;

public class Support {
private int idSupport;
private String fulname;
private String yahoo;
private String skype;
public int getIdSupport() {
	return idSupport;
}
public void setIdSupport(int idSupport) {
	this.idSupport = idSupport;
}
public String getFulname() {
	return fulname;
}
public void setFulname(String fulname) {
	this.fulname = fulname;
}
public String getYahoo() {
	return yahoo;
}
public void setYahoo(String yahoo) {
	this.yahoo = yahoo;
}
public String getSkype() {
	return skype;
}
public void setSkype(String skype) {
	this.skype = skype;
}
public Support(int idSupport, String fulname, String yahoo, String skype) {
	super();
	this.idSupport = idSupport;
	this.fulname = fulname;
	this.yahoo = yahoo;
	this.skype = skype;
}
public Support() {
	super();
}

}
