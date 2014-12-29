package com.wraith.money.data;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import java.io.Serializable;

/**
 * This class is the object representation of an account type in the database. They include "Current", "Wallet" etc
 *
 * User: rowan.massey
 * Date: 15/08/12
 */
@Document
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "acctype_id")),
        @AttributeOverride(name = "version", column = @Column(name = "acctype_version"))})
public class AccountType extends BaseEntity implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
