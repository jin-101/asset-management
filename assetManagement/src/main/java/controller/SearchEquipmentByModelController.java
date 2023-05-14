package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;
import vo.EquiVO;

public class SearchEquipmentByModelController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		String model = request.getParameter("model");

		List<EquiVO> eqlist = service.rentModelSearch(model);
		request.setAttribute("eqAll", eqlist);
		System.out.println(eqlist);
		String page = "searchEquipment.jsp";
		return page;
	}

}