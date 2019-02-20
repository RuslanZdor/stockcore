package com.stocker.data.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.stocker.data.CompanyDAO;
import com.stocker.exception.NoCompanyException;
import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import com.stocker.util.StockUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVCompanyReader implements CompanyDAO {

    private static final String emaFolder = "C:\\ruslan_zdor\\stocker\\EMA\\";

    private static String[] columns = {
            "Date",
            "Volume",
            "Price",
            "Min Price",
            "Max Price",

            "Five SMA",
            "Ten SMA",
            "Fifteen SMA",
            "Twenty SMA",
            "Twenty FIve SMA",
            "Thirty SMA",

            "Five EMA",
            "Ten EMA",
            "Fifteen EMA",
            "Twenty EMA",
            "Twenty FIve EMA",
            "Thirty EMA",

            "Five RSI",
            "Ten RSI",
            "Fifteen RSI",
            "Twenty RSI",
            "Twenty FIve RSI",
            "Thirty RSI",

            "Five Average Volume",
            "Ten Average Volume",
            "Fifteen Average Volume",
            "Twenty Average Volume",
            "Twenty FIve Average Volume",
            "Thirty Average Volume",

            "Five VOL",
            "Ten VOL",
            "Fifteen VOL",
            "Twenty VOL",
            "Twenty FIve VOL",
            "Thirty VOL",

            "ThrustDirection",
            "Thrust Five EMA",
            "Thrust Thirty EMA",

            "MACD Line",
            "MACD Signal",

            "Resistance",
            "Support"
    };

    public List<Company> read(List<Company> list) {
        List<Company> result = new ArrayList<>();
        for (Company c : list) {
            try {
                result.add(read(c.getSymbol()));
            } catch (NoCompanyException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Company> readAll() {
        return null;
    }

    public Company read(String symbol) throws NoCompanyException {
        if (isExist(symbol)) {
            Company company = new Company();
            company.setSymbol(symbol);
            try (
                    CSVReader reader = new CSVReader(Files.newBufferedReader(buildFileObject(symbol).toPath()))
                ) {
                String[] nextRecord;
                reader.readNext();
                while ((nextRecord = reader.readNext()) != null) {
                    int i = 0;
                    Day day = new Day(LocalDate.parse(nextRecord[i++], StockUtil.SIMPLE_DATE_FORMAT));
                    day.setVolume(Long.parseLong(nextRecord[i++]));
                    day.setPrice(Double.parseDouble(nextRecord[i++]));
                    day.setMinPrice(Double.parseDouble(nextRecord[i++]));
                    day.setMaxPrice(Double.parseDouble(nextRecord[i++]));

                    day.setFiveSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTenSMA(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentySMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveSMA(Double.parseDouble(nextRecord[i++]));
                    day.setThirtySMA(Double.parseDouble(nextRecord[i++]));

                    day.setFiveEMA(Double.parseDouble(nextRecord[i++]));
                    day.setTenEMA(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenEMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyEMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveEMA(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyEMA(Double.parseDouble(nextRecord[i++]));

                    day.setFiveRSI(Double.parseDouble(nextRecord[i++]));
                    day.setTenRSI(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenRSI(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyRSI(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveRSI(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyRSI(Double.parseDouble(nextRecord[i++]));

                    day.setFiveAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTenAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyAverageVolume(Double.parseDouble(nextRecord[i++]));

                    day.setFiveVOL(Double.parseDouble(nextRecord[i++]));
                    day.setTenVOL(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenVOL(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyVOL(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveVOL(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyVOL(Double.parseDouble(nextRecord[i++]));

                    day.setThrustDirection(Integer.parseInt(nextRecord[i++]));
                    day.setThrustFiveEMA(Double.parseDouble(nextRecord[i++]));
                    day.setThrustThirtyEMA(Double.parseDouble(nextRecord[i++]));

                    day.setMACDLine(Double.parseDouble(nextRecord[i++]));
                    day.setMACDSignal(Double.parseDouble(nextRecord[i++]));

                    day.setResistance(Double.parseDouble(nextRecord[i++]));
                    day.setSupport(Double.parseDouble(nextRecord[i]));

                    company.getDays().add(day);
                }
            } catch (IOException e) {
                throw new NoCompanyException("Data is currapted  for this symbol " + symbol, e);
            }
            return company;
        } else {
            throw new NoCompanyException("There are no data for this company symbol " + symbol);
        }
    }

    public void save(Company company) {
        if (isExist(company.getSymbol())) {
            remove(company);
        }
        try (
            CSVWriter writer = new CSVWriter(Files.newBufferedWriter(buildFileObject(company.getSymbol()).toPath()))
        ) {
            writer.writeNext(columns);
            company.getDays().forEach(data -> {
                String[] arr = {
                        StockUtil.SIMPLE_DATE_FORMAT.format(data.getDate()),
                        Long.toString(data.getVolume()),
                        String.format("%.2f", data.getPrice()),
                        String.format("%.2f",data.getMinPrice()),
                        String.format("%.2f",data.getMaxPrice()),

                        String.format("%.2f",data.getFiveSMA()),
                        String.format("%.2f",data.getTenSMA()),
                        String.format("%.2f",data.getFifteenSMA()),
                        String.format("%.2f",data.getTwentySMA()),
                        String.format("%.2f",data.getTwentyFiveSMA()),
                        String.format("%.2f",data.getThirtySMA()),

                        String.format("%.2f",data.getFiveEMA()),
                        String.format("%.2f",data.getTenEMA()),
                        String.format("%.2f",data.getFifteenEMA()),
                        String.format("%.2f",data.getTwentyEMA()),
                        String.format("%.2f",data.getTwentyFiveEMA()),
                        String.format("%.2f",data.getThirtyEMA()),

                        String.format("%.2f",data.getFiveRSI()),
                        String.format("%.2f",data.getTenRSI()),
                        String.format("%.2f",data.getFifteenRSI()),
                        String.format("%.2f",data.getTwentyRSI()),
                        String.format("%.2f",data.getTwentyFiveRSI()),
                        String.format("%.2f",data.getThirtyRSI()),

                        String.format("%.2f",data.getFiveAverageVolume()),
                        String.format("%.2f",data.getTenAverageVolume()),
                        String.format("%.2f",data.getFifteenAverageVolume()),
                        String.format("%.2f",data.getTwentyAverageVolume()),
                        String.format("%.2f",data.getTwentyFiveAverageVolume()),
                        String.format("%.2f",data.getThirtyAverageVolume()),

                        String.format("%.2f",data.getFiveVOL()),
                        String.format("%.2f",data.getTenVOL()),
                        String.format("%.2f",data.getFifteenVOL()),
                        String.format("%.2f",data.getTwentyVOL()),
                        String.format("%.2f",data.getTwentyFiveVOL()),
                        String.format("%.2f",data.getThirtyVOL()),

                        Integer.toString(data.getThrustDirection()),
                        String.format("%.2f",data.getThrustFiveEMA()),
                        String.format("%.2f",data.getThrustThirtyEMA()),

                        String.format("%.2f",data.getMACDLine()),
                        String.format("%.2f",data.getMACDSignal()),

                        String.format("%.2f",data.getResistance()),
                        String.format("%.2f",data.getSupport())
                };
                writer.writeNext(arr);
            });
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isExist(String symbol) {
        return buildFileObject(symbol).exists();
    }

    private static File buildFileObject(String symbol) {
        return new File(emaFolder, symbol + ".csv");
    }

    public void remove(Company company) {
        try {
            FileUtils.forceDelete(buildFileObject(company.getSymbol()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
