package com.iu.s1.test;

import com.iu.s1.bankbook.BankBookDAO;
import com.iu.s1.bankbook.BankBookDTO;
import com.iu.s1.member.MemberDAO;
import com.iu.s1.member.MemberDTO;

public class MemberDAOTest {
	public static void main(String[] args) {
//		MemberDAO dao = new MemberDAO();
//		MemberDTO dto = new MemberDTO();
//		
//		
//		dto.setId("dd");
//		dto.setPw("dd");
//		dto.setName("dd");
//		dto.setphone("dd");
//		dto.setEmail("dd@dd");
//		try {
//			int num = dao.join(dto);
//			System.out.println(num != 0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		try {
			bankBookDTO=bankBookDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
