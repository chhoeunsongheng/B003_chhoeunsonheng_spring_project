package com.hrd.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrd.test.model.User;

@Controller
public class mainController {
	
	List<User> ls;
	@RequestMapping("/student")
	public String Showdata(){
		return "/admin/roleuser";
	}
	
	@RequestMapping("/user-role")
	public String userrole(){
		return "/admin/dashboard";
	}
	
	@RequestMapping("/user-list")
	public String userCU(){
		return "/admin/usercu";
	}
	
	@RequestMapping("/users")
	public String roleuser(Model model){
		ls=new ArrayList<User>();
		ls.add(new User(1,"sok dara","male","sokdara@mail.com"));
		ls.add(new User(2,"sao phana", "male","saophana@mail.com"));
		ls.add(new User(3,"koko sok","female","kokosok@mail.com"));
		ls.add(new User(4,"ratana ret","male","ratanaret@mail.com"));
		ls.add(new User(5,"sola sey", "male","solasey@mail.com"));
		ls.add(new User(6,"dara chanta","female","darachantha@mail.com"));
		ls.add(new User(7,"ratana ret","male","ratanaret@mail"));
		ls.add(new User(8,"sola sey", "male","solasey@mail.com"));
		ls.add(new User(9,"dara chanta","female","darachantha@mail.com"));
		
		model.addAttribute("STU",ls);
	
		return "/admin/userrole";
	}
	
	@RequestMapping("/user-cu")
	public String userform(Model model){
		
		model.addAttribute("USER",new User());
		return "/admin/rolecu";
	}
	

}
