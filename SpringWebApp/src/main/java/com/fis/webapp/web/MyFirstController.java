package com.fis.webapp.web;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fis.webapp.service.MathService;

@Controller
public class MyFirstController {

	@Autowired
	MathService ms;
	
	public MyFirstController() {
		super();
		System.out.println("Inside Web Controller - default constructor called");
	}
	
	@RequestMapping("/")
	public String showHomePage()
	{
		return "homepage";
	}
	
	@RequestMapping(value = "/doProcessForm",method = RequestMethod.POST)
	public String doThings(HttpServletRequest req, Model model)
	{
		//String username = req.getParameter("username");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		
		StringTokenizer st = new StringTokenizer(email, "@");
	    String name = st.nextToken();
	    System.out.println(name);
	    String domain = email.substring(email.indexOf("@")+1,email.indexOf("."));
		
		//model.addAttribute("username","Mr. "+ username);
		model.addAttribute("userEmail", email);
		model.addAttribute("userName", name);
		model.addAttribute("userDomain", domain);
		
		if(gender.equalsIgnoreCase("male"))
		{
			String user = "Mr. "+email.substring(0, email.indexOf("@"));
			model.addAttribute("user", user);
			System.out.println(user);
		}
		
		if(gender.equalsIgnoreCase("female"))
		{
			String user = "Miss. "+email.substring(0, email.indexOf("@"));
			model.addAttribute("user", user);
			System.out.println(user);
		}
		
		//System.out.println(" ---->> username "+username);
		System.out.println(" ---->> email "+email);
		
		return "displayPage";
	}
	
	@RequestMapping("/maths")
	public String doMaths()
	{
		return "Calculator";
	}
	
	@RequestMapping(value = "/doAddition",method = RequestMethod.POST)
	public String doMathsAdditionCalulation(HttpServletRequest req,Model model)
	{
		int number1 = Integer.parseInt(req.getParameter("number1")); 
		int number2 = Integer.parseInt(req.getParameter("number2"));
		
		int result = ms.doAddition(number1, number2);
		
		model.addAttribute("result", result);
		model.addAttribute("input1", number1);
		model.addAttribute("input2", number2);
		model.addAttribute("task","Addition");
		
		return "displaySum";
		
	}

}