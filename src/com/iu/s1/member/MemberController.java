package com.iu.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.s1.util.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final RequestDispatcher  = null;
	private MemberService memberService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
   @Override
public void init() throws ServletException {
	memberService = new MemberService();
	MemberDAO memberDAO = new MemberDAO();
	memberService.setMemberDAO(memberDAO);
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		System.out.println(path);
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		
		
		String result="";
		//서브 스트링으로 마지막 주소
		//1.자르려고 하는 시작 인덱스 번호 찾기
		int index = uri.lastIndexOf("/");
		//2.해당 인덱스부터 잘라오기
		result = uri.substring(index+1);
		System.out.println(result);
		
		ActionForward actionForward = null;
		
		if(result.equals("memberLogin.do")) {
			System.out.println("로그인 처리");
			
			try {
				actionForward = memberService.memberLogin(request);
			} catch (Exception e) {
				System.out.println("에러발생");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(result.equals("memberJoin.do")){
			try {
				actionForward = memberService.memberJoin(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("에러발생");
				e.printStackTrace();
			}
		
			
		}else {
			System.out.println("그외 다른 처리");
		}
		
		
		if(actionForward.isCheck()) {
		//forward
		RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
		view.forward(request, response);
		}else {
		//redirect
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
