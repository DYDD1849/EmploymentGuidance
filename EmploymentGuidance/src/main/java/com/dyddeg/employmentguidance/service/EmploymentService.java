package com.dyddeg.employmentguidance.service;

import com.dyddeg.employmentguidance.mapper.EmploymentMapper;
import com.dyddeg.employmentguidance.pojo.entity.Employment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentService {
    @Autowired
    private EmploymentMapper employmentMapper;
    public void addEmployment(Employment employment) {
        employmentMapper.addEmployment(employment);
    }
    public List<Employment> findAllEmployment() {
        return employmentMapper.findAllEmployment();
    }
    public void deleteEmployment(Employment employment) {
        employmentMapper.deleteEmployment(employment.getSno());
    }
    public void updateEmployment(Employment employment) {
        employmentMapper.updateEmployment(employment);
    }
}
