package com.stocker.job.tensorflow;

import com.stocker.data.csv.CSVCompanyReader;
import com.stocker.data.csv.CSVMarketReader;
import com.stocker.data.csv.CSVTensorFlowReader;
import com.stocker.exception.NoCompanyException;
import com.stocker.exception.NoMarketException;
import com.stocker.symbol.Company;
import com.stocker.symbol.Market;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CalculateTenforFlowDayTest {

    private CSVCompanyReader csvCompanyReader;
    private CSVMarketReader csvMarketReader;

    @Before
    public void init() {
        csvCompanyReader = new CSVCompanyReader();
        csvMarketReader = new CSVMarketReader();
    }

    @Ignore
    @Test
    public void calculateCount() throws IOException, NoCompanyException {
        Company company = csvCompanyReader.read("EPAM");
        Market market = new Market();
        CalculateTenforFlowDay.calculate(company, market);
        assertEquals(company.getDays().size() - 1, company.getTensorFlowDay().size());
        CSVTensorFlowReader.save(company);
    }
}