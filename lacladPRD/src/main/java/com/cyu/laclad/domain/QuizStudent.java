package com.cyu.laclad.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TypedQuery;

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
    
    public static List<QuizStudent> findQuizStudentEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder, Long id, Status status) {
    	EntityManager em = QuizStudent.entityManager();
    	String jpaQuery = "SELECT o FROM QuizStudent o WHERE o.student.systemUser.id = :id and o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<QuizStudent> q = em.createQuery(jpaQuery, QuizStudent.class);
        q.setParameter("id", id);
        q.setParameter("status", status);
        return q.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    
    public static List<QuizStudent> findAllQuizStudents(String sortFieldName, String sortOrder, Long id, Status status) {
    	EntityManager em = QuizStudent.entityManager();
    	String jpaQuery = "SELECT o FROM QuizStudent o WHERE o.student.systemUser.id = :id and o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<QuizStudent> q = em.createQuery(jpaQuery, QuizStudent.class);
        q.setParameter("id", id);
        q.setParameter("status", status);
        return q.getResultList();
    }
}
