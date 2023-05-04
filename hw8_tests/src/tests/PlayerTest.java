package tests;

import game.Player;

public class PlayerTest {
    public void playerIllegalArgumentExceptionTest(){
        Throwable actual = null;
        try {
            Player player1 = new Player(" ");
            Player player2 = new Player(null);
        }
        catch (Exception e){
            actual = e;
        }

        if (actual==null)
            System.err.println("playerIllegalArgumentExceptionTest FAILED");
        else if (actual.getClass().equals(IllegalArgumentException.class)){
            System.out.println("playerIllegalArgumentExceptionTest PASSED");
        } else {
            System.err.println("playerIllegalArgumentExceptionTest FAILED");
        }

    }

    public void playerCorrectNameTest(){
        Player player = new Player("Bob");
        if (player.getName().equals("Bob")){
            System.out.println("playerCorrectNameTest PASSED");
        }
        else{
            System.err.println("playerCorrectNameTest FAILED");
        }
    }


}
