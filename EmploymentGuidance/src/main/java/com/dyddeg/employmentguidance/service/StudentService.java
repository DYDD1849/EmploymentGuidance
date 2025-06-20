package com.dyddeg.employmentguidance.service;

import com.dyddeg.employmentguidance.mapper.StudentMapper;
import com.dyddeg.employmentguidance.pojo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public void deleteStudent(Student student){
        studentMapper.deleteStudent(student.getSno());
    }
    public List<Student> findAllStudent(){
        return studentMapper.findAllStudent();
    }
    public void UpdateStudent(Student student){
        studentMapper.updateStudent(student);
    }
}
