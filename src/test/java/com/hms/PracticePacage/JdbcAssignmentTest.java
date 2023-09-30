
package com.hms.PracticePacage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class JdbcAssignmentTest {

	public static void main(String[] args) throws Throwable {
		int res = 0;
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name into tyss");
		String name1 = sc.nextLine();
		Driver driver = new Driver();
		// step1:register/load*mysql*the database*/
		DriverManager.registerDriver(driver);
		// step2:connect to db*/
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
		// step 3:create query statement*/
		Statement state = con.createStatement();
		int count = 0;
		String q1 = "Select name from tyss;";
		String q2 = "insert into tyss (name) values('" + name1 + "');";
		ResultSet res1 = state.executeQuery(q1);
		while (res1.next()) {
			String bName = res1.getString(1);
			if (bName.equalsIgnoreCase(name1)) {
				System.out.println(name1 + " is already existing in tyss");
				count++;
				break;
			}

			if (count == 0) {
				res = state.executeUpdate(q2);
				
			}
			if (res > 0) {
				System.out.println(name1 + " is entered in tyss");
			}
			System.out.println();
			String q3 = "Select * from tyss order by id;";
			ResultSet res3 = state.executeQuery(q3);
			System.out.println("Updated table");
			while (res3.next()) {
				System.out.println(res3.getString(1) + " " + res3.getString(2));
			}

		}
	}
}
