package com.iu.s1.trade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.s1.util.ActionForward;

/**
 * Servlet implementation class TradeController
 */
@WebServlet("/TradeController")
public class TradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TradeService tradeService;//자바를 servlet에서 초기화 init메서드 오버라이딩

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TradeController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		//서블릿을 선언할때 생성되는 초기화 메서드이다. 선언할 때 서비스와 연동하기 위해서 여기에 서비스 클래스를 선언하는거임!
		tradeService = new TradeService();
		TradeDAO tradeDAO = new TradeDAO();
		tradeService.setTradeDAO(tradeDAO);
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩 처리 모든 컨트롤러에 쓰기
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//ActionForward actionForward = new ActionForward();
		ActionForward actionForward = null;
		
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		uri = uri.substring(index+1);
		System.out.println(uri);

		try {

			if(uri.equals("tradeList.do")) {
				actionForward=tradeService.getList(request);
				
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}

		//포워드로 보낼지(트루) 리다이렉트로 보낼지(펄스)
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
