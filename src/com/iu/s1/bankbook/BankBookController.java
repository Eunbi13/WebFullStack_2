package com.iu.s1.bankbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.s1.util.ActionForward;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankBookService bankBookService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankBookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//controller객체 생성 후 자동 호출되는 초기화 메서드(tomcat이 해줌)
		bankBookService = new BankBookService();
		BankBookDAO bankBookDAO = new BankBookDAO();
		//서비스 안에 뱅크 북 디에이오가 있어야 한다. 집어 넣어줌
		bankBookService.setBankBookDAO(bankBookDAO);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url 뒷 주소 가져오기 멤버컨트롤러 참조 ㅇㅇ

		String uri = request.getRequestURI();// /WebFullStack_2/bankbook/bankbooList.do
		int index = uri.lastIndexOf("/");
		uri = uri.substring(index+1);//인덱스 포함이니까 
		
		ActionForward actionForward = null;
		
		try {
		//한번 확인하고
			if(uri.equals("bankbookList.do")) {
				
				System.out.println("bankbookList실행");
				actionForward = bankBookService.getList(request);
				//path,true,false정보가 담긴 액션포워드
				
			}else if(uri.equals("bankbookSelect.do")) {
				
				System.out.println("bankbookSelect실행");
				actionForward = bankBookService.getSelect(request);
			}
				
			
		} catch (Exception e){
			System.out.println("에러발생");
			e.printStackTrace();
		}
		
		
		
		
		//포워드로 보낼지(트루) 리다이렉트로 보낼지(펄스)
		if(actionForward.isCheck()) {//true
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());// 경로 입력하는 건데 그걸 서비스에서여기에 담아두었으니까 
			//여기까지 준비
			view.forward(request, response);//어레이 리스트가 담겨있을 리퀘스트와 짝궁인 레스폰스
			
			
		}else {
			response.sendRedirect(actionForward.getPath());	//레스폰스에 담아서 응답을 끝내버리겟다.
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);//일단 doGet을 소환함 그래서 서비스클래스에서 메서드가 겟이냐 포스트냐 구분하는거임
	}

}
