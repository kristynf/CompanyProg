package com.kristyn.companyprog;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public Set<Employee> employees;
    @NotNull
    @Size(min=3)
    private String name;

    public Company() {
    }

    public Company(Set<Employee> employees, @Size(min = 3) String name) {
        this.employees = employees;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
