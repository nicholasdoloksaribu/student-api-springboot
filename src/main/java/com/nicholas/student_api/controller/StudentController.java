package com.nicholas.student_api.controller;

import com.nicholas.student_api.model.Student;
import com.nicholas.student_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity  <List<Student>> getAll() {
        return  ResponseEntity.ok(studentService.getAll()); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity <Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id)); //200
    }

    @PostMapping
    public ResponseEntity <Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(student)); //201
    }

    @PatchMapping("/{id}")
    public ResponseEntity <Student> patch(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(studentService.patch(id, fields)); //200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build(); //204
    }
}
