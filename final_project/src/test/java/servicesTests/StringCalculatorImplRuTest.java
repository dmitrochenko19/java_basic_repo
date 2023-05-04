package servicesTests;

import api.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import services.StringCalculatorImplRu;

public class StringCalculatorImplRuTest {
    @ParameterizedTest
    @CsvSource({
            "2147483647,два миллиарда сто сорок семь миллионов четыреста восемьдесят три тысячи шестьсот сорок семь",
            "38603854,тридцать восемь миллионов шестьсот три тысячи восемьсот пятьдесят четыре",
            "1859375,один миллион восемьсот пятьдесят девять тысяч триста семьдесят пять",
            "555555,пятьсот пятьдесят пять тысяч пятьсот пятьдесят пять",
            "85000,восемьдесят пять тысяч",
            "3147,три тысячи сто сорок семь",
            "155,сто пятьдесят пять",
            "11,одиннадцать",
            "2,два",
            "0,ноль"
    })
    public void makeStringTest(int num, String result){
        Assertions.assertEquals(result,new StringCalculatorImplRu(num).makeString().trim());
    }
    @Test
    public void makeStringNegativeNumberTest(){
        StringCalculator stringCalculatorImplRu = new StringCalculatorImplRu(-10);
        Assertions.assertThrows(NumberFormatException.class,()->{stringCalculatorImplRu.makeString();});
    }
}
