// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.domain.Teacher;
import com.cyu.laclad.enums.Status;
import java.util.Date;

privileged aspect Teacher_Roo_JavaBean {
    
    public Idiom Teacher.getMainLanguage() {
        return this.mainLanguage;
    }
    
    public void Teacher.setMainLanguage(Idiom mainLanguage) {
        this.mainLanguage = mainLanguage;
    }
    
    public SystemUser Teacher.getSystemUser() {
        return this.systemUser;
    }
    
    public void Teacher.setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
    
    public Date Teacher.getEnroldDate() {
        return this.enroldDate;
    }
    
    public void Teacher.setEnroldDate(Date enroldDate) {
        this.enroldDate = enroldDate;
    }
    
    public Status Teacher.getStatus() {
        return this.status;
    }
    
    public void Teacher.setStatus(Status status) {
        this.status = status;
    }
    
}
