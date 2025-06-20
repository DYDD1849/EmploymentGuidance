package com.dyddeg.employmentguidance.controller;

import com.dyddeg.employmentguidance.pojo.entity.Employment;
import com.dyddeg.employmentguidance.result.Result;
import com.dyddeg.employmentguidance.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmploymentController {
    @Autowired
    private EmploymentService employmentService;
    @PostMapping("/addEmployment")
    public Result addEmployment(@RequestBody Employment employment){

        employmentService.addEmployment(employment);
        return Result.success();
    }
    @GetMapping("/findAllEmployment")
    public Result findAllEmployment(){
        return Result.success(employmentService.findAllEmployment());
    }
    @PostMapping("/deleteEmployment")
    public Result deleteEmployment(@RequestBody Employment employment){
        employmentService.deleteEmployment(employment);
        return Result.success();
    }
    @PostMapping("/updateEmployment")
    public Result updateEmployment(@RequestBody Employment employment){
        employmentService.updateEmployment(employment);
        return Result.success();
    }
}
