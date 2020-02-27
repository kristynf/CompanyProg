package com.kristyn.companyprog;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
//    public ArrayList<Employee> findByFirstName(String firstName);
    public ArrayList<Employee> findByFirstNameIgnoreCase(String firstName);
    public ArrayList<Employee> findByLastNameIgnoreCase(String lastName);
}
