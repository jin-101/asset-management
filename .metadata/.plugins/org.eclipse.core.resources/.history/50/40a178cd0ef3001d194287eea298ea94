package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.Util;

public class EquiTypeDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst; // ?지원
	private ResultSet rs;
	
	public List<String> allEqTypeList(){
		List<String> typeList = new ArrayList<>();
		String sql = """
				select * from equipmentstype
				""";
		conn = Util.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				typeList.add(rs.getString("TYPE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.dbDisconnect(rs, st, conn);
		}
		return typeList;
	}
}
