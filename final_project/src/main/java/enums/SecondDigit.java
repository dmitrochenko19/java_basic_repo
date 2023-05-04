package enums;

public enum SecondDigit {
    ZERO(""),
    ONE(""),
    TWO("двадцать"),
    THREE("тридцать"),
    FOUR("сорок"),
    FIVE("пятьдесят"),
    SIX("шестьдесят"),
    SEVEN("семьдесят"),
    EIGHT("восемьдесят"),
    NINE("девяносто");
    private String name;
    SecondDigit(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
