package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EmpService;
import vo.EmpVO;


public class EmpListController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.empSelectAll();
		
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		request.setAttribute("empAll", emplist);
		
		String page = "empList.jsp";
		return page;
	}

}
