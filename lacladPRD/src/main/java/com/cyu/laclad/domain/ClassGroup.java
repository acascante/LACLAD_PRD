package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TypedQuery;

import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_CLASS_GROUPS", inheritanceType = "JOINED", table = "CLASS_GROUPS")
public class ClassGroup extends Entity {

    /**
     * Group Name
     */
    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID")
    private Company company;

    /**
     */
    @Column(name = "STATUS")
    @Enumerated
    private Status status;
    
    /**
     * Group Name
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;
    
    public static List<ClassGroup> findAllClassGroups (Status status) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = ClassGroup.entityManager();
        TypedQuery<ClassGroup> q = em.createQuery("SELECT o FROM ClassGroup AS o WHERE o.status = :status", ClassGroup.class);
        q.setParameter("status", status);
        return q.getResultList();
    }
}
