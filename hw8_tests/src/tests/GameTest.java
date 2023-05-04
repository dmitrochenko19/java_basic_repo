package tests;

import fakes.DiceFakeFirstWinnerImpl;
import fakes.DiceFakeSecondWinnerImpl;
import fakes.FakeDiceNoWinner;
import fakes.GameWinnerFakePrinter;
import game.Dice;
import game.Game;
import game.GameWinnerPrinter;
import game.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTest {
    public void gameTestFirstWin(){
        Player first = new Player("first");
        Player second = new Player("second");
        Dice dice = new DiceFakeFirstWinnerImpl();

        GameWinnerPrinter gameWinnerPrinter = new GameWinnerFakePrinter();

        Game game = new Game(dice, gameWinnerPrinter);

        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeStream = new PrintStream(outputStream);

        System.setOut(fakeStream);
        game.playGame(first,second);
        System.setOut(console);

        if (outputStream.toString().equals("first"))
            System.out.println("gameTestFirstWin PASSED");
        else System.err.println("gameTestFirstWin FAILED");
    }

    public void gameTestSecondWin(){
        Player first = new Player("first");
        Player second = new Player("second");
        Dice dice = new DiceFakeSecondWinnerImpl();

        GameWinnerPrinter gameWinnerPrinter = new GameWinnerFakePrinter();

        Game game = new Game(dice, gameWinnerPrinter);

        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeStream = new PrintStream(outputStream);

        System.setOut(fakeStream);
        game.playGame(first,second);
        System.setOut(console);

        if (outputStream.toString().equals("second"))
            System.out.println("gameTestSecondWin PASSED");
        else System.err.println("gameTestSecondWin FAILED");
    }
    public void gameTestNoWinner(){
        Player first = new Player("first");
        Player second = new Player("second");
        Dice dice = new FakeDiceNoWinner();

        GameWinnerPrinter gameWinnerPrinter = new GameWinnerFakePrinter();

        Game game = new Game(dice, gameWinnerPrinter);

        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeStream = new PrintStream(outputStream);

        System.setOut(fakeStream);
        game.playGame(first, second);
        System.setOut(console);

        if (outputStream.toString()==null)
            System.out.println("gameTestNoWinner PASSED");
        else System.err.println("gameTestNoWinner FAILED");


    }
}