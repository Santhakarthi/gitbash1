package com.hms.PracticePacage;


import java.sql.*;

import com.mysql.jdbc.Driver;


public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try {
			
			Driver driver=new Driver();
			// step1:register/load*MySql*the database*/
			DriverManager.registerDriver(driver);
			//step2:connect to database*/
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root" );
			//step 3:create query statement*/
			 Statement state = con.createStatement();
			 String query="select * from teamranking;";
			 //step4:execute the query*/
			 ResultSet res = state.executeQuery(query);
			 
			while(res.next())
			{
			System.out.println(res.getString(1)+"  "+res.getString(2)+"   "+res.getString(3)+"   "+res.getString(4));
			}
			}
		catch(Exception e)
	{
//to handle exception
	}
		finally {
			//step5:close the connection*/
         con.close();
}
}
}