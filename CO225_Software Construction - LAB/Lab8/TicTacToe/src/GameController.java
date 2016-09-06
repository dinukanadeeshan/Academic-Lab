/**
 * Project - TicTacToe
 * Created by Dinuka Nadeeshan on 9/6/16.
 * dinuka.nadeeshan1993@gmail.com
 */
public class GameController {
    private GameModel gameModel;

    public GameController(GameModel gameModel) {
        this.gameModel = gameModel;


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


//    public int[] getComputerDecision(){
//        int[] arr = new int[2];
//
//        int[][] gameState = gameModel.getGameState();
//
//
//        return arr;
//    }


    public String getPlayersMark(int res) {
        return res == 0 ? "O" : "X";
    }
}
