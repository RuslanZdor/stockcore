package com.stocker.job.market;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateMVSMA {
    public static void calculate(Company company) {
//        for (int i = 0; i < company.getDays().size(); i++) {
//            Day day = company.getDays().get(i);
//            day.setFiveMVSMA(calculate(company.getDays(), i, 5));
//            day.setTenMVSMA(calculate(company.getDays(), i, 10));
//            day.setFifteenMVSMA(calculate(company.getDays(), i, 15));
//            day.setTwentyMVSMA(calculate(company.getDays(), i, 20));
//            day.setTwentyFiveMVSMA(calculate(company.getDays(), i, 25));
//            day.setThirtyMVSMA(calculate(company.getDays(), i, 30));
//        }
    }

    private static double calculate(List<Day> days, int index, int length) {
        double results = 0;
        int i = 0;
        for (i = 0; i < length; i++) {
            if (i + index>= days.size()) {
                if  (i == 0) {
                    return days.get(index).getMoneyVolume();
                }
                break;
            }
            results += days.get(index + i).getMoneyVolume();
        }
        return results / i;
    }
}
