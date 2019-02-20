package com.stocker.runner;

import com.stocker.data.csv.CSVCompanyReader;
import com.stocker.data.csv.CSVMarketReader;
import com.stocker.exception.NoMarketException;
import com.stocker.job.market.CalculateMVSMA;
import com.stocker.job.market.CalculateMarketVolume;
import com.stocker.job.market.CalculateMoneyVolume;
import com.stocker.job.market.DownloadVIX;
import com.stocker.symbol.Company;
import com.stocker.symbol.Market;
import com.stocker.data.csv.SymbolsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class CalculateMarketStats {

    @Autowired
    private CSVCompanyReader csvCompanyReader;

    @Autowired
    private CSVMarketReader csvMarketReader;

    public void main(String[] str) {
        try {
            SymbolsReader s = new SymbolsReader();
            List<Company> companies = csvCompanyReader.read(s.readCompanies(SymbolsReader.csvFile));
            Market market;
            market = csvMarketReader.read();

            DownloadVIX.downloadVIX(market);
            CalculateMarketVolume.calculate(market, companies);
            CalculateMoneyVolume.calculate(market, companies);
            CalculateMVSMA.calculate(market);

            market.setDays(new TreeSet<>(market.getDays().stream().filter(
                    day -> day.getVIX() > 0).collect(Collectors.toSet())));

            csvCompanyReader.save(market);
        } catch (IOException | NoMarketException ex) {
            ex.printStackTrace();
        }
    }
}