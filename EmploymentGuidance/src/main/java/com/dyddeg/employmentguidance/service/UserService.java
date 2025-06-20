package com.dyddeg.employmentguidance.service;

import com.dyddeg.employmentguidance.mapper.EnterpriseMapper;
import com.dyddeg.employmentguidance.mapper.StudentMapper;
import com.dyddeg.employmentguidance.pojo.DTO.UserEnterpriseDTO;
import com.dyddeg.employmentguidance.pojo.DTO.UserStudentDTO;
import com.dyddeg.employmentguidance.pojo.entity.Enterprise;
import com.dyddeg.employmentguidance.pojo.entity.Student;
import com.dyddeg.employmentguidance.pojo.entity.User;
import com.dyddeg.employmentguidance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    EnterpriseMapper enterpriseMapper;

    public void addStudent(UserStudentDTO userStudentDTO){
        User user=new User();
        Student student=new Student();
        user.setUser(userStudentDTO);
        student.setStudentByUserStudent(userStudentDTO);
        userMapper.addUser(user);
        studentMapper.addStudent(student);
    }
    public void addEnterprise(UserEnterpriseDTO userEnterpriseDTO){
        User user=new User();
        Enterprise enterprise=new Enterprise();
        user.setUser(userEnterpriseDTO);
        enterprise.setEnterpriseByUserEnterprise(userEnterpriseDTO);
        userMapper.addUser(user);
        enterpriseMapper.addEnterprise(enterprise);
    }

    public User findUser(String userid,String password){
        return userMapper.findUser(userid,password);
    }
    public UserStudentDTO findUserStudentByUser(User user){
        UserStudentDTO userStudentDTO=new UserStudentDTO();
        Student student=studentMapper.findStudentBySno(user.getUserid());
        userStudentDTO.setStudent(student);
        userStudentDTO.setUser(user);
        return userStudentDTO;
    }
    public UserEnterpriseDTO findUserEnterpriseByUser(User user){
        UserEnterpriseDTO userEnterpriseDTO=new UserEnterpriseDTO();
        Enterprise enterprise=enterpriseMapper.findEnterpriseByEaccount(user.getUserid());
        userEnterpriseDTO.setEnterprise(enterprise);
        userEnterpriseDTO.setUser(user);
        return userEnterpriseDTO;
    }
    public void deleteUser(String userid){
        userMapper.deleteUser(userid);
    }
}
