package battleship;

import java.util.Random;

/**
 *
 * @author ak
 */
public class TestBattleship {

    private boolean endFlag;
    private int maxRounds;
    private int turn;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TestBattleship test = new TestBattleship();
        Game game = new Game();
        Random generator = new Random(System.currentTimeMillis());
        test.endFlag = game.init();

//        System.exit(0);

        if (test.endFlag == false) {
            game.placeShips();
        }

        if (test.endFlag == false) {
            if (test.maxRounds == 0) {

                test.turn = generator.nextInt(2);
                if (test.turn == 0) {
                    System.out.println(game.getPlayer1().getName() + " plays first.");
                    while (test.endFlag == false) {
                        test.endFlag = game.play(test.turn);
                    }
                } else {
                    System.out.println(game.getPlayer2().getName() + " plays first.");
                    while (test.endFlag == false) {
                        test.endFlag = game.play(test.turn);
                    }
                }
            } else {

                test.turn = generator.nextInt(2);
                if (test.turn == 0) {
                    System.out.println(game.getPlayer1().getName() + " plays first.");
                    for (int i = 0; i < test.maxRounds || test.endFlag == false; i++) {
                        test.endFlag = game.play(test.turn);
                    }
                } else {
                    System.out.println(game.getPlayer2().getName() + " plays first.");
                    for (int i = 0; i < test.maxRounds || test.endFlag == false; i++) {
                        test.endFlag = game.play(test.turn);
                    }
                }

            }
        }


    }
}
