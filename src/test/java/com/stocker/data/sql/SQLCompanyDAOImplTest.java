package com.stocker.data.sql;

import com.stocker.data.CompanyDAO;
import com.stocker.exception.NoCompanyException;
import com.stocker.symbol.Company;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SQLCompanyDAOImplTest {

    private CompanyDAO companyDAO;

    private static final String SYMBOL = "EPAM";

    @Before
    public void prepare() {
        companyDAO = new SQLCompanyDAOImpl();
    }

    @Test
    public void isExist() {
        Company company = new Company();
        CompanyDAO mockDAO = Mockito.spy(companyDAO);
        Mockito.doReturn(company).when(mockDAO).read(Mockito.any(String.class));
        assertTrue(mockDAO.isExist(SYMBOL));
    }

    public void isNotExist() {
        CompanyDAO mockDAO = Mockito.spy(companyDAO);
        Mockito.doThrow(new NoCompanyException("")).when(mockDAO).read(Mockito.any(String.class));
        assertFalse(mockDAO.isExist(SYMBOL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readNullSymbol() {
        companyDAO.read(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readEmptySymbol() {
        companyDAO.read("");
    }

    @Test(expected = NoCompanyException.class)
    public void readNoCompany() {
        CompanyDAO mockDAO = Mockito.spy(companyDAO);
        Mockito.doThrow(new NoCompanyException("")).when(mockDAO).read(Mockito.any(String.class));
        mockDAO.read(SYMBOL);
    }

    @Test
    public void read() {
        Company company = new Company();
        CompanyDAO mockDAO = Mockito.spy(companyDAO);
        Mockito.doReturn(company).when(mockDAO).read(Mockito.any(String.class));
        assertEquals(company, mockDAO.read(SYMBOL));
    }
}