package com.stocker.runner;

import com.stocker.data.csv.SymbolsReader;
import com.stocker.exception.NoCompanyException;
import com.stocker.exception.NoMarketException;
import com.stocker.symbol.Company;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class CalculateTensorFlowDaysTest {

    private CalculateTensorFlowDays calculateTensorFlowDays;
    private SymbolsReader symbolsReader;

    @Before
    public void init() {
        symbolsReader = new SymbolsReader();
        calculateTensorFlowDays = new CalculateTensorFlowDays();
    }

    @Ignore
    @Test
    public void calculate() throws NoMarketException, NoCompanyException {
        List<Company> companies = symbolsReader.readCompanies(SymbolsReader.csvFile);
        calculateTensorFlowDays.calculate(companies);
    }
}