// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.QuizStudent;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect QuizStudent_Roo_Jpa_ActiveRecord {
    
    public static final List<String> QuizStudent.fieldNames4OrderClauseFilter = java.util.Arrays.asList("quiz", "student", "status");
    
    public static long QuizStudent.countQuizStudents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM QuizStudent o", Long.class).getSingleResult();
    }
    
    public static List<QuizStudent> QuizStudent.findAllQuizStudents() {
        return entityManager().createQuery("SELECT o FROM QuizStudent o", QuizStudent.class).getResultList();
    }
    
    public static List<QuizStudent> QuizStudent.findAllQuizStudents(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QuizStudent o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QuizStudent.class).getResultList();
    }
    
    public static QuizStudent QuizStudent.findQuizStudent(Long id) {
        if (id == null) return null;
        return entityManager().find(QuizStudent.class, id);
    }
    
    public static List<QuizStudent> QuizStudent.findQuizStudentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM QuizStudent o", QuizStudent.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<QuizStudent> QuizStudent.findQuizStudentEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QuizStudent o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QuizStudent.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public QuizStudent QuizStudent.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        QuizStudent merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
