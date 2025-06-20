package com.dyddeg.employmentguidance.mapper;

import com.dyddeg.employmentguidance.pojo.entity.Rfile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RfileMapper {
    @Insert("insert into file(fname,rid) values(#{fname},#{rid})")
    void addFile(Rfile file);
    @Delete("delete from file where rid=#{rid}")
    void deleteFile(long rid);
    @Select("select * from file where rid=#{rid}")
    List<Rfile> findFile(long rid);
}
