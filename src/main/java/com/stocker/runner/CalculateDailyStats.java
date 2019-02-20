package com.stocker.runner;

import com.stocker.exception.NoCompanyException;
import com.stocker.job.company.*;
import com.stocker.symbol.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateDailyStats {

    @Autowired
    private CalculateSMA calculateSMA;

    @Autowired
    private CalculateRSI calculateRSI;

    @Autowired
    private CalculateEMA calculateEMA;

    @Autowired
    private CalculateAverageVolume calculateAverageVolume;

    @Autowired
    private CalculateVOL calculateVOL;

    @Autowired
    private CalculateThrust calculateThrust;

    @Autowired
    private CalculateThrustEMA calculateThrustEMA;

    @Autowired
    private CalculateMACDLine calculateMACDLine;

    @Autowired
    private CalculateMACDSignal calculateMACDSignal;

    public void calculate(Company company) throws NoCompanyException {
        calculateSMA.calculate(company);
        calculateEMA.calculate(company);
        calculateRSI.calculate(company);
        calculateAverageVolume.calculate(company);
        calculateVOL.calculate(company);
        calculateThrust.calculate(company);
        calculateThrustEMA.calculate(company);
        calculateMACDLine.calculate(company);
        calculateMACDSignal.calculate(company);
    }
}