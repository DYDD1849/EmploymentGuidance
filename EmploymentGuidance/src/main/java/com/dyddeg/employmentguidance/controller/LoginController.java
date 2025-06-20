package com.dyddeg.employmentguidance.controller;

import com.dyddeg.employmentguidance.pojo.DTO.UserEnterpriseDTO;
import com.dyddeg.employmentguidance.pojo.DTO.UserStudentDTO;
import com.dyddeg.employmentguidance.pojo.entity.User;
import com.dyddeg.employmentguidance.result.Result;
import com.dyddeg.employmentguidance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/StudentRegister")
    public Result addUser(@RequestBody UserStudentDTO userStudentDTO){
        userService.addStudent(userStudentDTO);
        return Result.success();
    }

    @PostMapping("/EnterpriseRegister")
    public Result addUser(@RequestBody UserEnterpriseDTO userEnterpriseDTO){
        userService.addEnterprise(userEnterpriseDTO);
        return Result.success();
    }

    @PostMapping("/Login")
    public Result login(@RequestBody User user1){
        User user = userService.findUser(user1.getUserid(),user1.getPassword());
        System.out.println("请求成功");
        if(user == null){
            return Result.error("用户不存在");
        }
        else {
            if(user.getState()==1){
                return Result.success(userService.findUserStudentByUser(user));
            }
            else if(user.getState()==2){
                return Result.success(userService.findUserEnterpriseByUser(user));
            } else if (user.getState()==3) {
                return Result.success(user);
            } else{
                return Result.error("用户状态异常");
            }
        }

    }


}
