package com.example.shms.Service;
import com.example.shms.Entity.Student;
import com.example.shms.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentsRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByRegistrationNumber(String registrationNumber) {
        return studentRepository.findByRegistrationNumber(registrationNumber);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String registrationNumber, Student student) {
        Optional<Student> existingStudent = studentRepository.findByRegistrationNumber(registrationNumber);
        if (existingStudent.isPresent()) {
            student.setRegistrationNumber(registrationNumber);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    public void deleteStudent(String registrationNumber) {
        studentRepository.deleteById(registrationNumber);
    }
}
