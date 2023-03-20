package com.exampleSpringBoot_ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exampleSpringBoot_ex.services.IstruzioniService;

@Controller
@RequestMapping("/inizio")
public class HomeController {
	@Autowired IstruzioniService istruzioni;
	
	@GetMapping("/home")
	public ModelAndView formLingua() {
		ModelAndView model = new ModelAndView("home");
		return model;	
	}
	
	@PostMapping("/setlingua")
	public ModelAndView selezionaLingua(@RequestParam String lingua) {
		ModelAndView model = new ModelAndView("istruzioni");
		String s = istruzioni.check(lingua);	
		model.addObject("lingua",s);
		return model;
	}
}
