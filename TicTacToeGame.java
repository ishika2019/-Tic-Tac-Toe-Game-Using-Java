import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener {


    JFrame frame = new JFrame();
    JPanel tPanel = new JPanel();
    JPanel btPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9];
    int chanceFlag = 0;
    Random random = new Random();
    boolean pl1Chance;


    TicTacToeGame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        tPanel.setLayout(new BorderLayout());
        tPanel.setBounds(0, 0, 800, 100);

        btPanel.setLayout(new GridLayout(3, 3));
        btPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            btPanel.add(button[i]);
            button[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        tPanel.add(textfield);
        frame.add(tPanel, BorderLayout.NORTH);
        frame.add(btPanel);

        startGame();
    }

    public void startGame() {

        try {
            textfield.setText("Loading....");
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        int chance=random.nextInt(2);

        if (chance%2 == 0) {
            pl1Chance = true;
            textfield.setText("X turn");
        } else {
            pl1Chance = false;
            textfield.setText("O turn");
        }
    }
    public void gameOver(String s){
        //chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new TicTacToeGame();
        }
        else{
            frame.dispose();
        }

    }

    public void matchCheck() {
        if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(chanceFlag==9) {
            textfield.setText("Match Tie");
            gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        button[x1].setBackground(Color.RED);
        button[x2].setBackground(Color.RED);
        button[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("X wins");
        gameOver("X Wins");
    }

    public void oWins(int x1, int x2, int x3) {
        button[x1].setBackground(Color.RED);
        button[x2].setBackground(Color.RED);
        button[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        gameOver("O Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (pl1Chance) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText("X");
                        pl1Chance = false;
                        textfield.setText("O turn");
                        chanceFlag++;
                        matchCheck();
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText("O");
                        pl1Chance = true;
                        textfield.setText("X turn");
                        chanceFlag++;
                        matchCheck();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new TicTacToeGame();
    }

}