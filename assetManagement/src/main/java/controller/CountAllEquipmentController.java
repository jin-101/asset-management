package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;

public class CountAllEquipmentController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EquipmentService service = new EquipmentService();
		int totalSize = service.eqSelectAll().size();
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		request.setAttribute("maxSize", totalSize);
		String page = "inputSearchEquipment.jsp";
		return page;
	}

}
