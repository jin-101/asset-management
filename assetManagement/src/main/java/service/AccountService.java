package service;

import dao.AccountDAO;
import vo.AccountVO;

public class AccountService {
	AccountDAO accDao = new AccountDAO();
	
	public AccountVO userLogin(String id, String pw) {
		return accDao.userLogin(id,pw); 
	}
}