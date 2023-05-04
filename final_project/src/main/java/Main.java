import api.CurrencyAndStringCalculator;
import api.CurrencyCalculator;
import api.IOService;
import services.*;

/**
 * Структура программы
 * В пакете entities хранятся классы, реализующие основную логику программы
 * (то есть классы, отвечающие за преобразование числа в строку и валюту).
 * Каждое число можно разделить на тройки цифр
 * 456789101 => 456 789 101
 * Классы UnitPart, ThousandPart, MillionPart, MilliardPart являются
 * наследниками класса AbstractPart и обрабатывают свою тройку числа
 * UnitPart => 101
 * ThousandPart => 789
 * MillionPart => 456
 * MilliardPart => null (в данном случае)
 * В поле value класса AbstractPart хранится полное значение тройки (неразбитое на цифры)
 *
 * Класс DigitImpl отвечает за конкретную цифру любой тройки
 * поле value это значение цифры
 * поле position позиция цифры внутри тройки, считая с конца
 * 456 {
 * Digit: value 4, position 1
 * Digit: value 5, position 2
 * Digit: value 6, position 3 }
 *
 * Каждое полученное на вход число сперва разбивается на части(UnitPart, ThousandPart, MillionPart => 456, MilliardPart),
 * а потом на DigitImpl. Далее оно обрабатывается методами этих классов. Описание методов смотреть внутри классов.
 *
 *
 * Классы хранящиеся в пакете services обслуживают и собирают нашу программу
 * Класс StringCalculatorImplRu получает число, введёное пользователем,
 * разбивает его на части(в конструкторе), переводит все части в их строковое представление
 * и склеивает их вместе(метод makeString())
 *
 * Класс CurrencyCalculatorImplRu анализирует введёное пользователем число
 * и подбирает для него нужный падеж слова "рубль"
 *
 * Класс CurrencyAndStringCalculatorImpl склеивает число и "рубль"
 *
 * Класс IOService реализует ввод и вывод через консоль
 *
 * Класс ApplicationRunner собирает программу, в нём можно подменить
 * реализации интерфейсов CurrencyCalculator и StringCalculator
 * При необходимости сменить валюту(например, на доллары) пишем ещё одну реализацию
 * CurrencyCalculator (например, CurrencyCalculatorImplDollar) и в методе run()
 * класса ApplicationRunner делаем подмену 
 *
 */

public class Main {
    public static void main(String[] args) {
        IOService ioService = new IOServiceConsoleImpl();
        ApplicationRunner runner = new ApplicationRunner(ioService);
        runner.run();
    }
}