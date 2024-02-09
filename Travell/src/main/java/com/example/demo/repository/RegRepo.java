package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.busbooking.ShowBusBooking;

@Repository
public class RegRepo {

	public void saveRegistersinDB(String name, String surname, String mobile, String address, String username,
			String password)
	{
	
		try 
		{
			String query="insert into registerdetails(name,surname,mobile,address,username,password) values(?,?,?,?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travell","root","root");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, mobile);
			ps.setString(4, address);
			ps.setString(5, username);
			ps.setString(6, password);
			ps.execute();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
public int CheckRegisterDetails(String username,String password)
{
	ResultSet rs=null;
	int count=0;
	try
	{
		String query="Select count(*) From registerdetails where username=? and password=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travell","root","root");
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		rs=ps.executeQuery();
		if(rs.next())
		{
			count=rs.getInt(1);
		}
		rs.close();
		ps.close();
		con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
return count;
	
}


public void saveBusBookinginDB(String username,String password,String start, String end, String date, String time) 
{
   try
   {
	   String query="insert into busbookingdetails(start,end,date,time) values(?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travell","root","root");
		PreparedStatement ps=con.prepareStatement(query); 
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, start);
		ps.setString(4, end);
		ps.setString(5, date);
		ps.setString(6, time);
		ps.execute();
		ps.close();
		con.close();
   }
   catch(Exception e)
   {
	 e.printStackTrace();  
   }
	
}
	
	
	

public List<ShowBusBooking> GetBusBookingDetailsinDB()
{
	ResultSet rs=null;
	List<ShowBusBooking> list= new ArrayList<ShowBusBooking>();
	try
	{
		 String query="select * from busbookingdetails";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travell","root","root");
			PreparedStatement ps=con.prepareStatement(query); 
			rs=ps.executeQuery();
			   while(rs.next())
				{
				    ShowBusBooking bus=new ShowBusBooking();
					bus.getUsername();
					bus.getPassword();
					bus.getStart();
					bus.getEnd();
					bus.getDate();
					bus.getTime();
			list.add(bus);
				}
				
			
		rs.close();
		ps.close();
		con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
return list;		
}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
