package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.beans.Student;
import com.example.demo.repository.StudentRepo;

@Controller
public class AdminController {
		
	@Autowired
	private StudentRepo repo;
		@GetMapping("/student")
		public String ShowHomePage() {
			System.out.println("/index mapped");
			return "index";
		}
		@PostMapping("student/insert")
		public String insert(Student st,Model model) {
			repo.save(st);
			System.out.println(""+st.getName());
			model.addAttribute("st",st);			
			return "success";
		}
		
		@GetMapping("student/all")
		public String getStudents(Model model) {
			List<Student> list = new ArrayList<Student>();
			list=repo.findAll();
			model.addAttribute("list",list);
			return "view";
		}
		@GetMapping("student/byname")
		public String getStudent(Model model) {
		List<Student> list = new ArrayList<Student>();
		list=repo.findByName("haleena");
		model.addAttribute("list",list);
		return "view";
		}
		@GetMapping("student/bypass")
		public String getStudentss(Model model) {
		List<Student> list = new ArrayList<Student>();
		list=repo.findByPassIgnoreCase("haleena");
		model.addAttribute("list",list);
		return "view";
		}
		@GetMapping("student/byid")
		public String getStudentsss(Model model) {
		List<Student> list = new ArrayList<Student>();
		list=repo.findByIdBetween(1,5);
		model.addAttribute("list",list);
		return "view";
		}
		
	}
		

