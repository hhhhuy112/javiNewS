package bean;

public class About {
	private int idAbout ;
	private String titleAbout;
	private String detailAbout;
	public int getIdAbout() {
		return idAbout;
	}
	public void setIdAbout(int idAbout) {
		this.idAbout = idAbout;
	}
	public String getTitleAbout() {
		return titleAbout;
	}
	public void setTitleAbout(String titleAbout) {
		this.titleAbout = titleAbout;
	}
	public String getDetailAbout() {
		return detailAbout;
	}
	public void setDetailAbout(String detailAbout) {
		this.detailAbout = detailAbout;
	}
	public About(int idAbout, String titleAbout, String detailAbout) {
		super();
		this.idAbout = idAbout;
		this.titleAbout = titleAbout;
		this.detailAbout = detailAbout;
	}
	public About() {
		super();
	}
	
}
