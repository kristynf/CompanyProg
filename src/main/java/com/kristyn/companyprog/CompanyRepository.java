package com.kristyn.companyprog;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CompanyRepository extends CrudRepository<Company,Long> {
    public ArrayList<Company> findByName(String name);
}
