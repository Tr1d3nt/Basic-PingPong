package pingpongtest3;

/**
 *
 * @author arman
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.*;
import java.awt.Color;



public class TwoPlayer extends JPanel implements ActionListener, KeyListener {
	
	private int height, width;
	private Timer timer = new Timer(5, this);
	private boolean first;
        boolean gameStarted = false;
        
	
	private HashSet<String> keys = new HashSet<String>();
	
	private final int SPEED = 3;
	private int heightpad = 10, widthpad = 90;
	private int bottomPadX, topPadX;
	private int inset = 10;
	
	private double ballX, ballY, velX = 2, velY = 2, ballSize = 30;

	private int scoreTop, scoreBottom;
	
	public TwoPlayer() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		first = true;
		timer.setInitialDelay(150);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D pong2D = (Graphics2D) g;
		height = getHeight();
		width = getWidth();

		if (first) {
			bottomPadX = width / 2 - widthpad / 2;
			topPadX = bottomPadX;
			ballX = width / 2 - ballSize / 2;
			ballY = height / 2 - ballSize / 2;
			first = false;
		}
		
		Rectangle2D bottomPad = new Rectangle(bottomPadX, height - heightpad - inset, widthpad, heightpad);
		pong2D.setColor(Color.blue);
		pong2D.fill(bottomPad);
		
		Rectangle2D topPad = new Rectangle(topPadX, inset, widthpad, heightpad);
		pong2D.setColor(Color.red);
		pong2D.fill(topPad);
                
                if (!gameStarted){
                    g.setColor(Color.white);
                    g.drawString("• TWO Player Mode •", 190, 100);
                    g.drawString("⁍ Your Paddle is Blue", 180, 130);
                    g.drawString("⁍ PRESS 'Space' to Begin the game..", 180, 160);
                }
		
		Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
		pong2D.setColor(Color.white);
		pong2D.fill(ball);
		
		String scoreB = "Bottom: " + new Integer(scoreBottom).toString();
		String scoreT = new Integer(scoreTop).toString() + " :Top";
		pong2D.drawString(scoreB, 10, height / 2);
		pong2D.drawString(scoreT, width - 50, height / 2);
                
                if(scoreTop == 3){
                    g.setColor(Color.red);
                    g.drawString("Top Player WINS!" , height / 2, width / 2);
                    gameStarted = false;
            
                 }else if (scoreBottom == 3){
                     g.setColor(Color.blue);
                      g.drawString("Bottom Player WINS!", height / 2, width / 2);
                      gameStarted = false;
                 }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
            if(gameStarted){
		if (ballX < 0 || ballX > width - ballSize) {
			velX = -velX;
		}
		if (ballY < 0) {
			velY = -velY;
			++ scoreBottom;
		}
		
		if (ballY + ballSize > height) {
			velY = -velY;
			++ scoreTop;
		}
		if (ballY + ballSize >= height - heightpad - inset && velY > 0)
			if (ballX + ballSize >= bottomPadX && ballX <= bottomPadX + widthpad)
				velY = -velY;

		// top pad
		if (ballY <= heightpad + inset && velY < 0)
			if (ballX + ballSize >= topPadX && ballX <= topPadX + widthpad)
				velY = -velY;

		ballX += velX;
		ballY += velY;
		
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				bottomPadX -= (bottomPadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("RIGHT")) {
				bottomPadX += (bottomPadX < width - widthpad) ? SPEED : 0;
			}
		}
                if (keys.size() == 1) {
			if (keys.contains("A")) {
				topPadX -= (topPadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("D")) {
				topPadX += (topPadX < width - widthpad) ? SPEED : 0;
			}
		}
		
		
		repaint();
            }
        }

        @Override
	public void keyTyped(KeyEvent e) {}


        @Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.add("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.add("RIGHT");
			break;
                case KeyEvent.VK_A:
			keys.add("A");
			break;  
                case KeyEvent.VK_D:
			keys.add("D");
			break;  
                case KeyEvent.VK_SPACE:
                        gameStarted = true; 
		}
	}


        @Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.remove("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.remove("RIGHT");
			break;
                case KeyEvent.VK_A:
			keys.remove("A");
			break;   
                 case KeyEvent.VK_D:
			keys.remove("D");
			break;        
		}
                
               
		}
	}
        
	

