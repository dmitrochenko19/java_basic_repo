package services;

import api.CurrencyCalculator;
import entities.UnitPart;

public class CurrencyCalculatorImplRu implements CurrencyCalculator {
    private static final String suffix1 = "рубль";
    private static final String suffix2 = "рубля";
    private static final String suffix3 = "рублей";
    private UnitPart number;
    private int value;
    public CurrencyCalculatorImplRu(int number){
        this.value = number;
        this.number = new UnitPart(number);
    }

    @Override
    public String chooseCurrency() throws NumberFormatException{
        if(value<0)
            throw new NumberFormatException();
        if(this.number.isTeenNumber())
            return suffix3;
        switch (number.getDigit1().getValue()%10){
            case 1:
                return suffix1;
            case 2:
            case 3:
            case 4:
                return suffix2;
            default:
                return suffix3;
        }
    }
}
