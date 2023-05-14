package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.EmpService;
import vo.EmpVO;

public class AllEmpAndDeptController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.allEmpAndDept();
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		request.setAttribute("empAll", emplist);
		ObjectMapper objectMapper = new ObjectMapper();
		return "responseBody:" + objectMapper.writeValueAsString(emplist);
	}

}