package com.iu.s1.bankbook;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iu.s1.util.ActionForward;

public class BankBookService {

	private BankBookDAO bankBookDAO;//객체는 하나만 있어도 되고 이거 계속 이 클래스 내에서 여기저기 쓰니까 
	//선언만 하면  null 객체 생성 안하면 null

	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}
	//그래서 세터 선언함 밖에서(다른 클래스) 꺼낼 일이 잇으면 겟쓰는데 지금은 그럴일이 없으니까 셋만 씀
	
	
	//getList dao의 getList호출 후 액션포워드 리턴
	public ActionForward getList(HttpServletRequest request) throws Exception{
		
		ActionForward actionForward = new ActionForward();//포워드 할래 or 리다이렉트 할래 경로는 어떻게 적을래?
		List<BankBookDTO> ar = bankBookDAO.getList();
		request.setAttribute("list", ar);//내장 객체에 데이터를 담겠다.
		
		actionForward.setPath("../WEB-INF/bankbook/bankbookList.jsp");//jsp로 보내는건 무조건 포워드다
		//난 지금 뱅크 북 안에 있지,, 루트를 기준으로 시작하는 거지,,
		actionForward.setCheck(true);
		
		return actionForward;
	}


	public ActionForward getSelect(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		BankBookDTO bankBookDTO = new BankBookDTO(); 
		
		bankBookDTO.setBookNum(1L);
		
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		request.setAttribute("select", bankBookDTO);
		
		
		actionForward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		actionForward.setCheck(true);
		
		
		return actionForward;
	}



}
