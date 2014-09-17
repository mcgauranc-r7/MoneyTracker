package com.wraith.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: rowan.massey
 * Date: 09/09/2014
 * Time: 21:17
 */
@Entity
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dataupload_id")),
        @AttributeOverride(name = "version", column = @Column(name = "dataupload_version"))})
public class DataUpload extends BaseEntity implements Serializable {

    private String description;
    private Date uploadDate;
    private Users user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dataupload_users_id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Column(name = "dataupload_description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "dataupload_date", nullable = false)
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
