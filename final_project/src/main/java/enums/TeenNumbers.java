package enums;

public enum TeenNumbers {
    TEN("десять"),
    ELEVEN("одиннадцать"),
    TWELVE("двенадцать"),
    THIRTEEN("тринадцать"),
    FOURTEEN("четырнадцать"),
    FIFTEEN("пятнадцать"),
    SIXTEEN("шестнадцать"),
    SEVENTEEN("семнадцать"),
    EIGHTEEN("восемнадцать"),
    NINETEEN("девятнадцать");
    private String name;
    TeenNumbers(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
