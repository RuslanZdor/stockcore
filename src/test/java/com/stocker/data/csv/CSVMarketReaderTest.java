package com.stocker.data.csv;

import com.stocker.symbol.Market;
import org.junit.*;

import java.io.IOException;

/**
 *
 */
public class CSVMarketReaderTest {

    private CSVMarketReader csvMarketReader;

    @Before
    public void init() {
        csvMarketReader = new CSVMarketReader();
    }

    @After
    public void cleanFile() throws IOException {
        if (csvMarketReader.isExist()) {
            csvMarketReader.remove();
        }
    }

    @Test
    public void testIsMarketExist() throws IOException {
        if (csvMarketReader.isExist()) {
            csvMarketReader.remove();
        }
        Assert.assertFalse(csvMarketReader.isExist());

        Market market = new Market();
        csvMarketReader.save(market);
        Assert.assertTrue(csvMarketReader.isExist());
        csvMarketReader.remove();
    }
}