package kr.green.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;



public class DBConnectTest {
	
	@Test
	public void dbConnectTest() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_jik?useSSL=false&serverTimezone=Asia/Seoul","root","cjgreen");
			System.out.println("DB연결 성공");
			Statement sm = con.createStatement();
			ResultSet rs = sm.executeQuery("select * from member");
			while(rs.next()) {
				System.out.println(rs.getString("me_id") + " : " + rs.getString("me_birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결 실패");
		}
	}
}
