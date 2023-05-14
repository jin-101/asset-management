package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.Util;
import vo.AccountVO;

public class AccountDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public AccountVO userLogin(String userID, String userPassword) {
		AccountVO account = null;
		String sql = """
					select * from account 
					where id = ? and password = ?
				""";
		conn = Util.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userID);
			pst.setString(2, userPassword);
			rs = pst.executeQuery();
			while(rs.next()) {
				account = new AccountVO(userID, userPassword);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			Util.dbDisconnect(rs, pst, conn);
        }
		return account;
	}

}
