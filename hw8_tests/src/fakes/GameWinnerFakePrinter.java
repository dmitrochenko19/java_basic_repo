package fakes;

import game.GameWinnerPrinter;
import game.Player;


    public class GameWinnerFakePrinter implements GameWinnerPrinter {
        @Override
        public void printWinner(Player winner) {
            System.out.printf(winner.getName());
        }
    }

