package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudents();

    void addNewStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Long id, String name, String email);
}
