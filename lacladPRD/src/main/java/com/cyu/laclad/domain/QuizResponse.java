package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZ_RESPONSES", inheritanceType = "JOINED", table = "QUIZ_RESPONSES")
public class QuizResponse extends Entity {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_QUIZ_STUDENT", referencedColumnName = "ID")
    private QuizStudent quizStudent;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_QUIZ_QUESTION", referencedColumnName = "ID")
    private QuizQuestion question;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ID_CHOICE", referencedColumnName = "ID")
    private QuizChoice choice;
}
