package com.cyu.laclad.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "JOINED", table = "PERSONS")
public abstract class Person extends Entity {

    /**
     * Personal ID
     */
    @NotNull
    @Column(name = "PERSONAL_ID", unique = true)
    private Long personalId;

    /**
     */
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     */
    @NotNull
    @NumberFormat(pattern = "########")
    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Direction> directions = new HashSet<Direction>();
}
