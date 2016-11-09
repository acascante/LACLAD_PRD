package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZ_CHOICES", inheritanceType = "JOINED", table = "QUIZ_CHOICES")
public class QuizChoice extends Entity {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_QUESTION", referencedColumnName = "ID")
    private QuizQuestion question;

    /**
     */
    @NotNull
    @Column(name = "OPTION_NUMBER")
    private Integer optionNumber;

    /**
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     */
    @NotNull
    @Column(name = "IS_TRUE")
    private Boolean isTrue;
}
