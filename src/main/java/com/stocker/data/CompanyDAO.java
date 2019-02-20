package com.stocker.data;

import com.stocker.exception.NoCompanyException;
import com.stocker.symbol.Company;

import java.io.IOException;
import java.util.List;

public interface CompanyDAO {
    List<Company> readAll();

    Company read(String symbol) throws NoCompanyException;

    void save(Company company);

    boolean isExist(String symbol);

    void remove(Company company) throws NoCompanyException;
}