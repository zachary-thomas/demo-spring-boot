package com.example.demo.repo;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    // What is going on behind the scenes . . .
    // @Query("SELECT s from Student s where s.email = ?1")
    Optional<Student> findByEmail(String email);
}
