package com.example.demo.controller;

import com.example.demo.service.WordBreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

	@Autowired
	private WordBreakService wordBreakService;

	@RequestMapping("/")
	public String index(Model model) {
		return "wordbreak";
	}

	@RequestMapping("/wordbreak")
	public ModelAndView wordbreak(@RequestParam(value = "sentence",required = false) String sentence,
							@RequestParam(value = "dicString",required = false) String dicString,
							HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wordbreak");
        if (dicString.isEmpty()) {
			return modelAndView;
		}
		String[] dic = dicString.split(",");
		String output = wordBreakService.workBreak(dic, sentence);
        modelAndView.addObject("output", output);
        return modelAndView;
	}


	
}
