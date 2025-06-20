package com.dyddeg.employmentguidance.controller;

import com.dyddeg.employmentguidance.pojo.DTO.RecruitEnterpriseDTO;
import com.dyddeg.employmentguidance.pojo.entity.Recruit;
import com.dyddeg.employmentguidance.result.Result;
import com.dyddeg.employmentguidance.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @PostMapping("/addRecruit")
    public Result addRecruit(@RequestBody Recruit recruit) {
        recruitService.addRecruit(recruit);
        return Result.success();
    }

    @GetMapping("/findAllRecruit")
    public Result findAllRecruit() {
        List<RecruitEnterpriseDTO> recruitEnterpriseDTOList = recruitService.findAllRecruit();
        return Result.success(recruitEnterpriseDTOList);
    }

    @PostMapping("/findRecruitByPosition")
        public Result findRecruitByPosition(@RequestBody Recruit recruit) {
            List<RecruitEnterpriseDTO>  recruitEnterpriseDTOList= recruitService.findRecruitByPosition(recruit);
            return Result.success(recruitEnterpriseDTOList);
        }
        @PostMapping("/findRecruitByEnterprise")
        public Result findRecruitByEnterprise(@RequestBody Recruit recruit) {
        List<RecruitEnterpriseDTO>  recruitEnterpriseDTOList= recruitService.findRecruitByEnterprise(recruit);
        return Result.success(recruitEnterpriseDTOList);
        }
        @PostMapping("/updateRecruit")
        public Result updateRecruit(@RequestBody Recruit recruit) {
        recruitService.updateRecruit(recruit);
        return Result.success();
        }

        @PostMapping("/deleteRecruit")
        public Result deleteRecruit(@RequestBody Recruit recruit) {
        recruitService.deleteRecruit(recruit);
        return Result.success();
        }

}
