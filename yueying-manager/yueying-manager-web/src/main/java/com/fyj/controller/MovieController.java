package com.fyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fyj.pojo.Movieinfo;
import com.fyj.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie/{mivieId}")
	@ResponseBody
	private Movieinfo getItemById(@PathVariable Long mivieId) {
		Movieinfo movieItem = movieService.getItemById(mivieId);
		return movieItem;
	}
	
}
