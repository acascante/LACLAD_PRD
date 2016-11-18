package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.cyu.laclad.enums.Status;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_STUDENTS", inheritanceType = "JOINED", table = "STUDENTS")
public class Student extends PhysicalPerson {

    /**
     */
    @NotNull
    @Column(name = "ENROLL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date enroldDate;

    /**
     */
    @Enumerated
    private Status status;

    @NotNull
    @OneToOne(cascade = { javax.persistence.CascadeType.ALL })
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private SystemUser systemUser;

    @OneToOne(cascade = { javax.persistence.CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_GROUP", referencedColumnName = "ID")
    private ClassGroup classGroup;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<QuizStudent> quizzes = new HashSet<QuizStudent>();
}
