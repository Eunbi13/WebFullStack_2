package com.iu.s1.trade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.iu.s1.util.ActionForward;

public class TradeService {




	private TradeDAO tradeDAO;
	
	public void setTradeDAO(TradeDAO tradeDAO) {
		this.tradeDAO = tradeDAO;
	}//다른 클래스에서 꺼낼 일이 있으면 getter사용하지만 서비스 내에서만 쓸거고 정보를 주기만 할거니까 굳이 getter사용x
	//아 우리가 여기 내부클래서 this를 사용하잖아 그래서 서비스를 컨트롤러 호출할때 디에이오의 주소를 넘겨줘서 그 참조주소를 이 클래스 내부에서
	//활용할 수 있게 된거임!!!!!



	public ActionForward getList(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		 
//		tradeDAO = new TradeDAO();위에서 필드에 인스턴스 변수로 선언해서 굳이 여기서 선언할 필요 없음
		List<TradeDTO> ar = tradeDAO.getList();
		
		request.setAttribute("list", ar);
		
		//forward
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/trade/tradeList.jsp");
		
		return actionForward;
	}
	
	
	
}
