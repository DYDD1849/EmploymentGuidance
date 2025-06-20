package com.dyddeg.employmentguidance.mapper;

import com.dyddeg.employmentguidance.pojo.DTO.RecruitEnterpriseDTO;
import com.dyddeg.employmentguidance.pojo.entity.Recruit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecruitMapper {

    @Insert("insert into recruit(info,eno,salary,position) value(#{info},#{eno},#{salary},#{position})")
    public void addRecruit(Recruit recruit);

    @Select("select * from recruit,enterprise where recruit.eno=enterprise.eaccount")
    public List<RecruitEnterpriseDTO> findAllRecruit();

    @Select("select * from recruit,enterprise where recruit.eno=enterprise.eaccount and position like concat('%',#{position},'%')")
    List<RecruitEnterpriseDTO> findRecruitByPosition(String position);

    @Select("select * from recruit,enterprise where recruit.eno=enterprise.eaccount and eno=#{eno}")
    List<RecruitEnterpriseDTO> findRecruitByEnterprise(String  eno);

    @Update("update recruit set info=#{info},eno=#{eno},salary=#{salary},position=#{position} where rid=#{rid}")
    public void updateRecruit(Recruit recruit);

    @Delete("delete from recruit where rid=#{rid}")
    public void deleteRecruit(long rid);
}
