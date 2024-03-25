package com.example.demo;
//import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.time.*;
//import java.util.ArrayList;
//import java.util.*;
@SpringBootApplication
//@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
//	@GetMapping()
//	public List<Student> print(){
//		return List.of(
//				new Student(
//						1L,
//						"Melon",
//						"melon@gmail.com",
//						LocalDate.of(2004,Month.APRIL,2),
//						21
//				)
//		);
//	}

//	@GetMapping()
//	public List<Student> hello(){
//		return List.of(
//				new Student(
//						1L,
//						"Mukhil",
//						"210701169@rajalakshmi.edu.in",
//						LocalDate.of(2004,Month.JUNE,23),
//						21
//				)
//		);
//
//	}
}
