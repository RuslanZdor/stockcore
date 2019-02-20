package com.stocker.job.market;

import com.stocker.job.company.CalculateAverageVolume;
import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import com.stocker.symbol.Market;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateMoneyVolume {
    public static Market calculate(Market market, List<Company> companies) {
        for (Day marketDay : market.getDays()) {
            marketDay.setMoneyVolume(0);
        }

        for (Company company : companies) {
            for (Day day : company.getDays()) {
                Day marketDay = market.getDay(day);
                marketDay.setMoneyVolume(marketDay.getMoneyVolume()
                        + day.getVolume() * day.getPrice());
            }
        }

        CalculateAverageVolume averageVolume = new CalculateAverageVolume();
        averageVolume.calculate(market);
        return market;
    }
}
