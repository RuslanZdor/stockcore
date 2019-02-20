package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

@Component
public class CalculateMACDLine implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach((Day day) -> day.setMACDLine(day.getTenEMA() / day.getTwentyFiveEMA()));
    }
}
