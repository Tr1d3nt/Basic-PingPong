package pingpongtest3;

/**
 *
 * @author Saud, Arman, Octye, Ammar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PingPongTest5 {
    
public static void main (String[] args){ 
    
    
  JFrame frame = new JFrame("Ping Pong");
  frame.setVisible(true);
  frame.setSize(400, 100);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
  JPanel panel = new JPanel();
  frame.add(panel);
 
  JButton computer = new JButton( new AbstractAction("Play Against Computer") { 
      
                @Override
                public void actionPerformed( ActionEvent e ) {
                    
                JFrame frm = new JFrame();
		frm.setTitle("SuperPong Game");
		frm.setSize(400, 100);
		frm.setResizable(false);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
                JPanel menu = new JPanel();
                frm.add(menu);
                
                
                JButton easy = new JButton( new AbstractAction("Easy") {   
                  @Override
                  public void actionPerformed( ActionEvent e ) {
                  JFrame frm = new JFrame();
		frm.setTitle("SuperPong Game");
		Easy game = new Easy();
		frm.setContentPane(game);
		frm.setSize(600, 600);
		frm.setResizable(false);
		frm.getContentPane().setBackground(Color.black);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    });
                  menu.add(easy);
               
                  JButton hard = new JButton( new AbstractAction("Hard") {   
                  @Override
                  public void actionPerformed( ActionEvent e ) {
                  JFrame frm = new JFrame();
                  frm.setTitle("SuperPong Game");
                  Hard game = new Hard();
		  frm.setContentPane(game);
		  frm.setSize(600, 600);
		  frm.setResizable(false);
		  frm.getContentPane().setBackground(Color.black);
		  frm.setVisible(true);
		  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        }
    });
      menu.add(hard);  
      
                  }
                  });
                
                
                  
                  
                  
  

  JButton pvp = new JButton( new AbstractAction("Play Against Player") {   
                  @Override
                  public void actionPerformed( ActionEvent e ) {
                      JFrame frm = new JFrame();
                     frm.setTitle("SuperPong Game");
		TwoPlayer game = new TwoPlayer();
		frm.setContentPane(game);
		frm.setSize(600, 600);
		frm.setResizable(false);
		frm.getContentPane().setBackground(Color.black);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      
                      
                      
                  }
                   });
  
  
 
  JButton about = new JButton( new AbstractAction("About") {   
                  @Override
                  public void actionPerformed( ActionEvent e ) {
                      JFrame frm = new JFrame();
		frm.setTitle("About");
		frm.setSize(400, 150);
		frm.setResizable(false);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                 JPanel panel = new JPanel();
                 frm.add(panel);
                 JLabel label1 = new JLabel("This Version of Ping Pong made by Saud, Arman, Ammar, Octye. For our Final Project", JLabel.CENTER);
                 panel.add(label1);
                 JLabel label3 = new JLabel("Most of the code was done by Saud, and Arman", JLabel.CENTER);
                 panel.add(label3);
                 JLabel label4 = new JLabel("Armar's added the comments, and Octye did the pseudocode", JLabel.CENTER);
                 panel.add(label4);
                 frm.add(panel);
                  }
                  });
  
  panel.add(computer);
  panel.add(pvp);
  panel.add(about);
  
  

}
}


  

    
  


          

 



      


    
  

