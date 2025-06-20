package com.dyddeg.employmentguidance.mapper;

import com.dyddeg.employmentguidance.pojo.entity.Enterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnterpriseMapper {
    @Insert("insert into enterprise(ename,eaccount,legalman,addr) value(#{ename},#{eaccount},#{legalman},#{addr})")
    public void addEnterprise(Enterprise enterprise);

    @Select("select * from enterprise where eaccount = #{eaccount}")
    public Enterprise findEnterpriseByEaccount(String Eaccount);

}
