package com.cyu.laclad.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import com.cyu.laclad.enums.UserType;
import javax.persistence.Enumerated;
import javax.persistence.TypedQuery;
import com.cyu.laclad.enums.Status;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "SQ_SYSTEM_USERS", inheritanceType = "JOINED", table = "SYSTEM_USERS", finders = { "findSystemUsersByUserNameEquals" })
public class SystemUser extends Entity {

    /**
     */
    @NotNull
    @Column(name = "USER_NAME")
    private String userName;

    /**
     */
    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    /**
     */
    @NotNull
    @Column(name = "TYPE")
    @Enumerated
    private UserType type;

    /**
     */
    @Column(name = "STATUS")
    @Enumerated
    private Status status;

    public SystemUser() {
        super();
    }

    public SystemUser(String userName, String password, UserType type, Status status) {
        super();
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

	public static SystemUser findSystemUsersByUserNameEquals(String userName) {
        if (userName == null || userName.length() == 0) throw new IllegalArgumentException("The userName argument is required");
        EntityManager em = SystemUser.entityManager();
        TypedQuery<SystemUser> q = em.createQuery("SELECT o FROM SystemUser AS o WHERE o.userName = :userName", SystemUser.class);
        q.setParameter("userName", userName);
        return q.getSingleResult();
    }
}
