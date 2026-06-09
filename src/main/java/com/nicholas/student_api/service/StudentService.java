package com.nicholas.student_api.service;


import com.nicholas.student_api.model.Student;
import com.nicholas.student_api.model.StudentNotFoundException;
import com.nicholas.student_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student patch(Long id, Map<String, Object> fields) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        fields.forEach((key, value) -> {
            switch (key) {
                case "name" -> existing.setName((String) value);
                case "age" -> existing.setAge((Integer) value);
                case "gpa" -> existing.setGpa((Double) value);
            }
        });

        return studentRepository.save(existing);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
