// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Person;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Person_Roo_Jpa_ActiveRecord {
    
    public static final List<String> Person.fieldNames4OrderClauseFilter = java.util.Arrays.asList("personalId", "name", "phoneNumber", "directions");
    
    public static long Person.countPeople() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Person o", Long.class).getSingleResult();
    }
    
    public static List<Person> Person.findAllPeople() {
        return entityManager().createQuery("SELECT o FROM Person o", Person.class).getResultList();
    }
    
    public static List<Person> Person.findAllPeople(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Person o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Person.class).getResultList();
    }
    
    public static Person Person.findPerson(Long id) {
        if (id == null) return null;
        return entityManager().find(Person.class, id);
    }
    
    public static List<Person> Person.findPersonEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Person o", Person.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Person> Person.findPersonEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Person o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Person.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public Person Person.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Person merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
