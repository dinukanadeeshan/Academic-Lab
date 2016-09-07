/**
 * C0225 - Software Constructions - Lab 08 - Tic Tac Toe Game
 *
 * @author K. A. Dinuka Nadeeshan (E/13/234)
 *
 * @email dinuka.nadeeshan1993@gmail.com
 *
 * @team Unicorn (TM)
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    private GameModel gameModel;
    private Random ran;


    public GameController(GameModel gameModel) {
        this.gameModel = gameModel;

        ran = new Random();
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public boolean hasClickThisButton(int i, int j){
        return gameModel.getClickedBtns()[i][j];
    }
    public void changePlayer(){
        gameModel.setChanceOfPlayer(gameModel.getChanceOfPlayer() == 0 ? 1 : 0);
    }

    public String getPlayersMark(){
        return gameModel.getChanceOfPlayer() == 0 ? "O" : "X";
    }

    public void clickedThisButton(int i, int j){
        gameModel.getClickedBtns()[i][j] = true;
        gameModel.getGameState()[i][j] = gameModel.getChanceOfPlayer();

    }

    private boolean isAllButtonsClicked(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!gameModel.getClickedBtns()[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * This method check for winner or draw or give chance to other player
     *
     * @return 10 if match is draw or -1 if have to give chance to other player otherwise return winners number 0 or 1
     */
    public int checkForWinner(){
        int[][] gameState = gameModel.getGameState();

        //System.out.println("Called");

        // Check for winner
        if(gameState[0][0]==gameState[0][1]&&gameState[0][1]==gameState[0][2]){
            return gameState[0][0];
        } else if( gameState[1][0]==gameState[1][1]&&gameState[1][1]==gameState[1][2]){
            return gameState[1][0];
        }else if(gameState[2][0]==gameState[2][1]&&gameState[2][1]==gameState[2][2]){
            return gameState[2][0];
        }else if( gameState[0][0]==gameState[1][0]&&gameState[1][0]==gameState[2][0]){
            return gameState[0][0];
        }else if( gameState[0][1]==gameState[1][1]&&gameState[1][1]==gameState[2][1]){
            return gameState[0][1];
        }else if(gameState[0][2]==gameState[1][2]&&gameState[1][2]==gameState[2][2]){
            return gameState[0][2];
        }else if(gameState[0][0]==gameState[1][1]&&gameState[1][1]==gameState[2][2]){
            return gameState[0][0];
        }else if(gameState[0][2]==gameState[1][1]&&gameState[1][1]==gameState[2][0]){
            return gameState[0][2];
        }

        if(isAllButtonsClicked()){
            return 10;
        }


        return -1;
    }

    private List<int []> getFreeButtons(){
        List<int []> freeBtnList = new ArrayList<int[]>();

        boolean[][] clickedBtns = gameModel.getClickedBtns();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!clickedBtns[i][j]){
                    freeBtnList.add(new int[]{i,j});
                }
            }
        }


        return freeBtnList;
    }


    private boolean isFreeButton(int i, int j){
        return !gameModel.getClickedBtns()[i][j];
    }

    private int[] isRowFree(int row, int player){
        int[][] gameState = gameModel.getGameState();
        if (gameState[row][0] == player && gameState[row][1] == player && isFreeButton(row,2)) return new int[]{row,2};

        if (gameState[row][0] == player && gameState[row][2] == player && isFreeButton(row,1)) return new int[]{row,1};
        if (gameState[row][2] == player && gameState[row][1] == player && isFreeButton(row,0)) return new int[]{row,0};

        return null;
    }

    private int[] isColumnFree(int column,int player){
        int[][] gameState = gameModel.getGameState();
        if (gameState[0][column] == player && gameState[1][column] == player && isFreeButton(2,column)) return new int[]{2,column};

        if (gameState[0][column] == player && gameState[2][column] == player && isFreeButton(1,column)) return new int[]{1,column};
        if (gameState[2][column] == player && gameState[1][column] == player && isFreeButton(0,column)) return new int[]{0,column};

        return null;
    }

    private int[] isDiagonalFree(int player){

        int[][] gameState = gameModel.getGameState();
        if (gameState[0][0] == player && gameState[1][1] == player && isFreeButton(2,2)) return new int[]{2,2};

        if (gameState[0][0] == player && gameState[2][2] == player && isFreeButton(1,1)) return new int[]{1,1};
        if (gameState[2][2] == player && gameState[1][1] == player && isFreeButton(0,0)) return new int[]{0,0};

        if (gameState[0][2] == player && gameState[1][1] == player && isFreeButton(2,0)) return new int[]{2,0};

        if (gameState[0][2] == player && gameState[2][0] == player && isFreeButton(1,1)) return new int[]{1,1};
        if (gameState[2][0] == player && gameState[1][1] == player && isFreeButton(0,2)) return new int[]{0,2};


        return null;
    }

    public int[] getComputerDecision(){


        //int[][] gameState = gameModel.getGameState();

        //Check for Computer Chance
        //Check for rows
        for (int row = 0; row < 3; row++) {
            int[] rowFree = isRowFree(row,1);
            if (rowFree != null) return rowFree;

        }

        //Check for columns
        for (int column = 0; column < 3; column++) {
            int[] columnFree = isColumnFree(column,1);
            if (columnFree != null) return columnFree;

        }

        //Check for diagonal
        int[] diagonalFree = isDiagonalFree(1);
        if (diagonalFree != null) return diagonalFree;

        //Check for Others Chance
        //Check for rows
        for (int row = 0; row < 3; row++) {
            int[] rowFree = isRowFree(row,0);
            if (rowFree != null) return rowFree;

        }

        //Check for columns
        for (int column = 0; column < 3; column++) {
            int[] columnFree = isColumnFree(column,0);
            if (columnFree != null) return columnFree;

        }

        //Check for diagonal
        diagonalFree = isDiagonalFree(0);
        if (diagonalFree != null) return diagonalFree;


        //Return random free btn

        List<int[]> freeButtons = getFreeButtons();
        if (freeButtons.isEmpty()) return null;

        return freeButtons.get(ran.nextInt(freeButtons.size()));

//        boolean[][] clickedBtns = gameModel.getClickedBtns();
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (!clickedBtns[i][j]){
//                    return new int[]{i,j};
//                }
//            }
//        }




    }


    public String getPlayersMark(int res) {
        return res == 0 ? "O" : "X";
    }
}
