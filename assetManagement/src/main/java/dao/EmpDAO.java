package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.Util;
import vo.DeptVO;
import vo.EmpVO;
import vo.JobsVO;
import vo.PositionVO;
import vo.SubpartVO;

public class EmpDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst; // ?지원
	private ResultSet rs;
	private int resultCount; 
	
	//직원 전체 조회
	public List<EmpVO> empSelectAll() {
		String sql = """
					select *
					from employees;
				""";
		List<EmpVO> emplist = new ArrayList<>();
		conn = Util.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}
	public List<EmpVO> allEmpAndDept() {
		String sql = """
				select employee_id, first_name, last_name, department_name 
				from employees emp 
				left outer join subpart sp on ( emp.subpart_part_no=sp.part_no) 
				left outer join departments dept on (departments_department_id = dept.department_id)
			""";
		List<EmpVO> emplist = new ArrayList<>();
		conn = Util.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpVO emp = new EmpVO();
				SubpartVO sp = new SubpartVO();
				DeptVO dept = new DeptVO();
				emp.setEmployeeId(rs.getInt("Employee_id"));
				emp.setFirstName(rs.getString("First_name"));
				emp.setLastName(rs.getString("Last_name"));
				dept.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				sp.setDept(dept);
				emp.setSubpart(sp);
				
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}
	
	// 직원 필드 생성
	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		JobsVO job = new JobsVO();
		SubpartVO sp = new SubpartVO();
		PositionVO pos = new PositionVO();
		
		emp.setEmployeeId(rs.getInt("Employee_id"));
		emp.setFirstName(rs.getString("First_name"));
		emp.setLastName(rs.getString("Last_name"));
		emp.setEmail(rs.getString("Email"));
		emp.setPhoneNumber(rs.getString("Phone_number"));
		emp.setHireDate(rs.getDate("Hire_date"));
		job.setJobId(rs.getString("jobs_JOB_ID"));
		emp.setSalary(rs.getInt("Salary"));
		sp.setPartNo(rs.getInt("subpart_PART_NO"));
		pos.setPositionId(rs.getInt("position_POSITION_ID"));
		
		emp.setJobs(job);
		emp.setSubpart(sp);
		emp.setPosition(pos);
		return emp;
	}
}
