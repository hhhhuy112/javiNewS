package bean;

public class SplitPages {
	private int numAdmin;
	private int numPublic;
	public int getNumAdmin() {
		return numAdmin;
	}
	public void setNumAdmin(int numAdmin) {
		this.numAdmin = numAdmin;
	}
	public int getNumPublic() {
		return numPublic;
	}
	public void setNumPublic(int numPublic) {
		this.numPublic = numPublic;
	}
	public SplitPages(int numAdmin, int numPublic) {
		super();
		this.numAdmin = numAdmin;
		this.numPublic = numPublic;
	}
	public SplitPages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
