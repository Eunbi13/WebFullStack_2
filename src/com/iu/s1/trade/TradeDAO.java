package com.iu.s1.trade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TradeDAO {

	public List<TradeDTO> getList()throws Exception{
		ArrayList<TradeDTO> ar = new ArrayList<>();
		
		String user = "user01";
		String password = "user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from trade";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			TradeDTO tradeDTO = new TradeDTO();
			tradeDTO.setTradeNum(rs.getLong("tradeNum"));
			tradeDTO.setAccountNum(rs.getString("accountNum"));
			tradeDTO.settDate(rs.getDate("tDate"));
			tradeDTO.setTradeAmount(rs.getLong("tradeAmount"));
			tradeDTO.setTradeIO(rs.getString("tradeIO"));
			
			ar.add(tradeDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}


}
