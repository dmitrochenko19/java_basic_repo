package enums;

public enum FirstDigit {
    ZERO(""),
    ONE("один"),
    TWO("два"),
    THREE("три"),
    FOUR("четыре"),
    FIVE("пять"),
    SIX("шесть"),
    SEVEN("семь"),
    EIGHT("восемь"),
    NINE("девять");
    private String name;

    FirstDigit(String name){
        this.name = name;

    }
    public String getName(){
        return this.name;
    }
}
