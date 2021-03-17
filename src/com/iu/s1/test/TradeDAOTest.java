package com.iu.s1.test;

import java.util.List;

import com.iu.s1.trade.TradeDAO;
import com.iu.s1.trade.TradeDTO;

public class TradeDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TradeDAO tradeDAO = new TradeDAO();
		try {
			List<TradeDTO> ar = tradeDAO.getList();
			
			for(int i =0; i<ar.size(); i++) {
				System.out.println(ar.get(i).getAccountNum());
				System.out.println(ar.get(i).getTradeAmount());
				System.out.println(ar.get(i).getTradeIO());
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
