package entitiesTests;

import entities.DigitImpl;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//import static org.junit.Assert.assertEquals;

public class DigitTest {
    @ParameterizedTest
    @CsvSource({
            "5, 1, пять",
            "8, 2, восемьдесят",
            "3, 3, триста",
            "1,3,сто",
            "9,2,девяносто"
    })
    public void convertToStringTest(int num, int position, String result){
        Assertions.assertEquals(result,new DigitImpl(num,position).convertToString());

    }
    @Test
    public void convertToStringTestNegativeNumbersAndZero(){
        DigitImpl digit1 = new DigitImpl(0,1);
        Assertions.assertEquals("",digit1.convertToString());

        DigitImpl digit2 = new DigitImpl(5,5);
        Assertions.assertNull(digit2.convertToString());

        DigitImpl digit3 = new DigitImpl(-5,1);
        Assertions.assertThrows(NumberFormatException.class, ()->{digit3.convertToString();});
    }

}

