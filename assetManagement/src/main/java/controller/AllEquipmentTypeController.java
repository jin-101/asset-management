package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquiTypeService;

public class AllEquipmentTypeController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EquiTypeService service = new EquiTypeService();
		List<String> equiTypeList = service.allEqTypeList();
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		request.setAttribute("selectorlist", equiTypeList);
		String page = "selectorOptionEquipment.jsp";

		return page;
	}

}