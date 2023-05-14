package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		CommonControllerInterface controller = null;
		Map<String, Object> data = new HashMap<>();
		
		data.put("method", request.getMethod());
		data.put("request", request);
		data.put("response", response);
		
		System.out.println("--- "+path);
		
		switch(path) {
			case "/login/signin.do": {
				controller = new SigninController(); break;
			}
			case "/login/menu.do":{
				controller = new MenuController(); break;
			}
			case "/equi/equiList.do":{
				controller = new EquiListController(); break;
			}
			case "/equi/rentalPossibleEquipment.do":{
				controller = new RentalPossibleEquipmentController(); break;
			}
			case "/equi/usingEquipment.do":{
				controller = new UsingEquipmentController(); break;
			}
			case "/equi/allEquipmentType.do":{
				controller = new AllEquipmentTypeController(); break;
			}
			case "/equi/searchEquipmentByType.do":{
				controller = new SearchEquipmentByTypeController(); break;
			}
			case "/equi/allEquipmentModel.do":{
				controller = new AllEquipmentModelController(); break;
			}
			case "/equi/searchEquipmentByModel.do":{
				controller = new SearchEquipmentByModelController(); break;
			}
			case "/equi/equipmentRental.do":{
				controller = new EquipmentRentalController(); break;
			}
			case "/equi/equipmentReturn.do":{
				controller = new EquipmentReturnController(); break;
			}
			
			case "/emp/empList.do":{
				controller = new EmpListController(); break;
			}
			case "/emp/allEmpAndDept.do":{
				controller = new AllEmpAndDeptController(); break;
			}
			default: break;
		}
		
		String page = null;
		try {
			page = controller.execute(data);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(page + " > page");
		if(page.indexOf("redirect:") >= 0) {
			response.sendRedirect(page.substring(9));
		}else if(page.indexOf("responseBody:") >= 0) {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(page.substring(13));
		}else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

}