package com.cyu.laclad.domain;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_TEACHERS", inheritanceType = "JOINED", table = "TEACHERS")
public class Teacher extends PhysicalPerson {

    /**
     */
    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_LANGUAGE", referencedColumnName = "ID")
    private Idiom mainLanguage;

    /**
     */
    @NotNull
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private SystemUser systemUser;

    /**
     */
    @NotNull
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date enroldDate;

    /**
     */
    @Enumerated
    private Status status;
}
