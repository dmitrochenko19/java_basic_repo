package entitiesTests;

import entities.AbstractPart;
import entities.UnitPart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AbstractPartTest {
    @ParameterizedTest
    @CsvSource({
            "115,сто пятнадцать",
            "1,один",
            "12,двенадцать",
            "80,восемьдесят",
            "999,девятьсот девяносто девять",
            "200,двести"
    })
    public void makeStringTest(int num, String result){
        AbstractPart part = new UnitPart(num);
        Assertions.assertEquals(result,part.converToString());
    }
    @Test
    public void makeStringTestNegativeNumbersAndZero(){
        AbstractPart part1 = new UnitPart(0);
        Assertions.assertEquals("",part1.converToString());

        AbstractPart part2 = new UnitPart(-5);
        Assertions.assertThrows(NumberFormatException.class,()->{part2.converToString();});
    }
    @ParameterizedTest
    @CsvSource({
            "10,true",
            "0,false",
            "15,true",
            "322,false",
            "115,true"
    })
    public void isTeenNumberTest(int num, boolean result){
        Assertions.assertEquals(result, new UnitPart(num).isTeenNumber());
    }
}
