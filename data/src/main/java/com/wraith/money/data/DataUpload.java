package com.wraith.money.data;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: rowan.massey
 * Date: 09/09/2014
 */
@Document
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dataupload_id")),
        @AttributeOverride(name = "version", column = @Column(name = "dataupload_version"))})
public class DataUpload extends BaseEntity implements Serializable {

    private String description;
    private Date uploadDate;
    @DBRef
    private Users user;
    @DBRef
    private Set<DataUploadMapping> mappings = new HashSet<>();

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Set<DataUploadMapping> getMappings() {
        return mappings;
    }

    public void setMappings(Set<DataUploadMapping> mappings) {
        this.mappings = mappings;
    }
}
