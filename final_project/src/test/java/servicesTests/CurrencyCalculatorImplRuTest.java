package servicesTests;

import api.CurrencyCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import services.CurrencyCalculatorImplRu;
import services.StringCalculatorImplRu;

public class CurrencyCalculatorImplRuTest {
    @ParameterizedTest
    @CsvSource({
            "2147483647,рублей",
            "38603854,рубля",
            "1859375,рублей",
            "555553,рубля",
            "85000,рублей",
            "3142,рубля",
            "151,рубль",
            "11,рублей",
            "18,рублей",
            "0,рублей"
    })
    public void chooseCurrencyTest(int num, String result){
        Assertions.assertEquals(result,new CurrencyCalculatorImplRu(num).chooseCurrency().trim());
    }
    @Test
    public void chooseCurrencyNegativeNumberTest(){
        CurrencyCalculator currencyCalculator = new CurrencyCalculatorImplRu(-12);
        Assertions.assertThrows(NumberFormatException.class,()->{currencyCalculator.chooseCurrency();});
    }
}
