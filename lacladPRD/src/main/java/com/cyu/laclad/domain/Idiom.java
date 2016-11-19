package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;
import javax.persistence.TypedQuery;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_IDIOMS", identifierColumn = "ID", inheritanceType = "JOINED", table = "IDIOMS", finders = { "findIdiomsByStatus" })
public class Idiom extends Entity {

    /**
     * Language Name
     */
    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     */
    @Column(name = "STATUS")
    @Enumerated
    private Status status;

    public static List<Idiom> findAllIdioms (Status status) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Idiom.entityManager();
        TypedQuery<Idiom> q = em.createQuery("SELECT o FROM Idiom AS o WHERE o.status = :status", Idiom.class);
        q.setParameter("status", status);
        return q.getResultList();
    }
}
