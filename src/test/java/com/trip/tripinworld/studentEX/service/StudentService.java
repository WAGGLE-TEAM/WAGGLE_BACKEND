package com.trip.tripinworld.studentEX.service;

import com.trip.tripinworld.studentEX.entity.Student;

public interface StudentService {
    Student save(Student student);
    Student findByName(String name);
    void delete (String id);
}
