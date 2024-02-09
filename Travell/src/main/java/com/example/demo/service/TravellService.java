package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.busbooking.ShowBusBooking;
import com.example.demo.repository.RegRepo;

@Service
public class TravellService {
@Autowired
RegRepo repository;
	
	
	public void saveRegisterDetails(String name, String surname, String mobile, String address, String username,
			String password)
{
		
     repository.saveRegistersinDB(name,surname,mobile,address,username,password);		
}

public int CheeckRegisterDetails(String username,String password)
{
	return repository.CheckRegisterDetails(username, password);
}

public void saveBusBooking(String username,String password,String start, String end, String date, String time) {
	repository.saveBusBookinginDB(username,password,start,end,date,time);
	
}
	

public List<ShowBusBooking> getBusViewPage()
{
	return repository.GetBusBookingDetailsinDB();
}






	
	
	
	
}
