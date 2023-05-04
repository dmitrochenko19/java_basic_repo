package servicesTests;

import api.IOService;
import fakes.IOServiceFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.ApplicationRunner;
import services.IOServiceConsoleImpl;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class ApplicationRunnerTest {
    @Test
    public void runTestWithNumber() throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(baos);

        String source = "155\nexit";
        Scanner inputStream = new Scanner(new ByteArrayInputStream(source.getBytes()));
        IOService ioService = new IOServiceFake(outputStream,inputStream);
        ApplicationRunner runner = new ApplicationRunner(ioService);
        runner.run();

        String result = "Введите число или команду exit: " +System.lineSeparator()+
                "сто пятьдесят пять рублей"+System.lineSeparator()+"Введите число или команду exit: "+System.lineSeparator();
        Assertions.assertEquals(result,baos.toString());
    }
    @Test
    public void runTestWithBadNumber() throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(baos);

        String source = "15a5\nexit";
        Scanner inputStream = new Scanner(new ByteArrayInputStream(source.getBytes()));
        IOService ioService = new IOServiceFake(outputStream,inputStream);
        ApplicationRunner runner = new ApplicationRunner(ioService);
        runner.run();

        String result = "Введите число или команду exit: " +System.lineSeparator()+
                "Данное число не поддерживается. Попробуйте ещё раз"+System.lineSeparator()+"Введите число или команду exit: "+System.lineSeparator();
        Assertions.assertEquals(result,baos.toString());
    }
}
