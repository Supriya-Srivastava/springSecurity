package com.example.securepp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.securepp.model.Employee;
import com.example.securepp.repo.EmployeeDao;

@Controller
public class secureController {
	
	@Autowired 
	private EmployeeDao empdao;
	
	
	@RequestMapping("/")
	public String  home()
	{
		return "home"; 
	}

	
	@RequestMapping("/addEmployee")
	public String  employeeSave(Employee employee)
	{
		empdao.save(employee);
		return empdao.findAll().toString(); 
	}
	
	
	

	@RequestMapping("/employee")
	@ResponseBody
	public String  getAllEmployee()
	{
		/* Employee employee =empdao.findById(aid).orElse(new Employee()); */
		
		return   empdao.findAll().toString();
	}
	
	

	@RequestMapping("/employee/{aid}")
	@ResponseBody
	public String  getAllEmployeeID(@PathVariable("aid") Integer aid)
	{
		/* Employee employee =empdao.findById(aid).orElse(new Employee()); */
		
		return   empdao.findById(aid).toString();
	}
	
	
	
	
	@RequestMapping("/login")
	public String  loginPage()
	{
		return "login"; 
	}
	
	
	@RequestMapping("/logout-success")
	public String  logutPage()
	{
		return "logout"; 
	}
	
	@RequestMapping("/logout")
	public String  logout()
	{
		return "logout"; 
	}
	
	
}
