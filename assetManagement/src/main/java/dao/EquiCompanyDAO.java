package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.Util;
import vo.EquiCompanyVO;

public class EquiCompanyDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	public List<EquiCompanyVO> EquiCompanySelectAll(){
		String sql = "select * from equipmentscompany";
		List<EquiCompanyVO> equiCompanyList = new ArrayList<>();
		conn = Util.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EquiCompanyVO equiCompany = new EquiCompanyVO();
				equiCompany.setCoId(rs.getString("co_id"));
				equiCompany.setCoName(rs.getString("co_name"));
				equiCompanyList.add(equiCompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			Util.dbDisconnect(rs, st, conn);
		}
		return equiCompanyList;
	}
}
