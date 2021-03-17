package com.iu.s1.test;

import java.util.List;

import com.iu.s1.bankbook.BankBookDAO;
import com.iu.s1.bankbook.BankBookDTO;

public class BankBookDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankBookDAO bankBookDAO = new BankBookDAO();
//		try {
//			List<BankBookDTO> ar = bankBookDAO.getList();
//			System.out.println(ar.size()==6);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		bankBookDTO.setBookNum(1);
		
		try {
		bankBookDTO=bankBookDAO.getSelect(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}


