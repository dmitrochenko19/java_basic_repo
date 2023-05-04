package fakes;

import api.CurrencyCalculator;

public class CurrencyCalculatorFake implements CurrencyCalculator {
    public CurrencyCalculatorFake() {
    }

    @Override
    public String chooseCurrency() {
        return "рубля";
    }
}
