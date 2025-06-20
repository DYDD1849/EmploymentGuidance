package com.dyddeg.employmentguidance.controller;

import com.dyddeg.employmentguidance.pojo.entity.Student;
import com.dyddeg.employmentguidance.result.Result;
import com.dyddeg.employmentguidance.service.StudentService;
import com.dyddeg.employmentguidance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentService studentService;
    @Autowired
    public UserService userService;
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        userService.deleteUser(student.getSno());
        return Result.success();
    }
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student){
        studentService.UpdateStudent(student);
        return Result.success();
    }
    @GetMapping("/findAllStudent")
    public Result findAllStudent(){
        List<Student> students = studentService.findAllStudent();
        return Result.success(students);
    }
}
