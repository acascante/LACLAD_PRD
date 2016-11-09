// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.QuizChoice;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect QuizChoice_Roo_Jpa_ActiveRecord {
    
    public static final List<String> QuizChoice.fieldNames4OrderClauseFilter = java.util.Arrays.asList("question", "optionNumber", "description", "isTrue");
    
    public static long QuizChoice.countQuizChoices() {
        return entityManager().createQuery("SELECT COUNT(o) FROM QuizChoice o", Long.class).getSingleResult();
    }
    
    public static List<QuizChoice> QuizChoice.findAllQuizChoices() {
        return entityManager().createQuery("SELECT o FROM QuizChoice o", QuizChoice.class).getResultList();
    }
    
    public static List<QuizChoice> QuizChoice.findAllQuizChoices(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QuizChoice o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QuizChoice.class).getResultList();
    }
    
    public static QuizChoice QuizChoice.findQuizChoice(Long id) {
        if (id == null) return null;
        return entityManager().find(QuizChoice.class, id);
    }
    
    public static List<QuizChoice> QuizChoice.findQuizChoiceEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM QuizChoice o", QuizChoice.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<QuizChoice> QuizChoice.findQuizChoiceEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QuizChoice o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QuizChoice.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public QuizChoice QuizChoice.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        QuizChoice merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
