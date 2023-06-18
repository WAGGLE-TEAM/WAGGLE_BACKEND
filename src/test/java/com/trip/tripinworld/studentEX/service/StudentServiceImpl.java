package com.trip.tripinworld.studentEX.service;

import com.trip.tripinworld.studentEX.entity.Student;
import com.trip.tripinworld.studentEX.repository.StudentRepository;
import com.trip.tripinworld.studentEX.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        studentRepository.deleteById(id);
    }
}
