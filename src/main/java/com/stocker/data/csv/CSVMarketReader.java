package com.stocker.data.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.stocker.data.MarketDAO;
import com.stocker.exception.NoMarketException;
import com.stocker.symbol.Day;
import com.stocker.symbol.Market;
import com.stocker.util.StockUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

@Service
public class CSVMarketReader implements MarketDAO {

    private static final String emaFolder = "C:\\ruslan_zdor\\stocker\\market\\Market.csv";

    private static String[] columns = {
            "Date",

            "Volume",
            "Five Average Volume",
            "Ten Average Volume",
            "Fifteen Average Volume",
            "Twenty Average Volume",
            "Twenty FIve Average Volume",
            "Thirty Average Volume",

            "VIX",

            "Money Volume",
            "Five Money Volume",
            "Ten Money Volume",
            "Fifteen Money Volume",
            "Twenty Money Volume",
            "Twenty FIve Money Volume",
            "Thirty Money Volume",

    };

    public Market read() throws NoMarketException {
        if (isExist()) {
            Market market = new Market();
            try (
                    CSVReader reader = new CSVReader(Files.newBufferedReader(new File(emaFolder).toPath()))
            ) {
                String[] nextRecord;
                reader.readNext();
                while ((nextRecord = reader.readNext()) != null) {
                    int i = 0;
                    Day day = new Day(LocalDate.parse(nextRecord[i++], StockUtil.SIMPLE_DATE_FORMAT));
                    day.setVolume(Long.parseLong(nextRecord[i++]));
                    day.setFiveAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTenAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyAverageVolume(Double.parseDouble(nextRecord[i++]));

                    day.setVIX(Double.parseDouble(nextRecord[i++]));

                    day.setMoneyVolume(Double.parseDouble(nextRecord[i++]));
                    day.setFiveMVSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTenMVSMA(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenMVSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyMVSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveMVSMA(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyMVSMA(Double.parseDouble(nextRecord[i++]));

                    market.getDays().add(day);
                }
            } catch (IOException ex) {
                throw new NoMarketException("Market file is currupted", ex);
            }
            return market;
        } else {
            throw new NoMarketException("There are no data for for market");
        }
    }

    public void save(Market market) throws IOException {
        try (
                CSVWriter writer = new CSVWriter(Files.newBufferedWriter(new File(emaFolder).toPath()))
        ) {
            writer.writeNext(columns);
            for (Day data : market.getDays()) {
                String[] arr = {
                        StockUtil.SIMPLE_DATE_FORMAT.format(data.getDate()),
                        Long.toString(data.getVolume()),
                        Double.toString(data.getFiveAverageVolume()),
                        Double.toString(data.getTenAverageVolume()),
                        Double.toString(data.getFifteenAverageVolume()),
                        Double.toString(data.getTwentyAverageVolume()),
                        Double.toString(data.getTwentyFiveAverageVolume()),
                        Double.toString(data.getThirtyAverageVolume()),

                        Double.toString(data.getVIX()),

                        Double.toString(data.getMoneyVolume()),
                        Double.toString(data.getFiveMVSMA()),
                        Double.toString(data.getTenMVSMA()),
                        Double.toString(data.getFifteenMVSMA()),
                        Double.toString(data.getTwentyMVSMA()),
                        Double.toString(data.getTwentyFiveMVSMA()),
                        Double.toString(data.getThirtyMVSMA()),
                };
                writer.writeNext(arr);
                writer.flush();
            }
        }
    }

    public boolean isExist() {
        return new File(emaFolder).exists();
    }

    public void remove() throws IOException {
        FileUtils.forceDelete(new File(emaFolder));
    }
}
