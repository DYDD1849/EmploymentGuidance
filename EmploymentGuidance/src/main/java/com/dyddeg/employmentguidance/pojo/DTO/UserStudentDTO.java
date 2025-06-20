package com.dyddeg.employmentguidance.pojo.DTO;

import com.dyddeg.employmentguidance.pojo.entity.Student;
import com.dyddeg.employmentguidance.pojo.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserStudentDTO {
    private String sno;
    private String sname;
    private String gender;
    private String college;
    private String major;
    private long grade;
    private LocalDateTime graduationDate;
    private long employState;
    private String password;
    private long state;

    public void setStudent(Student student){
        this.sno=student.getSno();
        this.sname=student.getSname();
        this.gender=student.getGender();
        this.college=student.getCollege();
        this.major=student.getMajor();
        this.grade=student.getGrade();
        this.graduationDate=student.getGraduationDate();
        this.employState=student.getEmployState();
    }

    public void setUser(User user){
        this.password=user.getPassword();
        this.state=user.getState();
    }
}
