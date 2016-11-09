package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_CONTACTS", inheritanceType = "JOINED", table = "CONTACTS")
public class Contact extends PhysicalPerson {

    /**
     */
    @NotNull
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date enroldDate;

    /**
     */
    @Column(name = "STATUS")
    @Enumerated
    private Status status;
}
