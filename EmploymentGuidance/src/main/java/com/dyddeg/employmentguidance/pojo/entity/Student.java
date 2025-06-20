package com.dyddeg.employmentguidance.pojo.entity;


import com.dyddeg.employmentguidance.pojo.DTO.UserStudentDTO;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Student {
  private String sno;
  private String sname;
  private String gender;
  private String college;
  private String major;
  private long grade;
  private LocalDateTime graduationDate;
  private long employState;

    public void setStudentByUserStudent(UserStudentDTO userStudentDTO){
    this.sno=userStudentDTO.getSno();
    this.sname=userStudentDTO.getSname();
    this.gender=userStudentDTO.getGender();
    this.college=userStudentDTO.getCollege();
    this.major=userStudentDTO.getMajor();
    this.grade=userStudentDTO.getGrade();
    this.graduationDate=userStudentDTO.getGraduationDate();
    this.employState=userStudentDTO.getEmployState();
  }

}
