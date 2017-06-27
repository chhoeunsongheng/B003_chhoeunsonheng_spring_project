package com.hrd.test.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hrd.test.model.User;
import com.hrd.test.service.Userservice;

	@Controller
	public class mainController {

		private Userservice userService;
		@Autowired
		public mainController(Userservice userService) {
			this.userService = userService;
		}

		@RequestMapping("/update")
			public String Userupdate(){
				return "/admin/formupdate";
			}
		

		@RequestMapping("/user-role")
		public String userrole(ModelMap model){
			model.addAttribute("user", userService.findAll());
			return "/admin/listuser";
		}
		
		@RequestMapping("/user-list")
		public String userCU(){
			return "/admin/usercu";
		}
		@RequestMapping("/profile")
		public String profileU(){
			return "/admin/profile";
		}
		
		
		@RequestMapping("/user-cu")
		public String userform(Model model){
			model.addAttribute("USER", new User());
     		model.addAttribute("addStatus", true);
			return "/admin/createuser";
		}

		@PostMapping("/user-role")
		public String userlist(@ModelAttribute User user, ModelMap model){
			model.addAttribute("USER", userService.save(user));
			return "redirect:/user-role";
		
		}
		
		@RequestMapping("/user/delete/{user_hash}")
		public String delete(@PathVariable("user_hash") String user_hash){
			if(userService.delete(user_hash)){
				System.out.println("Success");
			}
			return "redirect:/user-role";
		}
				
		@RequestMapping("/update/{user_hash}")
		public String update(@ModelAttribute User user,ModelMap model,@PathVariable("user_hash") String user_hash){
		    user=userService.findOne(user_hash);
			model.addAttribute("USER", user);
     		model.addAttribute("addStatus", true);
			return "/admin/formupdate";
		}
		
		@PostMapping("/user/updated")
		public String updateuserlist(@ModelAttribute User user, @RequestParam String user_hash){
			    user.setUser_hash(user_hash);
			 	userService.update(user);	
			return "redirect:/user-role";
		
		}
		@RequestMapping("/view/{user_hash}")
		public String UserView(@ModelAttribute User user,ModelMap model,@PathVariable("user_hash") String user_hash){
		    user=userService.findOne(user_hash);
			model.addAttribute("USER", user);
     		model.addAttribute("addStatus", true);
			return "/admin/profile";
		}
		@RequestMapping(value="/user/role")
		public String Userrole(){
			return "/admin/user_role";
		}
		
		@RequestMapping(value="/dashboard")
		public String countmale(User user,ModelMap model,String gender){
			//user.setGender("m");
			model.addAttribute("USERM",userService.countMale(gender));
			model.addAttribute("USERF", userService.countFemale(gender));
			model.addAttribute("USER", userService.countFemale(gender)+userService.countMale(gender));
			System.out.println(userService.countMale(gender));
			return "/admin/dashboard";
		}
		
		
}
