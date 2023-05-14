package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;
import vo.EquiVO;

public class UsingEquipmentController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EquipmentService service = new EquipmentService();
		List<EquiVO> eqlist = service.empUseEqAllSearch();
				
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		request.setAttribute("eqAll", eqlist);
		
		String page = "searchEquipment.jsp";
		return page;
	}

}
