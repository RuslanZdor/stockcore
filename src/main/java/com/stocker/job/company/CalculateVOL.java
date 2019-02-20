package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateVOL implements ICalculateJob {
    public void calculate(Company company) {
//        for (int i = 0; i < company.getDays().size(); i++) {
//            Day day = company.getDays().get(i);
//            day.setFiveVOL(calculateVOL(company.getDays(), i, 5, company.getDays().get(i).getFiveSMA()));
//            day.setTenVOL(calculateVOL(company.getDays(), i, 10, company.getDays().get(i).getTenSMA()));
//            day.setFifteenVOL(calculateVOL(company.getDays(), i, 15, company.getDays().get(i).getFifteenSMA()));
//            day.setTwentyVOL(calculateVOL(company.getDays(), i, 20, company.getDays().get(i).getTwentySMA()));
//            day.setTwentyFiveVOL(calculateVOL(company.getDays(), i, 25, company.getDays().get(i).getTwentyFiveSMA()));
//            day.setThirtyVOL(calculateVOL(company.getDays(), i, 30, company.getDays().get(i).getThirtySMA()));
//        }
    }

    private double calculateVOL(List<Day> days, int index, int length, double average) {
        double results = 0;
        int i;
        for (i = 0; i < length; i++) {
            if (i + index >= days.size()) {
                if  (i == 0) {
                    return 0;
                }
                break;
            }
            results += Math.pow(days.get(i + index).getPrice() - average, 2);
        }
        return results / length;
    }
}
