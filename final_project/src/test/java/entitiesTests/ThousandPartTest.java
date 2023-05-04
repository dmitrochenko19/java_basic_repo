package entitiesTests;

import entities.AbstractPart;
import entities.ThousandPart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ThousandPartTest {
    @ParameterizedTest
    @CsvSource({
          "115,сто пятнадцать тысяч",
          "1,одна тысяча",
          "102,сто две тысячи",
          "25,двадцать пять тысяч" ,
            "999,девятьсот девяносто девять тысяч",
            "843,восемьсот сорок три тысячи",
            "122,сто двадцать две тысячи",
            "101,сто одна тысяча",
            "0,тысяч"
    })
    public void convertToStringTest(int num, String result){
        Assertions.assertEquals(result, new ThousandPart(num).converToString().trim());
    }
    @Test
    public void convertToStringNegativeNumberTest(){
        AbstractPart part = new ThousandPart(-100);
        Assertions.assertThrows(NumberFormatException.class,()->{part.converToString();});
    }

}
