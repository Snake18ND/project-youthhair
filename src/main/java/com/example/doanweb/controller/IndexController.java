package com.example.doanweb.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import com.example.doanweb.entity.Employee;
import com.example.doanweb.service.ContactService;
import com.example.doanweb.service.EmployeeService;
import com.example.doanweb.service.IServiceService;
import com.example.doanweb.service.dto.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	IServiceService iService;
	
	@Autowired
	ContactService contactService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	HttpSession session;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("sers",iService.findServicesActive());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());
		
		return "layout/home";
	}
	
	@RequestMapping("/services")
	public String service(Model model) {
		model.addAttribute("services",iService.findServicesActive());
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());
		return "layout/services";
	}
	
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());

		return "layout/contact";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("stylists", employeeService.getAllEmployeeActive());
		model.addAttribute("serviceTop3",iService.findServicesActiveTop3());
		
		return "layout/about";
	}

	@RequestMapping("/booking")
	public String booking(Model model) {
		model.addAttribute("sers",iService.findServicesActive());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
//		for(int i=0; i<listStylist.size();i++){
//			model.addAttribute("bookingIAT",bookingCustomerService.bookingStatusIAT(listStylist.get(i).getId()));
//		}
		return "layout/booking";
	}
	@RequestMapping("/profile")
	public String profile(Model model){
		model.addAttribute("sers",iService.findServicesActive());
		List<Employee> listStylist = employeeService.loadStylist();
		model.addAttribute("stylist",listStylist);
		return "layout/profile";
	}


	@RequestMapping("/admin")
	public String admin(HttpServletRequest req, Principal principal,Model model) {
		System.out.println("/admin");
		Role role= new Role();
		String username = principal.getName();
		User loginUser = (User) ((Authentication) principal).getPrincipal();
		session.setAttribute("role",username);
		String a =(String) session.getAttribute("role") ;
		model.addAttribute("roleuser",a);
		var roleSs= session.getAttribute("role");
		var roleStr = String.valueOf(roleSs);
		System.out.println(roleStr);
		if (roleStr.equals("admin")){
			role.setRoleName("admin");
		}else if(roleStr.equals("staff")) {
			role.setRoleName("staff");
		}
//		return role;

		return "redirect:/admin/templates/index.html";
	}



}
