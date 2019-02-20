package com.stocker.job.company;

import com.stocker.exception.NoDayException;
import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Logger;

@Component
public class DownloadHistoricalData {

    public Company download(Company company) throws NoDayException {
        try {
            Stock companyData = YahooFinance.get(company.getSymbol(), Interval.DAILY);
            List<HistoricalQuote> histQuotes = companyData.getHistory();
            if (histQuotes.stream().filter(data -> data.getDate() == null && data.getClose() == null).count() > 0) {
                throw new NoDayException(String.format("Stock %s has bad data", company.getSymbol()));
            }
            company.getDays().clear();
            histQuotes.stream()
                    .filter(data -> data.getDate() != null)
                    .filter(data -> data.getClose() != null)
                    .forEach(data -> {
                        Day day = new Day(data.getDate().getTime().toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate());
                        day.setPrice(data.getClose().doubleValue());
                        day.setMinPrice(data.getLow().doubleValue());
                        day.setMaxPrice(data.getHigh().doubleValue());
                        day.setVolume(data.getVolume());
                        company.getDays().add(day);
                        day.setCompany(company);
                    });
        } catch (IOException ex) {
            throw new NoDayException(String.format("Stock %s has bad data", company.getSymbol()), ex);
        }

        return company;
    }
}
