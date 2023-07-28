 
package alignmentgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlignmentGame extends JFrame{

    JButton align1,align2,align3;
    JPanel l1,l2;
    final int WIDTH = 200,HEIGHT=200;
    
    ImageIcon icon1 = new ImageIcon(getClass().getResource("align1.png"));
    ImageIcon icon2 = new ImageIcon(getClass().getResource("align2.png"));
    ImageIcon icon3 = new ImageIcon(getClass().getResource("align3.png"));
    
    Image image1 = icon1.getImage().getScaledInstance(WIDTH,HEIGHT,java.awt.Image.SCALE_SMOOTH);
    Image image2 = icon2.getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
    Image image3 = icon3.getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
    
    ImageIcon icn1 = new ImageIcon(image1);
    ImageIcon icn2 = new ImageIcon(image2);
    ImageIcon icn3 = new ImageIcon(image3);
    static JFrame frame;
    
    
    AlignmentGame(){
        
        super("Alignment Game");
        
        l1 = new JPanel(new GridLayout(1,3));
        l1.setBackground(Color.WHITE);
        align1 = new JButton();
        align1.setIcon(icn1);
        align1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        align1.setBackground(new Color(0,111,200) );
        
        align2 = new JButton();
        align2.setIcon(icn2);
        align2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        align2.setBackground(new Color(0,111,200));
        
        align3 = new JButton();
        align3.setIcon(icn3);
        align3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        align3.setBackground(new Color(0,111,200) );
        
        l1.add(align1);
        l1.add(align2);
        l1.add(align3);
        
         
        
        add(l1,BorderLayout.CENTER);
        
        align1.addActionListener((ActionEvent event) -> {
            new Align();
        });
        
         align2.addActionListener(new ActionListener(){
        
           @Override
           public void actionPerformed(ActionEvent event){
             new Align1();
           }
        });
        
         align3.addActionListener(new ActionListener(){
        
           @Override
           public void actionPerformed(ActionEvent event){
             new Align2();
           }
        });
        
    }
    
    public static void main(String[] args) {
        
        frame = new AlignmentGame();

        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
