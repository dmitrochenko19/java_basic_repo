package tests;

import game.GameWinnerConsolePrinter;
import game.GameWinnerPrinter;
import game.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameWinnerConsolePrinterTest {
    public void gameWinnerConsolePrinterTestFormat(){
        String expected = String.format("Победитель: %s%n","winner");
        GameWinnerPrinter gameWinnerPrinter = new GameWinnerConsolePrinter();
        Player winner = new Player("winner");

        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeStream = new PrintStream(outputStream);

        System.setOut(fakeStream);
        gameWinnerPrinter.printWinner(winner);
        System.setOut(console);

        if (outputStream.toString().equals(expected))
            System.out.println("gameWinnerConsolePrinterTestForm PASSED");
        else System.err.println("gameWinnerConsolePrinterTestForm FAILED");
    }
}
