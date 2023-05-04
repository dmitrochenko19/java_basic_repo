package services;

import api.StringCalculator;
import entities.MilliardPart;
import entities.MillionPart;
import entities.ThousandPart;
import entities.UnitPart;

public class StringCalculatorImplRu implements StringCalculator {
    private static final String ZERO = "ноль";
    private int number;
    private UnitPart unitPart;
    private ThousandPart thousandPart;
    private MillionPart millionPart;
    private MilliardPart milliardPart;

    public StringCalculatorImplRu(int a) {
        this.number = a;
        this.unitPart = new UnitPart(a % 1000);
        if ((a / 1000) % 1000 > 0)
            this.thousandPart = new ThousandPart((a / 1000) % 1000);
        if ((a / 1000000) % 1000 > 0)
            this.millionPart = new MillionPart((a / 1000000) % 1000);
        if ((a / 1000000000) % 1000 > 0)
            this.milliardPart = new MilliardPart((a / 1000000000) % 1000);
    }

    @Override
    public String makeString() throws NumberFormatException{
        if(unitPart.isZero() && thousandPart==null && millionPart==null && milliardPart==null)
            return ZERO;
        String result = "";
        if (milliardPart != null) {
            result += milliardPart.converToString();
        }
        if (millionPart != null) {
            result += millionPart.converToString();
        }
        if (thousandPart != null) {
            result += thousandPart.converToString();
        }
        if (unitPart != null) {
            result += unitPart.converToString();
        }
        return result;

    }

}
