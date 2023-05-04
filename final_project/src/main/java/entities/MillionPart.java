package entities;

public class MillionPart extends AbstractPart{
    private static final String suffix1 = " миллион " ;
    private static final String suffix2 = " миллиона " ;
    private static final String suffix3 = " миллионов " ;
    public MillionPart(int number){
        super(number);
    }
    /**
     * Вернёт строковое представление числа, добавив к нему слово
     * миллион\миллиона\миллионов
     */
    @Override
    public String converToString() {
        String result = super.converToString();
        if(this.isTeenNumber())
            return result+suffix3;
        switch (this.getDigit1().getValue()){
            case 1:
                result = result+suffix1;
                break;
            case 2:
            case 3:
            case 4:
                result = result+suffix2;
                break;
            default:
                result = result+suffix3;
        }
        return result;
    }
}
