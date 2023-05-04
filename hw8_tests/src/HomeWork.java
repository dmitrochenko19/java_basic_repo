import tests.DiceImplTest;
import tests.GameTest;
import tests.GameWinnerConsolePrinterTest;
import tests.PlayerTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */

    /**
     * Итог: программа не обрабатывает случай, если имя игрока это пустая строка или null
     * Значения кубика могут выходить за пределы от 1 до 6
     * Не рассмотрен случай ничьей
     */
    public static void main(String[] args) {
        PlayerTest playerTest = new PlayerTest();
        playerTest.playerCorrectNameTest();
        playerTest.playerIllegalArgumentExceptionTest();

        DiceImplTest diceImplTest = new DiceImplTest();
        diceImplTest.diceRollTest();

        GameTest gameTest = new GameTest();
        gameTest.gameTestFirstWin();
        gameTest.gameTestSecondWin();
        gameTest.gameTestNoWinner();

        GameWinnerConsolePrinterTest gameWinnerConsolePrinterTest  = new GameWinnerConsolePrinterTest();
        gameWinnerConsolePrinterTest.gameWinnerConsolePrinterTestFormat();
    }

}
