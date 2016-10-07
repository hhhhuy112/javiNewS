package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.SplitPages;

public class SplitPagesDAO {
	Database db=new Database();
	public boolean setSplitPages(SplitPages splitPages) {
		String query = "UPDATE `splitpages` SET  `numAdmin`= ?, `numpublic` = ? ";
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1,splitPages.getNumAdmin());
			pstm.setInt(2,splitPages.getNumPublic());
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
	public SplitPages getSplitPages() {
		String query = "SELECT numAdmin,numPublic FROM splitpages";
		SplitPages splitPages =new SplitPages();
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				splitPages=new SplitPages(rs.getInt(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return splitPages;
	}

}
