package com.nicholas.student_api.model;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student dengan id " + id + " tidak ditemukan");
    }
}
