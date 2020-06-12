package com.airline.ticketservice.data.company;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.data.flight.Flight;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "company")
@Table(name = "company")
public class Company extends BaseEntity {

    @NotNull(message = "Company name cannot be null.")
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Flight> flights;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", rowVersion=" + rowVersion +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", id=" + id +
                '}';
    }
}
