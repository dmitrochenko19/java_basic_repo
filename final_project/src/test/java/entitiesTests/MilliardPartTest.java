package entitiesTests;

import entities.AbstractPart;
import entities.MilliardPart;
import entities.MillionPart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MilliardPartTest {
    @ParameterizedTest
    @CsvSource({
            "7,семь миллиардов",
            "0,миллиардов",
            "11,одиннадцать миллиардов",
            "486,четыреста восемьдесят шесть миллиардов" ,
            "301,триста один миллиард",
            "33,тридцать три миллиарда",
            "28,двадцать восемь миллиардов",
            "975,девятьсот семьдесят пять миллиардов"
    })
    public void convertToStringTest(int num, String result){
        Assertions.assertEquals(result, new MilliardPart(num).converToString().trim());
    }
    @Test
    public void convertToStringNegativeNumberTest(){
        AbstractPart part = new MilliardPart(-11);
        Assertions.assertThrows(NumberFormatException.class,()->{part.converToString();});
    }
}
