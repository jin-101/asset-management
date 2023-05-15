package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dbutil.DateUtil;
import service.EquiCompanyService;
import service.EquiTypeService;
import service.EquipmentService;
import vo.EquiCompanyVO;
import vo.EquiTypeVO;
import vo.EquiVO;

public class EquipmentDetailController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String method = (String)data.get("method");
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		String page = "";
		
		if(method.equals("GET")) {
			int eqid= Integer.parseInt(request.getParameter("eqid"));
			EquipmentService service = new EquipmentService();
			EquiVO eq = service.eqSelectById(eqid);
			request.setAttribute("equipment", eq);

			EquiTypeService typeService = new EquiTypeService();
			EquiCompanyService companyService = new EquiCompanyService();
			request.setAttribute("equiTypeList",typeService.EquiTypeSelectAll());
			request.setAttribute("equiCompanyList", companyService.EquiCompanySelectAll());
			page = "equiDetail.jsp";
		}else {
			EquiVO eq = makeEquip(request);
			EquipmentService service = new EquipmentService();
			int returnCount =service.eqUpdate(eq);
			page = "responseBody:"+returnCount; // returnCount > 0 ? "업데이트완료" : "업데이트실패";
		}
		return page;
	}
	
	private EquiVO makeEquip(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int eqId=Integer.parseInt(request.getParameter("equipmentId"));
		String eqTypeId=request.getParameter("equiType");
		String eqCompanyId=request.getParameter("equiCom");
		String model=request.getParameter("model");
		String serialNo=request.getParameter("serialNo");
		Date purchaseDate=DateUtil.convertToDate(request.getParameter("purchaseDate"));
		int price=Integer.parseInt(request.getParameter("price"));
		
		EquiVO eq = new EquiVO();
		eq.setEquipmentId(eqId);
		
		EquiTypeVO eqType = new EquiTypeVO();
		eqType.setTypeId(eqTypeId);
		eq.setEquiType(eqType);
		
		EquiCompanyVO eqCom = new EquiCompanyVO();
		eqCom.setCoId(eqCompanyId);
		eq.setEquiCompany(eqCom);
		
		eq.setModel(model);
		eq.setSerialNo(serialNo);
		eq.setPurchaseDate(purchaseDate);
		eq.setPrice(price);
		return eq;
	}


}
