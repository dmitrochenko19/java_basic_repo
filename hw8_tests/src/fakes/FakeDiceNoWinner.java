package fakes;

import game.Dice;

public class FakeDiceNoWinner implements Dice {
    @Override
    public int roll() {
        return 2;
    }
}
