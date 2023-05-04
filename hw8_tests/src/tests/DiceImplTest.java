package tests;

import game.Dice;
import game.DiceImpl;

public class DiceImplTest {
    public void diceRollTest(){
        Dice dice = new DiceImpl();
        for (int i = 0; i < 100; i++) {
            int result = dice.roll();
            if (result>6 || result<1) {
                System.err.println("diceRollTest FAILED " +
                        "Значение кубика вышло за пределы, указанные в условии задачи");
                break;
            }
            else System.out.println("diceRollTest PASSED");
        }
    }
}
