package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZ_QUESTIONS", inheritanceType = "JOINED", table = "QUIZ_QUESTIONS")
public class QuizQuestion extends Entity {

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_QUIZ", referencedColumnName = "ID")
    private Quiz quiz;

    /**
     */
    @NotNull
    @Column(name = "QUESTION_NUMBER")
    private Integer questionNumber;

    /**
     */
    @NotNull
    @Column(name = "STATEMENT")
    private String statement;
}
