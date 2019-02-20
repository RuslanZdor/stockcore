package com.stocker.job.company;

import com.stocker.exception.NoDayException;
import com.stocker.symbol.Company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DownloadHistoricalDataTest {

    private DownloadHistoricalData downloadHistoricalData;

    @Before
    public void prepare() {
        downloadHistoricalData = new DownloadHistoricalData();
    }

    @Test
    public void download() throws NoDayException {
        Company company = new Company();
        company.setSymbol("AAPL");
        downloadHistoricalData.download(company);
        assertFalse(company.getDays().isEmpty());
        assertEquals("AAPL", company.getSymbol());
    }

    @Test (expected = NoDayException.class)
    public void downloadWrongSymbol() throws NoDayException {
        Company company = new Company();
        company.setSymbol("WRONGSYMBOL");
        downloadHistoricalData.download(company);
    }
}