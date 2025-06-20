package com.dyddeg.employmentguidance.service;

import com.dyddeg.employmentguidance.mapper.RecruitMapper;
import com.dyddeg.employmentguidance.pojo.DTO.RecruitEnterpriseDTO;
import com.dyddeg.employmentguidance.pojo.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {
    @Autowired
    public RecruitMapper recruitMapper;

    public void addRecruit(Recruit recruit) {
        recruitMapper.addRecruit(recruit);
    }

    public List<RecruitEnterpriseDTO> findAllRecruit() {
        return recruitMapper.findAllRecruit();
    }

    public List<RecruitEnterpriseDTO> findRecruitByPosition(Recruit  recruit) {
        return recruitMapper.findRecruitByPosition(recruit.getPosition());
    }

    public List<RecruitEnterpriseDTO> findRecruitByEnterprise(Recruit recruit) {
        return recruitMapper.findRecruitByEnterprise(recruit.getEno());
    }

    public void updateRecruit(Recruit recruit) {
        recruitMapper.updateRecruit(recruit);
    }

    public void deleteRecruit(Recruit recruit) {
        recruitMapper.deleteRecruit(recruit.getRid());
    }
}
