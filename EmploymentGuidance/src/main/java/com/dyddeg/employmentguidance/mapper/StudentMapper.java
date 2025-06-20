package com.dyddeg.employmentguidance.mapper;

import com.dyddeg.employmentguidance.pojo.entity.Student;
import com.dyddeg.employmentguidance.pojo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("insert into student(sno, sname, gender, college, major, grade, graduation_date, employ_state) value(#{sno}, #{sname}, #{gender}, #{college}, #{major}, #{grade}, #{graduationDate}, #{employState})")
    public void addStudent(Student student);

    @Select("select * from student where sno = #{sno}")
    public Student findStudentBySno(String sno);

    @Select("select * from student")
    public List<Student> findAllStudent();

    @Delete("delete from student where sno = #{sno}")
    public void deleteStudent(String sno);
    @Update("update student set sname = #{sname}, gender = #{gender}, college = #{college}, major = #{major}, grade = #{grade}, graduation_date = #{graduationDate}, employ_state = #{employState} where sno = #{sno}")
    public void updateStudent(Student student);
}
