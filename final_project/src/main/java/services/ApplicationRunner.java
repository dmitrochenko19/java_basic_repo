package services;

import api.CurrencyAndStringCalculator;
import api.CurrencyCalculator;
import api.IOService;
import api.StringCalculator;

public class ApplicationRunner {
    private final IOService ioService;
    public ApplicationRunner(IOService ioService){
        this.ioService = ioService;
    }
    public void run() {
        while (true) {
            String commandOrNumber = ioService.readString("Введите число или команду exit: ");
            if (commandOrNumber.equalsIgnoreCase("exit"))
                return;
            int a = 0;
            try {
                a = Integer.parseInt(commandOrNumber);
                StringCalculator stringCalculator = new StringCalculatorImplRu(a);
                CurrencyCalculator currencyCalculator = new CurrencyCalculatorImplRu(a);
                CurrencyAndStringCalculator currencyAndStringCalculator = new CurrencyAndStringCalculatorImpl(currencyCalculator,stringCalculator);
                String result = currencyAndStringCalculator.joinStringAndCurrency();
                ioService.outputStr(result);
            } catch (NumberFormatException e) {
                ioService.outputStr("Данное число не поддерживается. Попробуйте ещё раз");
            }

        }
    }
}
