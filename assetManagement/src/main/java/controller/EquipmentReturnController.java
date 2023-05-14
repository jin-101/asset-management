package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;

public class EquipmentReturnController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		int eqId = Integer.parseInt(request.getParameter("eqId"));
		int returnCount = service.eqRetrun(eqId);
		int infoRemoveCount = -1;
		if(returnCount==1) {
			infoRemoveCount = service.rentInfoDelete(eqId);
		}
		
		return "responseBody:"+ infoRemoveCount;
	}

}