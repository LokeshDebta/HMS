package com.example.shms.Controller;
import com.example.shms.Entity.Student;
import com.example.shms.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{registrationNumber}")
    public Optional<Student> getStudentByRegistrationNumber(@PathVariable String registrationNumber) {
        return studentService.getStudentByRegistrationNumber(registrationNumber);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{registrationNumber}")
    public Student updateStudent(@PathVariable String registrationNumber, @RequestBody Student student) {
        return studentService.updateStudent(registrationNumber, student);
    }

    @DeleteMapping("/{registrationNumber}")
    public void deleteStudent(@PathVariable String registrationNumber) {
        studentService.deleteStudent(registrationNumber);
    }
}
