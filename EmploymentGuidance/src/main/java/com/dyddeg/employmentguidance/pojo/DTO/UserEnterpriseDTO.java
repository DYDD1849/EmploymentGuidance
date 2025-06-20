package com.dyddeg.employmentguidance.pojo.DTO;

import com.dyddeg.employmentguidance.pojo.entity.Enterprise;
import com.dyddeg.employmentguidance.pojo.entity.User;
import lombok.Data;

@Data
public class UserEnterpriseDTO {
    private String password;
    private long state;
    private String ename;
    private String eaccount;
    private String legalman;
    private String addr;

    public void setEnterprise(Enterprise enterprise) {
        this.ename = enterprise.getEname();
        this.eaccount = enterprise.getEaccount();
        this.legalman = enterprise.getLegalman();
        this.addr = enterprise.getAddr();
    }

    public void setUser(User user) {
        this.password = user.getPassword();
        this.state = user.getState();
    }
}
