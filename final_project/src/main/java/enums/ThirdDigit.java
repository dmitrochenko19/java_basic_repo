package enums;

public enum ThirdDigit {
    ZERO(""),
    ONE("сто"),
    TWO("двести"),
    THREE("триста"),
    FOUR("четыреста"),
    FIVE("пятьсот"),
    SIX("шестьсот"),
    SEVEN("семьсот"),
    EIGHT("восемьсот"),
    NINE("девятьсот");
    private String name;
    ThirdDigit(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
