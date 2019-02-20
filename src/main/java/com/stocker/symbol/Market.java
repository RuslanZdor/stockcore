package com.stocker.symbol;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * contain information about market statistics
 */
@Entity
@Table(name="market", schema = "stocker")
public class Market extends Company {
    public Market() {
        setName("Market");
        setSymbol("Market");
    }
}
