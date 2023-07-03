package com.trip.tripinworld.studentEX.repository;

import com.trip.tripinworld.studentEX.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByName(String name);
}
