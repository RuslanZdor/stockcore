package com.stocker.runner;

import com.stocker.data.csv.CSVCompanyReader;
import com.stocker.data.csv.CSVMarketReader;
import com.stocker.data.csv.CSVTensorFlowReader;
import com.stocker.exception.NoCompanyException;
import com.stocker.exception.NoMarketException;
import com.stocker.job.tensorflow.CalculateTenforFlowDay;
import com.stocker.symbol.Company;
import com.stocker.symbol.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CalculateTensorFlowDays {

    @Autowired
    private CSVMarketReader csvMarketReader;

    @Autowired
    private CSVCompanyReader csvCompanyReader;

    public void calculate(List<Company> companies) throws NoMarketException, NoCompanyException {
        Market market = csvMarketReader.read();
        for (Company company : companies) {
            try {
                Company savedCompany = csvCompanyReader.read(company.getSymbol());
                CalculateTenforFlowDay.calculate(savedCompany, market);
                CSVTensorFlowReader.save(savedCompany);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}