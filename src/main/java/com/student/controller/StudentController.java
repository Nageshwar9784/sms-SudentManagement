package com.student.controller;


import java.util.List;

 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.entity.Student;
import com.student.services.StudentServices;

@Controller
public class StudentController {
	
	StudentServices ss;
	
	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}
	@PostMapping("/addStudent")
	String addStudent(@RequestParam("kodId")String kodId,@RequestParam("sname")String sname,@RequestParam("branch")String branch,RedirectAttributes res) {
		Student s=new Student(kodId,sname,branch);
		ss.addStudent(s);
		res.addFlashAttribute("success", "Student added successfully id {"+kodId+"}");
		return "redirect:/";

	}
	@GetMapping("/viewStudent")
	String viewStudent( @RequestParam("kodId")String kodId, Model m,RedirectAttributes  res) {
		
		try {
			
		Student s= ss.getStudent(kodId);
		m.addAttribute("student",s);
		return "showInfo";
		}
		catch(Exception e){
			res.addFlashAttribute("error", "Student not found id {"+kodId+"}");
			return "redirect:/viewinfo";
		}
		
		
	}
	@GetMapping("/showAll")	
	String getAllStudents(Model model){
		List<Student> slist=ss.getAllStudents();
		model.addAttribute("student", slist);
		return "/showAll";
	}
	@PutMapping("/updateStudent")
	String updateStudent(@RequestParam("kodId")String kodId,@RequestParam("sname")String sname,@RequestParam("branch")String branch,RedirectAttributes res) {
		try {
			Student st=ss.getStudent(kodId);
			st.setSname(sname);
			st.setBranch(branch);
			ss.updateStudent(st);
			res.addFlashAttribute("success", "student added successfully  id {"+kodId+"}");
			return "redirect:/showAll";
		}
		catch(Exception e){
			res.addFlashAttribute("error", "Student not found id {"+kodId+"}");
			return "redirect:/updateinfo";
		}
	}
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("kodId")String kodId,RedirectAttributes res) {
			try{
				ss.getStudent(kodId);
				ss.deleteStudent(kodId);
				res.addFlashAttribute("error", "Student deleted succefullyid {"+kodId+"}");
				return "redirect:/showAll";
			}catch(Exception e) {
				res.addFlashAttribute("error", "Student not found id {"+kodId+"}");
				return "redirect:/remove";
			}
		}
	
	}
	
	
