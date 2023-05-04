package entities;

import api.Digit;
import enums.FirstDigit;
import enums.SecondDigit;
import enums.ThirdDigit;

public class DigitImpl implements Digit {
    private int value;
    private int position;
    public DigitImpl(int value, int position){
        this.value = value;
        this.position = position;
    }

    /**
     *Преобразует число в строковое представление
     * В СЛУЧАЕ 0 ВОЗВРАЩАЕТ ПУСТУЮ СТРОКУ
     */
    @Override
    public String convertToString() throws NumberFormatException{
        if(value<0)
           // return null;
            throw new NumberFormatException();

        if(position==1){
            FirstDigit[] numbers = FirstDigit.values();
            return numbers[value].getName();
        }
        if(position==2){
            SecondDigit[] numbers = SecondDigit.values();
            return numbers[value].getName();
        }
        if(position==3){
            ThirdDigit[] numbers = ThirdDigit.values();
            return numbers[value].getName();
        }
        return null;
    }
@Override
    public int getValue() {
        return value;
    }
}
