package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.busbooking.ShowBusBooking;
import com.example.demo.service.TravellService;

@Controller
public class TravellController1 {
@Autowired
TravellService service;

	@RequestMapping("/")
	public String showLoginpage()
	{
		return "LoginPage";
	}
	
	
	@RequestMapping(value="/LoginPage",method = RequestMethod.POST)
	public String validLogin(@RequestParam("username")String username,@RequestParam("password")String password,Model model)
	{
		int r=service.CheeckRegisterDetails(username, password);
		if(r==1)
		{
		return "HomePage";
		}
		else
		{
			model.addAttribute("wrong","Wrong Credentials");
			return "LoginPage";
		}
	}
	
	@RequestMapping("/RegisterPage")
	public String showRegisterpage()
	{
		return "RegisterPage";
	}
	
	
	@RequestMapping(value="/RegisterPage" , method = RequestMethod.POST)
	public String validRegisterpage(@RequestParam("name")String name,@RequestParam("surname")String surname,@RequestParam("mobile")String mobile,  
			@RequestParam("address")String address,@RequestParam("username")String username,@RequestParam("password")String password,Model model)
	{
		int c=service.CheeckRegisterDetails(username, password);
		if(c==0)
		{
		service.saveRegisterDetails(name, surname, mobile, address, username, password);
		return "LoginPage";
		}
		else
		{
			model.addAttribute("exist","User Already Exist");
			return "RegisterPage";
		}
	}
	
	@RequestMapping("/BusBooking")
	public String showBusBookingpage()
	{
		return "BusBooking";
	}
	
	@RequestMapping(value="/BusBooking", method=RequestMethod.POST)
	public String validBusBooking(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("start")String start
			,@RequestParam("end")String end,@RequestParam("date")String date,@RequestParam("time")String time)
	{
		int check=service.CheeckRegisterDetails(username, password);
		if(check==1)
		{
			service.saveBusBooking(username,password,start,end,date,time);
		return "BusBooking";
		}
		else
		{
			return "HomePage";
		}
	}
	
	
	@RequestMapping("/BusBookingView")
	public String showBusBooking()
	{
		return "BusBookingView";
	}
	
	
	
	
	@RequestMapping(value="/BusBookingView" ,method = RequestMethod.GET)
	public String showBusBookingPage(Model model)
	{
		List<ShowBusBooking> list = service.getBusViewPage();
		model.addAttribute("show", list);
		return "BusBookingView";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
