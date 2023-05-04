package entities;

public class MilliardPart extends AbstractPart{
    private static final String suffix1 = " миллиард " ;
    private static final String suffix2 = " миллиарда " ;
    private static final String suffix3 = " миллиардов " ;
    public MilliardPart(int number){
        super(number);
    }
    /**
     * Вернёт строковое представление числа, добавив к нему слово
     * миллиард\миллиарда\миллиардов
     */
    @Override
    public String converToString() {
        String result = super.converToString();
        if(this.isTeenNumber())
            return result+suffix3;
        switch (this.getDigit1().getValue()){
            case 1:
                result=result+suffix1;
                break;
            case 2:
            case 3:
            case 4:
                result=result+suffix2;
                break;
            default:
                result=result+suffix3;
        }
        return result;
    }
}
