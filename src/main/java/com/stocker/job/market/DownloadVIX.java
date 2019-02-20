package com.stocker.job.market;

import com.stocker.symbol.Day;
import com.stocker.symbol.Market;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZoneId;
import java.util.List;

@Component
public class DownloadVIX {

    public DownloadVIX() {
    }

    public static void downloadVIX(Market market) throws IOException {
        try {
            Stock tesla = YahooFinance.get("^VIX", Interval.DAILY);
            List<HistoricalQuote> histQuotes = tesla.getHistory();
            histQuotes.stream()
                    .filter(data -> data.getDate() != null)
                    .filter(data -> data.getClose() != null).forEach(data -> {
                Day day = new Day(data.getDate().getTime().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
                market.getDay(day).setVIX(data.getClose().doubleValue() / 100);
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
