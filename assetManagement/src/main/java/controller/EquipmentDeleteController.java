package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;

public class EquipmentDeleteController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		int eqId = Integer.parseInt(request.getParameter("eqId"));
		int returnCount = service.eqDelete(eqId);
		return "responseBody:"+ returnCount; // returnCount > 0 ? "장비삭제완료" : "장비삭제실패";
	}

}
