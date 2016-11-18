package com.cyu.laclad.domain;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZZES_STUDENTS", inheritanceType = "JOINED", table = "QUIZZES_STUDENTS")
public class QuizStudent extends Entity {

    /**
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_QUIZ", referencedColumnName = "ID")
    private Quiz quiz;

    /**
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID")
    private Student student;

    /**
     */
    @Enumerated
    private Status status;
}
