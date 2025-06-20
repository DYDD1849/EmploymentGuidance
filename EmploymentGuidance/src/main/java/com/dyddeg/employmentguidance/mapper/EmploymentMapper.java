package com.dyddeg.employmentguidance.mapper;

import com.dyddeg.employmentguidance.pojo.entity.Employment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmploymentMapper {

    @Insert("insert into employment(sno, enterprise, sname, major, tele, info) value(#{sno},#{enterprise},#{sname},#{major},#{tele},#{info})  ")
    public void addEmployment(Employment employment);
    @Select("select * from employment")
    public List<Employment> findAllEmployment();
    @Delete("delete from employment where sno = #{sno}")
    public void deleteEmployment(String sno);
    @Update("update employment set enterprise = #{enterprise},sname = #{sname},major = #{major},tele = #{tele},info = #{info} where sno = #{sno}")
    public void updateEmployment(Employment employment);
}
