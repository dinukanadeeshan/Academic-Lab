import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JFrame {


    private JPanel gamePanel;

    private JButton[][] buttons;
    private JButton resetBtn;

    private GameController gameController;


    public GameView() {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        gamePanel = new JPanel(new GridLayout(3, 3));
        gamePanel.setBackground(Color.cyan);


        JOptionPane.showMessageDialog(this, "This is 2 player game... Play with computer is not implemented yet!!! :(\n\n Thank you.!!");

       gameController = new GameController(new GameModel());

        buttons = new JButton[3][3];

        ActionListener btnAction = new ActionListener(){



            @Override
            public void actionPerformed (ActionEvent e){
                String[] cmd = e.getActionCommand().split(" ");
                int i = Integer.parseInt(cmd[0]);
                int j = Integer.parseInt(cmd[1]);

                if (!gameController.hasClickThisButton(i,j)) {

                    ((JButton) e.getSource()).setText(gameController.getPlayersMark());

                    gameController.clickedThisButton(i,j);
                    gameController.changePlayer();

                    int res = gameController.checkForWinner();

                    if (res == -1){
                        return;
                    }

                    if (res == 10) {
                        JOptionPane.showMessageDialog(GameView.this, "Game Draw!!");
                        resetBtn.doClick();
                    } else {
                        JOptionPane.showMessageDialog(GameView.this, "Winner : "+gameController.getPlayersMark(res));
                        resetBtn.doClick();
                    }

                }


            }
        } ;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                buttons[i][j] = btn;
                btn.setFont(new Font("", 1, 30));
                btn.setActionCommand(i + " " + j);
                btn.addActionListener(btnAction);
                gamePanel.add(btn);

            }
        }

        add(gamePanel);

        resetBtn = new JButton("Reset");
        resetBtn.setFont(new Font("", 1, 25));
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }

                gameController.setGameModel(new GameModel());

            }
        });

        add(BorderLayout.SOUTH, resetBtn);

        setVisible(true);
    }


    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new GameView();
    }
}
