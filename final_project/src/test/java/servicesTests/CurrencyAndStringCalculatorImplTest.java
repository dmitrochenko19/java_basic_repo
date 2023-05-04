package servicesTests;

import api.CurrencyAndStringCalculator;
import api.CurrencyCalculator;
import api.StringCalculator;
import fakes.CurrencyCalculatorFake;
import fakes.StringCalculatorFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import services.CurrencyAndStringCalculatorImpl;
import services.StringCalculatorImplRu;


public class CurrencyAndStringCalculatorImplTest {
    @Test
    public void joinStringAndCurrencyTest() {
        StringCalculator stringCalculator = new StringCalculatorFake();
        CurrencyCalculator currencyCalculator = new CurrencyCalculatorFake();
        CurrencyAndStringCalculator currencyAndStringCalculator = new CurrencyAndStringCalculatorImpl(currencyCalculator, stringCalculator);
        Assertions.assertEquals("сто сорок восемь тысяч пятьсот восемьдесят два рубля",currencyAndStringCalculator.joinStringAndCurrency().trim());
    }
}
