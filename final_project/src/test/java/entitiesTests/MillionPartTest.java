package entitiesTests;

import entities.AbstractPart;
import entities.MillionPart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MillionPartTest {
    @ParameterizedTest
    @CsvSource({
            "2,два миллиона",
            "15,пятнадцать миллионов",
            "11,одиннадцать миллионов",
            "101,сто один миллион" ,
            "888,восемьсот восемьдесят восемь миллионов",
            "0,миллионов",
            "122,сто двадцать два миллиона",
            "8,восемь миллионов"
    })
    public void convertToStringTest(int num, String result){
        Assertions.assertEquals(result, new MillionPart(num).converToString().trim());
    }

    @Test
    public void convertToStringNegativeNumberTest(){
        AbstractPart part = new MillionPart(-55);
        Assertions.assertThrows(NumberFormatException.class,()->{part.converToString();});
    }
}
