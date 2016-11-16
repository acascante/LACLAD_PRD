package com.cyu.laclad.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_COMPANIES", inheritanceType = "JOINED", table = "COMPANIES")
public class Company extends JuridicPerson {

    /**
     */
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date enroldDate;
    
    /**
     */
    @Enumerated
    private Status status;
}
