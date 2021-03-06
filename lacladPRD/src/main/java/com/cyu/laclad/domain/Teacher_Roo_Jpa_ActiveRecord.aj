// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Teacher;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Teacher_Roo_Jpa_ActiveRecord {
    
    public static final List<String> Teacher.fieldNames4OrderClauseFilter = java.util.Arrays.asList("mainLanguage", "systemUser", "enroldDate", "status");
    
    public static long Teacher.countTeachers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Teacher o", Long.class).getSingleResult();
    }
    
    public static List<Teacher> Teacher.findAllTeachers() {
        return entityManager().createQuery("SELECT o FROM Teacher o", Teacher.class).getResultList();
    }
    
    public static List<Teacher> Teacher.findAllTeachers(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Teacher o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Teacher.class).getResultList();
    }
    
    public static Teacher Teacher.findTeacher(Long id) {
        if (id == null) return null;
        return entityManager().find(Teacher.class, id);
    }
    
    public static List<Teacher> Teacher.findTeacherEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Teacher o", Teacher.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Teacher> Teacher.findTeacherEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Teacher o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Teacher.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public Teacher Teacher.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Teacher merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
