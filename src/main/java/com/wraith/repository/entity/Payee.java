package com.wraith.repository.entity;


import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * User: rowan.massey
 * Date: 16/08/12
 * Time: 22:04
 */
@Entity
@Audited
@AuditTable(value = "Payee_Audit")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "payee_id")),
        @AttributeOverride(name = "version", column = @Column(name = "payee_version"))})
public class Payee extends BaseEntity implements Serializable {

    private String name;

    @NaturalId
    @Column(name = "payee_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
