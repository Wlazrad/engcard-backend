package com.wlazrad.word;

import com.wlazrad.models.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User createdByObj;

    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    private ZonedDateTime createdDate = ZonedDateTime.now();

//    @LastModifiedBy
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "modify_by")
//    private User lastModifiedByObj;

    @Column(name = "modify_by", updatable = false, insertable = false)
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "modify_date")
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

}
