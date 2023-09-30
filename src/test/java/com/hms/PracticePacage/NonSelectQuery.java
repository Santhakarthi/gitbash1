package com.hms.PracticePacage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws Throwable {
		int res=0;
		Connection con=null;
		try {
			Driver driver=new Driver();
			// step1:register/load*mysql*the database*/
			DriverManager.registerDriver(driver);
			//step2:connect to db*/
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root" );
			//step 3:create query statement*/
			 Statement state = con.createStatement();
			 
			 String query="Insert into teamranking values('southafrica','Abdeveliers','southAfrica',2)";
			 //step4:executeUpdate the query*/
 res = state.executeUpdate(query);
	}
		catch(Exception e)
		{
			//to handle exception
		}
		finally {
			
			
			if (res==1)
			{
				System.out.println("data is created");
			}
			else {
				System.out.println("data is not created");
			}
			con.close();
		}

}
}