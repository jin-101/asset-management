package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.AccountService;
import vo.AccountVO;

public class SigninController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String method = (String) data.get("method");
		String page = "";
		if(method.equals("GET")) {
			page = "signin.jsp";
		}else {
			HttpServletRequest request = (HttpServletRequest) data.get("request");
			String id = request.getParameter("admin_id");
			String password = request.getParameter("admin_password");
			AccountService service = new AccountService();
			AccountVO account = service.userLogin(id, password);
			String path = request.getContextPath();
			System.out.println("account "+ account);
			if(account != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", account);
				page = "redirect:"+ path + "/login/menu.do";
			}else {
				page = "redirect:"+ path + "/login/signin.do";
			}
		}
			
		return page;
	}

}


