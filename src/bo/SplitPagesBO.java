package bo;

import bean.SplitPages;
import dao.SplitPagesDAO;

public class SplitPagesBO {
	SplitPagesDAO splitPagesDAO=new SplitPagesDAO();
	public boolean setSplitPages(SplitPages splitPages) {
		return splitPagesDAO.setSplitPages( splitPages); 
	}
	public SplitPages getSplitPages() {
		return splitPagesDAO.getSplitPages(); 
	}

}
