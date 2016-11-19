package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.QuizType;
import javax.persistence.Enumerated;
import com.cyu.laclad.enums.Status;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

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
    
    public static List<Quiz> findAllQuizes (Status status) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Quiz.entityManager();
        TypedQuery<Quiz> q = em.createQuery("SELECT o FROM Quiz AS o WHERE o.status = :status", Quiz.class);
        q.setParameter("status", status);
        return q.getResultList();
    }
}
