package com.airline.ticketservice.base.data.entity;

import com.airline.ticketservice.base.data.entity.listener.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.style.ToStringCreator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;
import java.util.Objects;

/**
 * Abstract Entity for holding common attributes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends IdEntity {

    @Version
    @Column(name = "row_version")
    protected long rowVersion;

    @CreatedDate
    @Column(name = "createdate", nullable = false)
    protected Date createdDate = new Date();

    @LastModifiedDate
    @Column(name = "updated_date")
    @JsonIgnore
    protected Date updatedDate = new Date();


    protected BaseEntity() {
    }

    public long getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(long rowVersion) {
        this.rowVersion = rowVersion;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass() && Objects.equals(id, ((BaseEntity) obj).id);
    }

    @Override
    public String toString() {
        return toString(new ToStringCreator(this)).toString();
    }

    protected ToStringCreator toString(ToStringCreator creator) {
        return creator.append("id", getId()).append("rowVersion", getRowVersion());
    }

}