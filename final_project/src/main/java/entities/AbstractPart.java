package entities;

import api.Digit;
import enums.TeenNumbers;

public abstract class AbstractPart {
    private int number;
    private Digit digit1;
    private Digit digit2;
    private Digit digit3;

    public AbstractPart(int number) {
        this.number = number;
        this.digit1 = new DigitImpl(number % 10, 1);
        this.digit2 = new DigitImpl((number % 100) / 10, 2);
        this.digit3 = new DigitImpl(number / 100, 3);
    }

    /**
     *Преобразует число в строку
     */
    public String converToString() throws NumberFormatException {
        String result = "";
        int count = 1;
        if (this.isTeenNumber()) {
            result = digit3.convertToString();
            if (!result.endsWith(" ") && !result.equals(""))
                result += " ";
            result += makeTeenNumber(digit2.getValue() * 10 + digit1.getValue());
            return result;
        }
        result += digit3.convertToString();
        if ((!digit3.convertToString().equals("") && !digit2.convertToString().equals("")) ||
                (!digit3.convertToString().equals("") && digit2.convertToString().equals("") && !digit1.convertToString().equals("")))
            result += " ";
        result += digit2.convertToString();
        if (!digit2.convertToString().equals("") && !digit1.convertToString().equals(""))
            result += " ";
        result += digit1.convertToString();
        return result;

    }

    /**
     *проверяет случай 11, 12 ... 19
     */
    public boolean isTeenNumber() {
        if (digit2.getValue() == 1)
            return true;
        return false;
    }
    /**
     *обрабатывает случай 11, 12 ... 19
     */
    private String makeTeenNumber(int number) {
        TeenNumbers[] numbers = TeenNumbers.values();
        return numbers[number % 10].getName();

    }

    public Digit getDigit1() {
        return digit1;
    }

    public boolean isZero() {
        if (number == 0)
            return true;
        return false;
    }
}
