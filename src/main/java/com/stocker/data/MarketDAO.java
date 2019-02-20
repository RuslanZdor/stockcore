package com.stocker.data;

import com.stocker.exception.NoMarketException;
import com.stocker.symbol.Market;
import java.io.IOException;

public interface MarketDAO {
    Market read() throws NoMarketException;
    void save(Market market) throws IOException;
    boolean isExist();
    void remove() throws IOException;
}