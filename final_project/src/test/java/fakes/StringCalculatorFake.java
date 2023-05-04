package fakes;

import api.StringCalculator;

public class StringCalculatorFake implements StringCalculator {
    public StringCalculatorFake(){

    }
    @Override
    public String makeString() {
        return "сто сорок восемь тысяч пятьсот восемьдесят два";
    }
}
