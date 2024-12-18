package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Url = "jdbc:mysql://localhost:3306/";
	private static final String UserName = "root";
	private static final String Password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, UserName, Password);
			System.out.println("Enter Email : ");
			String email= sc.next();
			System.out.println("Enter Password : ");
			String password=sc.next();
//			System.out.println("Enter Table Name : ");
			String s ="select * from  student.registrationdetails  where email=? and password=?";
			pmst = conn.prepareStatement(s);
			pmst.setString(1, email);
			pmst.setString(2, password);
			ResultSet rs=pmst.executeQuery();
			if (rs.next()) {
				System.out.println("Successfully Login");
			}
			else {
				System.out.println("Invalid User");
			}
			conn.close();
			pmst.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Error!!");
		}
	}

}
