package controller;

import java.util.Map;

public class MenuController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String page = "menu.jsp";
		return page;
	}

}
