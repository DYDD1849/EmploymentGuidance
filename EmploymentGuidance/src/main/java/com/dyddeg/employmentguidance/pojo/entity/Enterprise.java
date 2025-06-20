package com.dyddeg.employmentguidance.pojo.entity;

import com.dyddeg.employmentguidance.pojo.DTO.UserEnterpriseDTO;
import lombok.Data;

@Data
public class Enterprise {

  private String ename;
  private String eaccount;
  private String legalman;
  private String addr;


  public void setEnterpriseByUserEnterprise(UserEnterpriseDTO userEnterpriseDTO){
    this.ename=userEnterpriseDTO.getEname();
    this.eaccount=userEnterpriseDTO.getEaccount();
    this.legalman=userEnterpriseDTO.getLegalman();
    this.addr=userEnterpriseDTO.getAddr();
  }


}
