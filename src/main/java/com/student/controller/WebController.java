package com.student.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
	
	
	@GetMapping("/")
	public String mapIndex() {
		return "index";
	}
	@GetMapping("/remove")
	public String mapremoveStudent() {
		return "remove";
	}
	@GetMapping("/viewinfo")
	public String mapviewInformation() {
		return "viewInfo";
	}
	@GetMapping("/updateinfo")
	public String mapupdateInformation() {
		return "updateInfo";
	}
	
	@GetMapping("/addstudent")
	public String mapaddStudent() {
	
		return "addStudent";
	}
	@GetMapping("/error")
	public String maperror() {
		return "error";
	}

	
}
