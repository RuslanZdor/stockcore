package com.stocker.data.csv;

import com.opencsv.CSVReader;
import com.stocker.symbol.Company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymbolsReader {

    public static String csvFile = "C:\\ruslan_zdor\\stocker\\Technology.csv";

    public List<Company> readCompanies(String file) {
        List<Company> result = new ArrayList<>();
        try (
                CSVReader reader = new CSVReader(new FileReader(file));
            ) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                Company c = new Company();
                c.setSymbol(line[0].trim());
                c.setName(line[1].trim());
                c.setIndustry(line[2].trim());
                result.add(c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
