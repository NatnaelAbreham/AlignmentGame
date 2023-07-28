package alignmentgame;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Align1 extends JFrame {

    final int IMAGE_WIDTH = 90, IMAGE_HEIGHT = 90;
    int[][] xvalue = new int[3][3];
    int pressedcounter = 1, ii = 0, jj = 0;//ii & jj it store the value which first click pressedcounter if the button pressed more than one it reset to one again 

    ImageIcon icon = new ImageIcon(getClass().getResource("Untitled-11.jpg"));
    ImageIcon redone = new ImageIcon(getClass().getResource("blackone.png"));
    ImageIcon blueone = new ImageIcon(getClass().getResource("blueone1.png"));

    Image blueimage = blueone.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
    Image redimage = redone.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
    Image image = icon.getImage().getScaledInstance(650, 650, java.awt.Image.SCALE_SMOOTH);

    ImageIcon blueicon = new ImageIcon(blueimage);
    ImageIcon redicon = new ImageIcon(redimage);

    JPanel p1;

    JButton[][] button = new JButton[3][3];
    JLabel label;
    JFrame frame;

    Align1() {
        AlignmentGame.frame.setVisible(false);
        frame = new JFrame();

        frame.setSize(660, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        label = new JLabel(new ImageIcon(image));
        p1 = new JPanel();

        label.setLayout(new GridLayout(3, 3, 180, 180));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();
                button[i][j].setBackground(new Color(100, 11, 0));
                button[i][j].setOpaque(false);
                button[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.add(button[i][j]);
                xvalue[i][j] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            button[2][i].setIcon(redicon);
            button[0][i].setIcon(blueicon);
            xvalue[2][i] = 1;
            xvalue[0][i] = 2;
        }

        p1.add(label);
        frame.add(p1);

        ToyListener listener = new ToyListener();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].addActionListener(listener);
            }
        }
    }

    void resetGame() {

        ii = 0;
        jj = 0;

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setIcon(null);
                xvalue[i][j] = 0;
            }
        }
        for (int j = 0; j < 3; j++) {
            button[0][j].setIcon(blueicon);
            xvalue[0][j] = 2;
        }

        for (int j = 0; j < 3; j++) {

            button[2][j].setIcon(redicon);
            xvalue[2][j] = 1;
        }
    }

    void toWin() {

        if (xvalue[0][0] == 0 && xvalue[1][1] == 2 && xvalue[2][2] == 2) {

            if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[0][0] = 2;
                button[0][0].setIcon(blueicon);
            } else if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][0] = 2;
                button[0][0].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][0] == 2 && xvalue[1][1] == 0 && xvalue[2][2] == 2) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 0) {

            if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[2][0] == 0 && xvalue[1][1] == 2 && xvalue[0][2] == 2) {

            if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[2][0] == 2 && xvalue[1][1] == 0 && xvalue[0][2] == 2) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[2][0] == 2 && xvalue[1][1] == 2 && xvalue[0][2] == 0) {

            if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[0][2] = 2;
                button[0][2].setIcon(blueicon);
            } else if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][2] = 2;
                button[0][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 0) {

            if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][2] = 2;
                button[1][2].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][2] = 2;
                button[1][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[1][0] == 2 && xvalue[1][1] == 0 && xvalue[1][2] == 2) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[1][0] == 0 && xvalue[1][1] == 2 && xvalue[1][2] == 2) {

            if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][0] = 2;
                button[1][0].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][0] = 2;
                button[1][0].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 0) {

            if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[2][0] == 2 && xvalue[2][1] == 0 && xvalue[2][2] == 2) {

            if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][1] = 2;
                button[2][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[2][0] == 0 && xvalue[2][1] == 2 && xvalue[2][2] == 2) {

            if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 0) {

            if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][2] == 2 && xvalue[1][2] == 0 && xvalue[2][2] == 2) {

            if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[1][2] = 2;
                button[1][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][2] == 0 && xvalue[1][2] == 2 && xvalue[2][2] == 2) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][2] = 2;
                button[0][2].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 0) {

            if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][0] == 2 && xvalue[1][0] == 0 && xvalue[2][0] == 2) {

            if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[1][0] = 2;
                button[1][0].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][0] == 0 && xvalue[1][0] == 2 && xvalue[2][0] == 2) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][0] = 2;
                button[0][0].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 0) {

            if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[2][1] = 2;
                button[2][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[2][1] = 2;
                button[2][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][1] == 2 && xvalue[1][1] == 0 && xvalue[2][1] == 2) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else if (xvalue[0][1] == 0 && xvalue[1][1] == 2 && xvalue[2][1] == 2) {

            if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[0][1] = 2;
                button[0][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[0][1] = 2;
                button[0][1].setIcon(blueicon);
            } else {
                defence();
            }
        } else {
            defence();
        }

    }

    void getElse() {

        int counter = 0;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (xvalue[m][n] != 0) {
                    counter++;
                }
            }
        }
        if (counter == 9) {
            JOptionPane.showMessageDialog(null, "try again");
            resetGame();
            return;
        }

        int row, col;
        int row1, col1;

        while (true) {
            int random_count = 0;
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);

            if (xvalue[row][col] == 2) {
                while (true) {

                    row1 = (int) (Math.random() * 3);
                    col1 = (int) (Math.random() * 3);

                    if ((xvalue[row1][col1] == 0) && (2 != Math.abs(col1 - col) && (2 != Math.abs(row1 - row))) && !(Math.abs(col1 - col) == 1 && 1 == Math.abs(row1 - row) && ((row + row1) % 2 != 0 || (col + col1) % 2 != 0))) {

                        xvalue[row][col] = 0;
                        button[row][col].setIcon(null);

                        xvalue[row1][col1] = 2;
                        button[row1][col1].setIcon(blueicon);

                        return;
                    }
                    random_count++;

                    if (random_count > 30) {
                        break;
                    }

                }

            }
        }

    }

    void defence() {

        if (xvalue[0][0] == 0 && xvalue[1][1] == 1 && xvalue[2][2] == 1) {

            if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[0][0] = 2;
                button[0][0].setIcon(blueicon);
            } else if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][0] = 2;
                button[0][0].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 1 && xvalue[1][1] == 0 && xvalue[2][2] == 1) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 1 && xvalue[1][1] == 1 && xvalue[2][2] == 0) {

            if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[2][0] == 0 && xvalue[1][1] == 1 && xvalue[0][2] == 1) {

            if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[2][0] == 1 && xvalue[1][1] == 0 && xvalue[0][2] == 1) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[2][0] == 1 && xvalue[1][1] == 1 && xvalue[0][2] == 0) {

            if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[0][2] = 2;
                button[0][2].setIcon(blueicon);
            } else if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][2] = 2;
                button[0][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 0) {

            if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][2] = 2;
                button[1][2].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][2] = 2;
                button[1][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[1][0] == 1 && xvalue[1][1] == 0 && xvalue[1][2] == 1) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[1][0] == 0 && xvalue[1][1] == 1 && xvalue[1][2] == 1) {

            if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][0] = 2;
                button[1][0].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][0] = 2;
                button[1][0].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 0) {

            if (xvalue[1][2] == 2) {
                xvalue[1][2] = 0;
                button[1][2].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 1 && xvalue[0][1] == 0 && xvalue[0][2] == 1) {

            if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][1] = 2;
                button[2][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 0 && xvalue[0][1] == 1 && xvalue[0][2] == 1) {

            if (xvalue[1][0] == 2) {
                xvalue[1][0] = 0;
                button[1][0].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 0) {

            if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][2] == 1 && xvalue[1][2] == 0 && xvalue[2][2] == 1) {

            if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[1][2] = 2;
                button[1][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][2] == 0 && xvalue[1][2] == 1 && xvalue[2][2] == 1) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][2] = 2;
                button[0][2].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 0) {

            if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[2][0] = 2;
                button[2][0].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 1 && xvalue[1][0] == 0 && xvalue[2][0] == 1) {

            if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[1][0] = 2;
                button[1][0].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][0] == 0 && xvalue[1][0] == 1 && xvalue[2][0] == 1) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[0][0] = 2;
                button[0][0].setIcon(blueicon);
            } else if (xvalue[1][1] == 2) {
                xvalue[1][1] = 0;
                button[1][1].setIcon(null);

                xvalue[2][2] = 2;
                button[2][2].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 0) {

            if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[2][1] = 2;
                button[2][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[2][1] = 2;
                button[2][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][1] == 1 && xvalue[1][1] == 0 && xvalue[2][1] == 1) {

            if (xvalue[0][1] == 2) {
                xvalue[0][1] = 0;
                button[0][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][1] == 2) {
                xvalue[2][1] = 0;
                button[2][1].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][0] == 2) {
                xvalue[2][0] = 0;
                button[2][0].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else if (xvalue[2][2] == 2) {
                xvalue[2][2] = 0;
                button[2][2].setIcon(null);

                xvalue[1][1] = 2;
                button[1][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else if (xvalue[0][1] == 0 && xvalue[1][1] == 1 && xvalue[2][1] == 1) {

            if (xvalue[0][0] == 2) {
                xvalue[0][0] = 0;
                button[0][0].setIcon(null);

                xvalue[0][1] = 2;
                button[0][1].setIcon(blueicon);
            } else if (xvalue[0][2] == 2) {
                xvalue[0][2] = 0;
                button[0][2].setIcon(null);

                xvalue[0][1] = 2;
                button[0][1].setIcon(blueicon);
            } else {
                getElse();
            }
        } else {
            getElse();
        }

    }

    class ToyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == button[i][j]) {
                        if (xvalue[i][j] == 2) {
                            return;
                        } else if (pressedcounter == 1 && (xvalue[i][j] == 1)) {
                            ii = i;
                            jj = j;
                            pressedcounter++;
                        } else if (pressedcounter == 1 && (xvalue[i][j] == 0 || xvalue[i][j] == 2)) {
                            return;
                        } else {
                            pressedcounter = 1;
                            if (xvalue[i][j] == 1 || xvalue[i][j] == 2) {
                                return;
                            } else if ((1 == Math.abs(jj - j)) && (1 == Math.abs(ii - i)) && ((j == ii && jj == i) || ((jj + ii) == 3 && (i + j) == 1) || ((j + i) == 3 && (ii + jj) == 1))) {
                                return;
                            } else if ((2 != Math.abs(jj - j)) && (2 != Math.abs(ii - i))) {
                                xvalue[ii][jj] = 0;
                                button[ii][jj].setIcon(null);

                                xvalue[i][j] = 1;
                                button[i][j].setIcon(redicon);

                                if ((xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 1) || (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 1)
                                        || (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 1) || (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 1) || (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 1)
                                        || (xvalue[0][0] == 1 && xvalue[1][1] == 1 && xvalue[2][2] == 1) || (xvalue[0][2] == 1 && xvalue[1][1] == 1 && xvalue[2][0] == 1)) {
                                    JOptionPane.showMessageDialog(null, "you win !!");
                                    int yes = JOptionPane.showConfirmDialog(null, "Do you went to Continue ?");

                                    switch (yes) {
                                        case JOptionPane.YES_OPTION:
                                            resetGame();
                                            break;
                                        case JOptionPane.NO_OPTION:
                                            frame.setVisible(false);
                                            AlignmentGame.frame.setVisible(true);
                                            break;
                                        case JOptionPane.CANCEL_OPTION:
                                             ;
                                            break;
                                        default:
                                            break;
                                    }

                                    return;
                                } else if ((xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 2) || (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 2)
                                        || (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 2) || (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 2) || (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 2)
                                        || (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 2) || (xvalue[0][2] == 2 && xvalue[1][1] == 2 && xvalue[2][0] == 2)) {
                                    JOptionPane.showMessageDialog(null, "you Loss !!");
                                    int yes = JOptionPane.showConfirmDialog(null, "Do you went to Continue ?");

                                    switch (yes) {
                                        case JOptionPane.YES_OPTION:
                                            resetGame();
                                            break;
                                        case JOptionPane.NO_OPTION:
                                            frame.setVisible(false);
                                            AlignmentGame.frame.setVisible(true);
                                            break;
                                        case JOptionPane.CANCEL_OPTION:
                                             ;
                                            break;
                                        default:
                                            break;
                                    }

                                    return;

                                }

                                toWin();
                                // getElse();
                                //toDefence();
                                if ((xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 1) || (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 1)
                                        || (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 1) || (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 1) || (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 1)
                                        || (xvalue[0][0] == 1 && xvalue[1][1] == 1 && xvalue[2][2] == 1) || (xvalue[0][2] == 1 && xvalue[1][1] == 1 && xvalue[2][0] == 1)) {
                                    JOptionPane.showMessageDialog(null, "you win !!");
                                    int yes = JOptionPane.showConfirmDialog(null, "Do you went to Continue ?");

                                    switch (yes) {
                                        case JOptionPane.YES_OPTION:
                                            resetGame();
                                            break;
                                        case JOptionPane.NO_OPTION:
                                            frame.setVisible(false);
                                            AlignmentGame.frame.setVisible(true);
                                            break;
                                        case JOptionPane.CANCEL_OPTION:
                                             ;
                                            break;
                                        default:
                                            break;
                                    }

                                } else if ((xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 2) || (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 2)
                                        || (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 2) || (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 2)
                                        || (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 2)
                                        || (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 2) || (xvalue[0][2] == 2 && xvalue[1][1] == 2 && xvalue[2][0] == 2)) {
                                    JOptionPane.showMessageDialog(null, "you Loss !!");
                                    int yes = JOptionPane.showConfirmDialog(null, "Do you went to Continue ?");

                                    switch (yes) {
                                        case JOptionPane.YES_OPTION:
                                            resetGame();
                                            break;
                                        case JOptionPane.NO_OPTION:
                                            frame.setVisible(false);
                                            AlignmentGame.frame.setVisible(true);
                                            break;
                                        case JOptionPane.CANCEL_OPTION:
                                             ;
                                            break;
                                        default:
                                            break;
                                    }

                                }

                            } else {
                                return;
                            }
                        }
                    }
                }
            }

        }
    }

}
