package com.iu.s1.bankbook;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.iu.s1.util.ActionForward;

public class BankBookService {

	
	
	//getList dao의 getList호출 후 액션포워드 리턴
	public ActionForward getList(HttpServletRequest request) throws Exception{
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		Map<String, Object> map= bankBookDAO.getList();
		
		
		return actionForward;
	}
}
