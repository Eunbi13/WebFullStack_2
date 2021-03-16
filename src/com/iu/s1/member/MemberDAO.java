package com.iu.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "SELECT * FROM member WHERE id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setphone(rs.getString("phone"));
			memberDTO.setName(rs.getString("name"));
		}else {
			memberDTO=null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
}
