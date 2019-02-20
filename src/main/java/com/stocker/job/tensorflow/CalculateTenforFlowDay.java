package com.stocker.job.tensorflow;

import com.stocker.symbol.Company;
import com.stocker.symbol.Market;
import com.stocker.symbol.tensorflow.TensorFlowDay;
import org.springframework.stereotype.Component;


@Component
public class CalculateTenforFlowDay {
    public static void calculate(Company company, Market market) {
        company.getTensorFlowDay().clear();
        company.getDays().forEach(day -> {
            TensorFlowDay tensorFlowDay = new TensorFlowDay();

            tensorFlowDay.setFiveSMA(day.getFiveSMA() / day.getPrice());
            tensorFlowDay.setTenSMA(day.getTenSMA() / day.getPrice());
            tensorFlowDay.setFifteenSMA(day.getFifteenSMA() / day.getPrice());
            tensorFlowDay.setTwentySMA(day.getTwentySMA() / day.getPrice());
            tensorFlowDay.setTwentyFiveSMA(day.getTwentyFiveSMA() / day.getPrice());
            tensorFlowDay.setThirtySMA(day.getThirtySMA() / day.getPrice());

            tensorFlowDay.setFiveEMA(day.getFiveEMA() / day.getPrice());
            tensorFlowDay.setTenEMA(day.getTenEMA() / day.getPrice());
            tensorFlowDay.setFifteenEMA(day.getFifteenEMA() / day.getPrice());
            tensorFlowDay.setTwentyEMA(day.getTwentyEMA() / day.getPrice());
            tensorFlowDay.setTwentyFiveEMA(day.getTwentyFiveEMA() / day.getPrice());
            tensorFlowDay.setThirtyEMA(day.getThirtyEMA() / day.getPrice());

            tensorFlowDay.setFiveRSI(day.getFiveRSI());
            tensorFlowDay.setTenRSI(day.getTenRSI());
            tensorFlowDay.setFifteenRSI(day.getFifteenRSI());
            tensorFlowDay.setTwentyRSI(day.getTwentyRSI());
            tensorFlowDay.setTwentyFiveRSI(day.getTwentyFiveRSI());
            tensorFlowDay.setThirtyRSI(day.getThirtyRSI());

            tensorFlowDay.setFiveVOL(day.getFiveVOL());
            tensorFlowDay.setTenVOL(day.getTenVOL());
            tensorFlowDay.setFifteenVOL(day.getFifteenVOL());
            tensorFlowDay.setTwentyVOL(day.getTwentyVOL());
            tensorFlowDay.setTwentyFiveVOL(day.getTwentyFiveVOL());
            tensorFlowDay.setThirtyVOL(day.getThirtyVOL());

            tensorFlowDay.setFiveAverageVolume(day.getFiveAverageVolume() / day.getVolume());
            tensorFlowDay.setTenAverageVolume(day.getTenAverageVolume() / day.getVolume());
            tensorFlowDay.setFifteenAverageVolume(day.getFifteenAverageVolume() / day.getVolume());
            tensorFlowDay.setTwentyAverageVolume(day.getTwentyAverageVolume() / day.getVolume());
            tensorFlowDay.setTwentyFiveAverageVolume(day.getTwentyFiveAverageVolume() / day.getVolume());
            tensorFlowDay.setThirtyAverageVolume(day.getThirtyAverageVolume() / day.getVolume());

            tensorFlowDay.setThrustFiveEMA(day.getThrustFiveEMA());
            tensorFlowDay.setThrustThirtyEMA(day.getThrustThirtyEMA());

            tensorFlowDay.setMACDLine(day.getMACDLine());
            tensorFlowDay.setMACDSignal(day.getMACDSignal());

            tensorFlowDay.setResistance(day.getResistance() / day.getPrice());
            tensorFlowDay.setSupport(day.getSupport() / day.getPrice());

            tensorFlowDay.setMaxPrice(day.getMaxPrice() / day.getPrice());
            tensorFlowDay.setMinPrice(day.getMinPrice() / day.getPrice());

            tensorFlowDay.setDate(day.getDate());
            company.getTensorFlowDay().add(tensorFlowDay);
        });
    }
}
