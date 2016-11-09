package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.QuizType;
import javax.persistence.Enumerated;
import com.cyu.laclad.enums.Status;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_QUIZZES", inheritanceType = "JOINED", table = "QUIZZES")
public class Quiz extends Entity {

    /**
     */
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     */
    @NotNull
    @Enumerated
    private QuizType type;

    /**
     */
    @Enumerated
    private Status status;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<QuizQuestion> questions = new HashSet<QuizQuestion>();
}
