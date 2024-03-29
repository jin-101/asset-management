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

public class EquipmentInsertController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String method = (String)data.get("method");
		HttpServletRequest request = (HttpServletRequest) data.get("request");
		String page = "";
		if(method.equals("GET")) {
			EquiTypeService typeService = new EquiTypeService();
			EquiCompanyService companyService = new EquiCompanyService();
			request.setAttribute("equiTypeList",typeService.EquiTypeSelectAll());
			request.setAttribute("equiCompanyList", companyService.EquiCompanySelectAll());
			page = "equiInsert.jsp";
		}else {
			EquiVO eq = makeEquip(request);
			EquipmentService service = new EquipmentService();
			int returnCount = service.eqInsert(eq);
			page = "responseBody:"+returnCount;
		}
		return page; //resultCount > 0 ? "입력성공" : "입력실패";
	}

	private EquiVO makeEquip(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String eqTypeId=request.getParameter("equiType");
		String eqCompanyId=request.getParameter("equiCom");
		String model=request.getParameter("model");
		String serialNo=request.getParameter("serialNo");
		Date purchaseDate=DateUtil.convertToDate(request.getParameter("purchaseDate"));
		int price=Integer.parseInt(request.getParameter("price"));
		System.out.println( eqTypeId + " " + eqCompanyId  + " " +model );
		EquiVO eq = new EquiVO();
		
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
