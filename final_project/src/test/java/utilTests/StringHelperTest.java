package utilTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.StringHelper;

public class StringHelperTest {
    @ParameterizedTest
    @CsvSource({
            "коткоткот,кот,КОТ,коткотКОТ",
            "заяц,яц,ЯЦ,заЯЦ",
            "мышь,ка,КА,мышь",
    })
    public void replaceLast(String origin, String old, String newPart, String result) {
        Assertions.assertEquals(result,StringHelper.replaceLast(origin,old,newPart));
    }
}
