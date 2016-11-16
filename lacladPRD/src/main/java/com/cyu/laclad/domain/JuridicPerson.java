package com.cyu.laclad.domain;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_JURIDIC_PERSONS", inheritanceType = "TABLE_PER_CLASS", table = "JURIDIC_PERSONS")
public abstract class JuridicPerson extends Person {

    /**
     */
    @NotNull
    @Column(name = "JURIDIC_NAME")
    private String juridicName;

    /**
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Contact contact;
}
