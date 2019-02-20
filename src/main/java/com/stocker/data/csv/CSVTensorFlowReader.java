package com.stocker.data.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.stocker.exception.NoCompanyException;
import com.stocker.symbol.Company;
import com.stocker.symbol.tensorflow.TensorFlowDay;
import com.stocker.util.StockUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CSVTensorFlowReader {

    private static final String emaFolder = "C:\\ruslan_zdor\\stocker\\TensorFlow\\";

    private static String[] columns = {
        "Five EMA",
        "Ten EMA",
        "Fifteen EMA",
        "Twenty EMA",
        "Twenty Five EMA",
        "Thirty EMA",
        "Five SMA",
        "Ten SMA",
        "Fifteen SMA",
        "Twenty SMA",
        "Twenty Five SMA",
        "Thirty SMA",
        "Five RSI",
        "Ten RSI",
        "Fifteen RSI",
        "Twenty RSI",
        "Twenty Five RSI",
        "Thirty RSI",
        "Five Average Volume",
        "Ten Average Volume",
        "Fifteen Average Volume",
        "Twenty Average Volume",
        "Twenty Five Average Volume",
        "Thirty Average Volume",
        "Five VOL",
        "Ten VOL",
        "Fifteen VOL",
        "Twenty VOL",
        "Twenty Five VOL",
        "Thirty VOL",
        "Thrust Five EMA",
        "Thrust Thirty EMA",
        "MACD Line",
        "MACD Signal",
        "resistance",
        "support",
        "min Price",
        "max Price",
        "VIX",
        "five Market Average Volume",
        "ten Market Average Volume",
        "fifteen Market Average Volume",
        "twenty Market Average Volume",
        "twenty Five Market Average Volume",
        "thirty Market Average Volume",
        "five Market Money Volume",
        "ten Market Money Volume",
        "fifteen Market Money Volume",
        "twenty Market Money Volume",
        "twenty Market Five Money Volume",
        "thirty Market Money Volume",

        "day Difference",
        "Date"
    };

    public static List<Company> read(List<Company> list) throws NoCompanyException {
        List<Company> result = new ArrayList<>();
        for (Company c : list) {
            result.add(read(c.getSymbol()));
        }
        return result;
    }

    public static Company read(String symbol) throws NoCompanyException {
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
                    TensorFlowDay day = new TensorFlowDay();
                    day.setFiveEMA(Double.parseDouble(nextRecord[i++]));
                    day.setTenEMA(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenEMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyEMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveEMA(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyEMA(Double.parseDouble(nextRecord[i++]));

                    day.setFiveSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTenSMA(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenSMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentySMA(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveSMA(Double.parseDouble(nextRecord[i++]));
                    day.setThirtySMA(Double.parseDouble(nextRecord[i++]));

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

                    day.setThrustFiveEMA(Double.parseDouble(nextRecord[i++]));
                    day.setThrustThirtyEMA(Double.parseDouble(nextRecord[i++]));

                    day.setMACDLine(Double.parseDouble(nextRecord[i++]));
                    day.setMACDSignal(Double.parseDouble(nextRecord[i++]));

                    day.setResistance(Double.parseDouble(nextRecord[i++]));
                    day.setSupport(Double.parseDouble(nextRecord[i++]));

                    day.setMinPrice(Double.parseDouble(nextRecord[i++]));
                    day.setMaxPrice(Double.parseDouble(nextRecord[i++]));

                    day.setVIX(Double.parseDouble(nextRecord[i++]));

                    day.setFiveMarketAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTenMarketAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenMarketAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyMarketAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyFiveMarketAverageVolume(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyMarketAverageVolume(Double.parseDouble(nextRecord[i++]));

                    day.setFiveMarketMoneyVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTenMarketMoneyVolume(Double.parseDouble(nextRecord[i++]));
                    day.setFifteenMarketMoneyVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyMarketMoneyVolume(Double.parseDouble(nextRecord[i++]));
                    day.setTwentyMarketFiveMoneyVolume(Double.parseDouble(nextRecord[i++]));
                    day.setThirtyMarketMoneyVolume(Double.parseDouble(nextRecord[i++]));

                    day.setDayDifference(Double.parseDouble(nextRecord[i++]));
                    StockUtil.SIMPLE_DATE_FORMAT.format(day.getDate());
                    company.getTensorFlowDay().add(day);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new NoCompanyException("There are no data for this company symbol " + symbol);
            }
            return company;
        } else {
            throw new NoCompanyException("There are no data for this company symbol " + symbol);
        }
    }

    public static void save(Company company) throws IOException {
        if (isExist(company.getSymbol())) {
            remove(company.getSymbol());
        }
        try (
                CSVWriter writer = new CSVWriter(Files.newBufferedWriter(buildFileObject(company.getSymbol()).toPath()));
            ) {
            writer.writeNext(columns);
            company.getTensorFlowDay().forEach(day -> {
                String[] arr = {
                        Double.toString(day.getFiveEMA()),
                        Double.toString(day.getTenEMA()),
                        Double.toString(day.getFifteenEMA()),
                        Double.toString(day.getTwentyEMA()),
                        Double.toString(day.getTwentyFiveEMA()),
                        Double.toString(day.getThirtyEMA()),

                        Double.toString(day.getFiveSMA()),
                        Double.toString(day.getTenSMA()),
                        Double.toString(day.getFifteenSMA()),
                        Double.toString(day.getTwentySMA()),
                        Double.toString(day.getTwentyFiveSMA()),
                        Double.toString(day.getThirtySMA()),

                        Double.toString(day.getFiveRSI()),
                        Double.toString(day.getTenRSI()),
                        Double.toString(day.getFifteenRSI()),
                        Double.toString(day.getTwentyRSI()),
                        Double.toString(day.getTwentyFiveRSI()),
                        Double.toString(day.getThirtyRSI()),

                        Double.toString(day.getFiveAverageVolume()),
                        Double.toString(day.getTenAverageVolume()),
                        Double.toString(day.getFifteenAverageVolume()),
                        Double.toString(day.getTwentyAverageVolume()),
                        Double.toString(day.getTwentyFiveAverageVolume()),
                        Double.toString(day.getThirtyAverageVolume()),

                        Double.toString(day.getFiveVOL()),
                        Double.toString(day.getTenVOL()),
                        Double.toString(day.getFifteenVOL()),
                        Double.toString(day.getTwentyVOL()),
                        Double.toString(day.getTwentyFiveVOL()),
                        Double.toString(day.getThirtyVOL()),

                        Double.toString(day.getThrustFiveEMA()),
                        Double.toString(day.getThrustThirtyEMA()),

                        Double.toString(day.getMACDLine()),
                        Double.toString(day.getMACDSignal()),

                        Double.toString(day.getResistance()),
                        Double.toString(day.getSupport()),

                        Double.toString(day.getMinPrice()),
                        Double.toString(day.getMaxPrice()),

                        Double.toString(day.getVIX()),

                        Double.toString(day.getFiveMarketAverageVolume()),
                        Double.toString(day.getTenMarketAverageVolume()),
                        Double.toString(day.getFifteenMarketAverageVolume()),
                        Double.toString(day.getTwentyMarketAverageVolume()),
                        Double.toString(day.getTwentyFiveMarketAverageVolume()),
                        Double.toString(day.getThirtyMarketAverageVolume()),

                        Double.toString(day.getFiveMarketMoneyVolume()),
                        Double.toString(day.getTenMarketMoneyVolume()),
                        Double.toString(day.getFifteenMarketMoneyVolume()),
                        Double.toString(day.getTwentyMarketMoneyVolume()),
                        Double.toString(day.getTwentyMarketFiveMoneyVolume()),
                        Double.toString(day.getThirtyMarketMoneyVolume()),

                        Double.toString(day.getDayDifference()),
                        StockUtil.SIMPLE_DATE_FORMAT.format(day.getDate())
                };
                writer.writeNext(arr);
            });
            writer.flush();
        }
    }

    public static boolean isExist(String symbol) {
        return buildFileObject(symbol).exists();
    }

    private static File buildFileObject(String symbol) {
        return new File(emaFolder, symbol + ".csv");
    }

    public static void remove(String symbol) throws IOException {
        FileUtils.forceDelete(buildFileObject(symbol));
    }
}
