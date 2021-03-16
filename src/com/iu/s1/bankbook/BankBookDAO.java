package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public class BankBookDAO {
	//getList
	//bankbook 테이블의 모든 데이터 조회 후 리턴
	public Map<String, Object> getList() throws Exception{
		HashMap<String, Object> map= new HashMap<>();
		
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		//정보입력, 드라이버 연결, 컨넥션, sql, ?셋팅, 미리받기, 결과 전송 처리, 종료
		String sql = "select * from bankbook";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		map.put("bookname", rs.getString("bookname"));
		map.put("booknum", rs.getInt("booknum"));
		map.put("rate", rs.getDouble("rate"));
		map.put("sal", rs.getString("sal"));
		
		
		
		//BankBookDTO bankBookDTO = null;
		
		
//		for(int i =0; i<rs.getRow(); i++) {
//			bankBookDTO = new BankBookDTO();
//			bankBookDTO.setBookName(rs.getString("bookName"));
//			bankBookDTO.setBookNum(rs.getInt("bookNum"));
//			bankBookDTO.setRate(rs.getDouble("rate"));
//			bankBookDTO.setSal(rs.getString("sal"));
//			
//		}
		
		rs.close();
		st.close();
		con.close();
		
		return map;
	}
}
