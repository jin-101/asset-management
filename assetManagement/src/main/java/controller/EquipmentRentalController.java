package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.EquipmentService;

public class EquipmentRentalController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		EquipmentService service = new EquipmentService();
		int eqId = Integer.parseInt(request.getParameter("eqId"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		int resultCount = service.eqRental(eqId, empId);
		return "responseBody:"+ resultCount; // resultCount > 0 ? "대여성공" : "대여실패";
	}

}
