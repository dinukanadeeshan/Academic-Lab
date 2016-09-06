/**
 * Project - TicTacToe
 * Created by Dinuka Nadeeshan on 9/6/16.
 * dinuka.nadeeshan1993@gmail.com
 */
public class GameModel {

    private boolean[][] clickedBtns;    //Keep the clicked buttons in this boolean array with relative index

    private int[][] gameState;      // Keep what player clicked relevant button, if no one clicked there is garbage value

    private int chanceOfPlayer; // The player who have to play 0 and 1 are the values to O and X

    public GameModel(){
        clickedBtns = new boolean[3][3];
        gameState = new int[3][3];

        for (int i = 0, k = 3; i < 3; i++) {
            for (int j = 0; j < 3; j++, k++) {
                gameState[i][j] = k;    // Fill garbage values
            }
        }

    }

    public int[][] getGameState() {
        return gameState;
    }

    public void setGameState(int[][] gameState) {
        this.gameState = gameState;
    }

    public boolean[][] getClickedBtns() {
        return clickedBtns;
    }

    public void setClickedBtns(boolean[][] clickedBtns) {
        this.clickedBtns = clickedBtns;
    }

    public int getChanceOfPlayer() {
        return chanceOfPlayer;
    }

    public void setChanceOfPlayer(int chanceOfPlayer) {
        this.chanceOfPlayer = chanceOfPlayer;
    }
}
