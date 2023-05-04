package services;

import api.CurrencyAndStringCalculator;
import api.CurrencyCalculator;
import api.StringCalculator;

public class CurrencyAndStringCalculatorImpl implements CurrencyAndStringCalculator {
    CurrencyCalculator currencyCalculator;
    StringCalculator stringCalculator;
    public CurrencyAndStringCalculatorImpl(CurrencyCalculator currencyCalculator, StringCalculator stringCalculator){
        this.currencyCalculator = currencyCalculator;
        this.stringCalculator = stringCalculator;
    }
    @Override
    public String joinStringAndCurrency(){
        String numberString = stringCalculator.makeString();
        String currency = currencyCalculator.chooseCurrency();
        if(numberString.endsWith(" "))
            return numberString+currency;
        return numberString+" "+currency;
    }
}
