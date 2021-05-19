package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepo.findByEmail(student.getEmail());

        if (!studentOptional.isPresent()) {
            studentRepo.save(student);
        } else {
            throw new IllegalStateException("Email already taken.");
        }
    }

    @Override
    public void deleteStudent(Long id) {

        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new IllegalStateException("Student with id " + id + " does not exist.");
        }
    }

    @Override
    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student = studentRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Student with id " + id + " does not exist."));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            if (studentRepo.findByEmail(email).isPresent()) {
                throw new IllegalStateException("Email already taken.");
            }

            student.setEmail(email);
        }
    }

}
