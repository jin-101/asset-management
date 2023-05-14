package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;

public class AllEquipmentModelController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EquipmentService service = new EquipmentService();
		List<String> modelList = service.allModelList();
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		request.setAttribute("selectorlist", modelList);
		String page = "selectorOptionEquipment.jsp";
		
		return page;
	}

}