package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
//       return List.of(
//                new Student(
//                        1L,
//                        "Mohanapriya",
//                        "210701169@rajalakshmi.edu.in",
//                        LocalDate.of(2004, Month.JUNE, 23),
//                        21
//                )
//        );
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptinal=studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptinal.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
//        System.out.println(student);
    }
    public void deleteStudent(Long studentId){
        boolean exists=studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("student with id "+ studentId+" does not exists");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email){
        Student student=studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "+studentId+"does not exist"));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student>studentOptional=studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }


    }
}
