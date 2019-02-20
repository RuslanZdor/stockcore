package com.stocker.data.sql;

import com.stocker.data.CompanyDAO;
import com.stocker.exception.NoCompanyException;
import com.stocker.symbol.Company;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLCompanyDAOImpl implements CompanyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Company> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from Company").list();
    }

    public Company read(String symbol) throws NoCompanyException {
        if (StringUtils.isBlank(symbol)) {
            throw new IllegalArgumentException("Company symbol cannot be empty");
        }
        Company company = sessionFactory.getCurrentSession().get(Company.class, symbol);
        if (company == null) {
            throw new NoCompanyException(String.format("No company with symbol %s", symbol));
        }
        return company;
    }

    @Override
    public void save(Company company) {
        sessionFactory.getCurrentSession().saveOrUpdate(company);
    }

    @Override
    public boolean isExist(String symbol) {
        boolean flag;
        try {
            read(symbol);
            flag = true;
        } catch (NoCompanyException e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public void remove(Company company) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete Day where symbol = :symbol");
        query.setParameter("symbol", company.getSymbol());
        query.executeUpdate();
        sessionFactory.getCurrentSession().flush();

        query = sessionFactory.getCurrentSession().createQuery("delete TensorFlowDay where symbol = :symbol");
        query.setParameter("symbol", company.getSymbol());
        query.executeUpdate();
        sessionFactory.getCurrentSession().flush();

        query = sessionFactory.getCurrentSession().createQuery("delete Company where symbol = :symbol");
        query.setParameter("symbol", company.getSymbol());
        query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
    }
}
