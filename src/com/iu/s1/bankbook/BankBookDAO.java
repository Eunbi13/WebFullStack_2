package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;



public class BankBookDAO {
	//getList
	//bankbook 테이블의 모든 데이터 조회 후 리턴
	public List<BankBookDTO> getList() throws Exception{
		ArrayList<BankBookDTO> ar = new ArrayList<>();
		
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
		
		while(rs.next()) {// 조회한 데이터를 최종적으로 디티오에 담는 것 
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName(rs.getString("bookname"));
			bankBookDTO.setBookNum(rs.getLong("booknum"));
			bankBookDTO.setRate(rs.getDouble("rate"));
			bankBookDTO.setSal(rs.getString("sal"));
			
			//컬렉터;;; 어레이리스트;;;
			ar.add(bankBookDTO); //데이터 유무 사이즈로 구분
		}
	
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
		
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from bankbook where booknum=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBookNum());
		
		ResultSet rs = st.executeQuery();
		
		//BankBookDTO bankBookDTO =null;
		bankBookDTO=null;//만약에 없으면 null을 반환하겠다. 
		
		if(rs.next()) {//이거 무조건 잇어야 하네,,흙흙,,
		bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName(rs.getString("bookName"));
		bankBookDTO.setRate(rs.getDouble("rate"));
		bankBookDTO.setSal(rs.getString("sal"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return bankBookDTO;
		
		//여기까지 하고 테스트를 했어야했음 ㅠㅠ
	}
	
	
	
}
