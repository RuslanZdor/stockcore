package com.stocker.runner;

import com.stocker.data.csv.CSVCompanyReader;
import com.stocker.symbol.Company;
import com.stocker.data.csv.SymbolsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindVolataileStocks {

    @Autowired
    private CSVCompanyReader csvCompanyReader;

    public List<Company> main() {
        SymbolsReader s = new SymbolsReader();
        List<Company> companies;
        companies = s.readCompanies(SymbolsReader.csvFile);
        return findBestRisingIntersections(companies);
    }

    private List<Company> findBestRisingIntersections(List<Company> companies) {
        return csvCompanyReader.read(companies).stream()
            .filter(c -> c.getDays().size() > 3)
            .filter(c -> c.getDays().first().getPrice() > 25)
            .filter(c -> c.getDays().first().getVolume() > 200000)
            .filter(c -> c.getDays().first().getThirtyVOL() > 0.2)
            .filter(c -> c.getDays().first().getFiveVOL() > 0.1)
            .filter(c -> c.getDays().first().getFiveRSI() < 0.4)
            .collect(Collectors.toList());
    }
}