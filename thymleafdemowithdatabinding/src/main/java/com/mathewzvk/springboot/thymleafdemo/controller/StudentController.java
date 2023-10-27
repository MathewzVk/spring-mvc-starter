package com.mathewzvk.springboot.thymleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mathewzvk.springboot.thymleafdemo.model.Student;


@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	
	@Value("${lang}")
	private List<String> languages;
	
	@Value("${operatingSystem}")
	private List<String> operatingSystem;
	
	
	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {
		
		
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countries", countries);
		theModel.addAttribute("languages", languages);
		theModel.addAttribute("operatingSystem", operatingSystem);
		System.out.println(operatingSystem);
		return "student-form";
	}
	
	@PostMapping("processStudentForm")
	public String processStudentForm(@ModelAttribute("student") Student theStudent) {

		System.out.println("theStudent  : " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
}
