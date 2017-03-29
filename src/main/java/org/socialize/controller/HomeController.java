package org.socialize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
	
		//Add the roles here or in data.sql
		
		return "index";
    }
}
