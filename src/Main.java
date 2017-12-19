
package pingpongtest2;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import pingpongtest2.PingPongTest2.Action3;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PingPongTest2 {

public static void main (String[] args){    
  JFrame frame = new JFrame("Ping Pong");
  frame.setVisible(true);
  frame.setSize(450,100);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
  JPanel panel = new JPanel();
  frame.add(panel);
 
  JButton button = new JButton("Play Against Computer");
  button.setBounds(40, 100, 100, 60);
  panel.add(button);
  button.setBounds(1,1,1,1);
  button.addActionListener (new Action1());
  
  
  
  JButton button2 = new JButton("Play Against Player");
  panel.add(button2);
  button2.setBounds(1,2,2,2);
  button2.addActionListener (new Action2()); 
  
  JButton button3 = new JButton("About");
  panel.add(button3);
  button3.setBounds(1,3,3,3);
  button3.addActionListener (new Action3()); 

 
}
static class Action1 implements ActionListener { 
    
  public void actionPerformed (ActionEvent e) {  
    
    JFrame frm = new JFrame();
		frm.setTitle("PingPong Game");
		OnePlayer game = new OnePlayer();
		frm.setContentPane(game);
		frm.setSize(500, 500);
		frm.setResizable(false);
		frm.getContentPane().setBackground(Color.black);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
                
	}

}  
static class Action2 implements ActionListener {  
    
  public void actionPerformed (ActionEvent e) {     
    
      JFrame frm = new JFrame();
		frm.setTitle("PingPong Game");
		TwoPlayer game = new TwoPlayer();
		frm.setContentPane(game);
		frm.setSize(500, 500);
		frm.setResizable(false);
		frm.getContentPane().setBackground(Color.black);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
  static class Action3 implements ActionListener {  
    
  public void actionPerformed (ActionEvent e) {     
    
      JFrame frm = new JFrame();
		frm.setTitle("About");
		frm.setSize(600,600);
		frm.setResizable(false);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                 JPanel panel = new JPanel();
                 frm.add(panel);
                 JLabel label1 = new JLabel("Ping Pong made by Saud, Arman, Ammar, Octye", JLabel.CENTER);
                 panel.add(label1);
                 JLabel label3 = new JLabel("Most of the code was done by Saud, with the help of Arman", JLabel.CENTER);
                 panel.add(label3);
                 JLabel label4 = new JLabel("Ammar added the comments, and Octye did the pseudocode", JLabel.CENTER);
                 panel.add(label4);
                 frm.add(panel);
                 JLabel label2 = new JLabel("We followed youtube tutorials for the game", JLabel.CENTER);
                 panel.add(label2);
                 JLabel label5 = new JLabel("And the AI Code was found on Github", JLabel.CENTER);
                 panel.add(label5);
               
}
  

}
}



