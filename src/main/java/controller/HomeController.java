package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ServiceClass.BusinessClass;
import model.Auth;
import model.Employee;
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(@ModelAttribute("AUTH")Auth auth,BindingResult result, Model model) {
		System.out.println("Home Page Requested");
		BusinessClass b= new BusinessClass();
		String userName=auth.getUsername();
		String UIpassword=auth.getPassword();
		String password=b.getUSerIDPassword(userName);
		System.out.println("home controller"+password);
		if((password!=null)&&password.equals(UIpassword))
		{
			return "home";
		}
		else
		{
			return "error";
		}
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated Employee user, Model model) {
		System.out.println("User Page Requested");
		BusinessClass businessClass = new BusinessClass();
		boolean value= businessClass.DataSave(user.getEmpid(),user.getEmpname(),user.getEmpaddress(),user.getSalary(),user.getEmpAge());
		model.addAttribute("userName", user.getEmpname());
		return "user";
	}
}