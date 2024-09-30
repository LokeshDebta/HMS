package com.example.shms.Repository;

import com.example.shms.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentsRepository extends MongoRepository<Student,String> {
    Optional<Student> findByRegistrationNumber(String registrationNumber);
}
