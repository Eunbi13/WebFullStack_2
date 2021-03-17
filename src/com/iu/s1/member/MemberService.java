package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.iu.s1.util.ActionForward;

public class MemberService {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;//정보를 뺼 필요가 없으니까 set만 쓴다. 
	}

	public ActionForward memberJoin(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		//회원가입할 수 잇는 dao메서드 호출
		String method=request.getMethod();
		actionForward.setPath("../WEB-INF/member/memberJoin.jsp");//get이면 그냥 바로 가고
		actionForward.setCheck(true);
		
		if (method.toLowerCase().equals("post")) {
			MemberDTO dto = new MemberDTO();
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setName(request.getParameter("name"));
			dto.setEmail(request.getParameter("email"));
			dto.setphone(request.getParameter("phone"));
		//	int result = memberDAO.join(dto);
			actionForward.setPath("../index.do");
			actionForward.setCheck(false);
		}//post면 주소를 담음
		
		return actionForward;
	}
	
	public ActionForward memberLogin(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		//성공이면 인덱스 실패면 로그인 폼
		String method=request.getMethod();
		actionForward.setPath("../WEB-INF/member/memberLogin.jsp");
		actionForward.setCheck(true);
		
		
		if(method.toLowerCase().equals("post")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO = memberDAO.login(memberDTO);
			
			actionForward.setCheck(false);
			actionForward.setPath("./memberLogin.do");
			
			if(memberDTO != null) {
				System.out.println("dd");
			actionForward.setPath("../index.do");
//			actionForward.setCheck(false);
			}
		}
		return actionForward;
	}
	
}
