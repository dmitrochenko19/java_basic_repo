package entities;

import util.StringHelper;

public class ThousandPart extends AbstractPart{
    private static final String suffix1 = " тысяча " ;
    private static final String suffix2 = " тысячи " ;
    private static final String suffix3 = " тысяч " ;
    public ThousandPart(int number){
        super(number);
    }

    /**
     * Вернёт строковое представление числа, добавив к нему слово
     * тысяча\тысячи\тысяч
     */
    @Override
    public String converToString() {
        String result = super.converToString();
        if(result.endsWith("два")){
            result = StringHelper.replaceLast(result,"два", "две");
        }
        if(result.endsWith("один")){
            result = StringHelper.replaceLast(result,"один","одна");
        }
        if(this.isTeenNumber())
            return result+=suffix3;
        switch (this.getDigit1().getValue()){
            case 1:
                result+=suffix1;
                break;
            case 2:
            case 3:
            case 4:
                result+=suffix2;
                break;
            default:
                result+=suffix3;
        }
        return result;
    }
}
