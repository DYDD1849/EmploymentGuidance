package com.dyddeg.employmentguidance.pojo.entity;

import com.dyddeg.employmentguidance.pojo.DTO.UserEnterpriseDTO;
import com.dyddeg.employmentguidance.pojo.DTO.UserStudentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {

  private String userid;
  private String password;
  private long state;

  @JsonIgnore
  public void setUser(UserStudentDTO userStudentDTO){
    this.password=userStudentDTO.getPassword();
    this.state=userStudentDTO.getState();
    this.userid=userStudentDTO.getSno();
  }

  @JsonIgnore
  public void setUser(UserEnterpriseDTO userEnterpriseDTO){
    this.password=userEnterpriseDTO.getPassword();
    this.state=userEnterpriseDTO.getState();
    this.userid=userEnterpriseDTO.getEaccount();
  }



}
