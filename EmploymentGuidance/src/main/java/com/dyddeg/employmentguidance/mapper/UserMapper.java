package com.dyddeg.employmentguidance.mapper;
import com.dyddeg.employmentguidance.pojo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(userid, password, state) value(#{userid},#{password},#{state})")
    public void addUser(User user);

    @Select("select * from user where userid = #{userid} and password = #{password}")
    public User findUser(String userid,String password);

    @Delete("delete from user where userid = #{userid}")
    public void deleteUser(String userid);


}
