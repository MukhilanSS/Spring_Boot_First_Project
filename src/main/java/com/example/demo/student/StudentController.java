package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.time.*;
@RestController
@RequestMapping(path="api/v1/student")                  //api
public class StudentController {
    private final StudentService studentService;          //service from
    @Autowired
     public StudentController(StudentService studentService){
         this.studentService=studentService;
     }
     @GetMapping
    public List<Student> getStudents() {
         return studentService.getStudents();// servise to

//             return List.of(
//                     new Student(
//                             1L,
//                             "Mukhil",
//                             "210701169@rajalakshmi.edu.in",
//                             LocalDate.of(2004, Month.JUNE, 23),
//                             21
//                     )
//             );

    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }
}
