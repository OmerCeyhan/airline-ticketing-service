package com.airline.ticketservice.base.data.entity;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Abstract Entity for holding common attributes.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class IdEntity implements Serializable {
    private static final int ID_LENGTH = 50;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = ID_LENGTH)
    protected Long id;

    protected IdEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return obj != null && getClass() == obj.getClass() && Objects.equals(id, ((IdEntity) obj).id);
    }

    @Override
    public String toString() {
        return toString(new ToStringCreator(this)).toString();
    }

    protected ToStringCreator toString(ToStringCreator creator) {
        return creator.append("id", getId());
    }

}