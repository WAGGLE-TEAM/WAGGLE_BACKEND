package com.trip.tripinworld.studentEX.controller;

import com.trip.tripinworld.studentEX.entity.Student;
import com.trip.tripinworld.studentEX.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Student findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    @DeleteMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void delete(@RequestParam String id) {
        studentService.delete(id);
    }
}
