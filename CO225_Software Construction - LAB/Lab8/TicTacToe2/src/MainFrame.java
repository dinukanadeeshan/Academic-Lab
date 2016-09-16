
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MainFrame extends JPanel {
    private final int SIZE = 3;
    private JButton resetBtn;
    private JButton[][] btns;
    private String currentPlayer;

    private int[][] gameDetails;

    private JPanel gamePanel;

    private Random random;
    private Font btnFont;

    public MainFrame() {
        btnFont = new Font("",2,24);
        random = new Random();
        currentPlayer = "O";
        gameDetails = new int[SIZE][SIZE];
        btns = new JButton[SIZE][SIZE];
        setLayout(new BorderLayout());
        gamePanel = new JPanel(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton btn = new JButton();
                btn.setActionCommand(i + "-" + j);
                btn.addActionListener(new ButtonActionListener());
                btn.setFont(btnFont);
                btns[i][j] = btn;
                gamePanel.add(btn);

            }
        }
        add(gamePanel);
        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(new ResetBtnActionListener());
        add(BorderLayout.SOUTH, resetBtn);
    }

    private boolean thinkForNxt() {
        if (thinkForWin()) {
            JOptionPane.showMessageDialog(this, "You lose...");
            return true;
        }

        if (preventPlayerWin()) {
            return false;
        }

        ArrayList<int[]> emptyBtns = getEmptyBtns();
        if (emptyBtns.size() != 0) {
            int[] coordinates = emptyBtns.get(random.nextInt(emptyBtns.size()));
            mark(coordinates[0], coordinates[1], currentPlayer);
            return checkWinner();
        }else{
            JOptionPane.showMessageDialog(this,"Game Draw!!!");
            reset();
        }
        return false;
    }

    private ArrayList<int[]> getEmptyBtns() {
        ArrayList<int[]> emptySlots = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameDetails[i][j] == 0) {
                    emptySlots.add(new int[]{i, j});
                }
            }
        }
        return emptySlots;
    }

    private void mark(int row, int column, String mark) {
        btns[row][column].setText(mark);
        btns[row][column].setEnabled(false);
        gameDetails[row][column] = mark.equals("O") ? 1 : 2;
        currentPlayer = currentPlayer.equals("O") ? "X" : "O";

    }

    private boolean preventPlayerWin() {
        for (int r = 0; r < SIZE; r++) {
            if (gameDetails[r][0] == gameDetails[r][1] && gameDetails[r][0] == 1 && gameDetails[r][2] == 0) {
                mark(r, 2, "X");
                return true;
            }
            if (gameDetails[r][0] == gameDetails[r][2] && gameDetails[r][0] == 1 && gameDetails[r][1] == 0) {
                mark(r, 1, "X");
                return true;
            }
            if (gameDetails[r][2] == gameDetails[r][1] && gameDetails[r][2] == 1 && gameDetails[r][0] == 0) {
                mark(r, 0, "X");
                return true;
            }

        }

        for (int c = 0; c < SIZE; c++) {
            if (gameDetails[0][c] == gameDetails[1][c] && gameDetails[0][c] == 1 && gameDetails[2][c] == 0) {
                mark(2, c, "X");
                return true;
            }
            if (gameDetails[0][c] == gameDetails[2][c] && gameDetails[0][c] == 1 && gameDetails[1][c] == 0) {
                mark(1, c, "X");
                return true;
            }
            if (gameDetails[2][c] == gameDetails[1][c] && gameDetails[2][c] == 1 && gameDetails[0][c] == 0) {
                mark(0, c, "X");
                return true;
            }

        }

        if (gameDetails[0][0] == gameDetails[1][1] && gameDetails[0][0] == 1 && gameDetails[2][2] == 0) {
            mark(2, 2, "X");
            return true;
        }
        if (gameDetails[0][0] == gameDetails[2][2] && gameDetails[0][0] == 1 && gameDetails[1][1] == 0) {
            mark(1, 1, "X");
            return true;
        }
        if (gameDetails[1][1] == gameDetails[2][2] && gameDetails[1][1] == 1 && gameDetails[0][0] == 0) {
            mark(0, 0, "X");
            return true;
        }

        if (gameDetails[0][2] == gameDetails[1][1] && gameDetails[0][2] == 1 && gameDetails[2][0] == 0) {
            mark(2, 0, "X");
            return true;
        }
        if (gameDetails[0][2] == gameDetails[2][0] && gameDetails[0][2] == 1 && gameDetails[1][1] == 0) {
            mark(1, 1, "X");
            return true;
        }
        if (gameDetails[1][1] == gameDetails[2][0] && gameDetails[1][1] == 1 && gameDetails[0][2] == 0) {
            mark(0, 2, "X");
            return true;
        }

        return false;
    }

    private boolean thinkForWin() {
        for (int r = 0; r < SIZE; r++) {
            if (gameDetails[r][0] == gameDetails[r][1] && gameDetails[r][0] == 2 && gameDetails[r][2] == 0) {
                mark(r, 2, "X");
                return true;
            }
            if (gameDetails[r][0] == gameDetails[r][2] && gameDetails[r][0] == 2 && gameDetails[r][1] == 0) {
                mark(r, 1, "X");
                return true;
            }
            if (gameDetails[r][2] == gameDetails[r][1] && gameDetails[r][2] == 2 && gameDetails[r][0] == 0) {
                mark(r, 0, "X");
                return true;
            }

        }

        for (int c = 0; c < SIZE; c++) {
            if (gameDetails[0][c] == gameDetails[1][c] && gameDetails[0][c] == 2 && gameDetails[2][c] == 0) {
                mark(2, c, "X");
                return true;
            }
            if (gameDetails[0][c] == gameDetails[2][c] && gameDetails[0][c] == 2 && gameDetails[1][c] == 0) {
                mark(1, c, "X");
                return true;
            }
            if (gameDetails[2][c] == gameDetails[1][c] && gameDetails[2][c] == 2 && gameDetails[0][c] == 0) {
                mark(0, c, "X");
                return true;
            }

        }

        if (gameDetails[0][0] == gameDetails[1][1] && gameDetails[0][0] == 2 && gameDetails[2][2] == 0) {
            mark(2, 2, "X");
            return true;
        }
        if (gameDetails[0][0] == gameDetails[2][2] && gameDetails[0][0] == 2 && gameDetails[1][1] == 0) {
            mark(1, 1, "X");
            return true;
        }
        if (gameDetails[1][1] == gameDetails[2][2] && gameDetails[1][1] == 2 && gameDetails[0][0] == 0) {
            mark(0, 0, "X");
            return true;
        }

        if (gameDetails[0][2] == gameDetails[1][1] && gameDetails[0][2] == 2 && gameDetails[2][0] == 0) {
            mark(2, 0, "X");
            return true;
        }
        if (gameDetails[0][2] == gameDetails[2][0] && gameDetails[0][2] == 2 && gameDetails[1][1] == 0) {
            mark(1, 1, "X");
            return true;
        }
        if (gameDetails[1][1] == gameDetails[2][0] && gameDetails[1][1] == 2 && gameDetails[0][2] == 0) {
            mark(0, 2, "X");
            return true;
        }

        return false;
    }

    //`````````````````````````````````````````
    private boolean checkWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (diagonalChecker()) {

                return true;
            }

            if (rowChecker(i)) {
                JOptionPane.showMessageDialog(this, "Winner : " + btns[i][0].getText());
                return true;
            }

            if (columChecker(i)) {
                JOptionPane.showMessageDialog(this, "Winner : " + btns[0][i].getText());
                return true;
            }


        }

        return false;
    }

    private boolean rowChecker(int r) {

        return gameDetails[r][0] == gameDetails[r][1] && gameDetails[r][0] != 0 && gameDetails[r][1] == gameDetails[r][2];


    }

    private boolean columChecker(int c) {
        return gameDetails[0][c] == gameDetails[1][c] && gameDetails[0][c] != 0 && gameDetails[1][c] == gameDetails[2][c];

    }

    private boolean diagonalChecker() {
        if (gameDetails[0][0] == gameDetails[1][1] && gameDetails[0][0] != 0 && gameDetails[1][1] == gameDetails[2][2]) {
            JOptionPane.showMessageDialog(this, "Winner : " + btns[0][0].getText());
            return true;
        }
        if (gameDetails[0][2] == gameDetails[1][1] && gameDetails[0][2] != 0 && gameDetails[1][1] == gameDetails[2][0]) {
            JOptionPane.showMessageDialog(this, "Winner : " + btns[0][2].getText());
            return true;
        }
        return false;
    }

    //````````````````````````````````````````

    private void reset() {
        currentPlayer = "O";
        gameDetails = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                btns[i][j].setEnabled(true);
                btns[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        JFrame frm = new JFrame("Tic Tac Toe");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(400, 400);
        frm.setLocationRelativeTo(null);

        frm.add(new MainFrame());
        frm.setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] coordinates = e.getActionCommand().split("-");
            int i = Integer.parseInt(coordinates[0]);
            int j = Integer.parseInt(coordinates[1]);

//            btns[i][j].setEnabled(false);
//            btns[i][j].setText(currentPlayer);
//            gameDetails[i][j] = currentPlayer.equals("O") ? 1 : 2;
//            currentPlayer = currentPlayer.equals("O") ? "X" : "O";
            mark(i, j, currentPlayer);


            if (checkWinner()) {
                reset();
                return;
            }

            if (thinkForNxt()) {
                reset();
                return;
            }
        }
    }

    private class ResetBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reset();
        }
    }
}
