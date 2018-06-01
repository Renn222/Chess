import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.util.List;


public class Game 
{
    private Container content;
    //public static boolean gameStarted = false;
    final static int WHITE = 0;
    final static int BLACK = 1;
    static int turn;
    static JTextPane txtpnHello = new JTextPane();

    
    public static boolean isAnySelected = false;
    public Game()
    {
    	JFrame f = new JFrame();
    	f.setResizable(true);
        f.setSize(800, 800);
        f.setTitle("Chess");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    	
    	content = f.getContentPane();
        content.setLayout(new BorderLayout());
        
        Board board = new Board();

        content.add(board, BorderLayout.CENTER);
                     
        turn = WHITE;
        
        String turnMessage = turnCheck();
        
        txtpnHello.setBackground(Color.YELLOW);
        txtpnHello.setText(turnMessage + " turn");
        f.getContentPane().add(txtpnHello, BorderLayout.NORTH);
        f.setVisible(true);
        //gameStarted = true;
        
        turn = WHITE;
    }

	public static void main(String [] args)
	{
		new Game();
	}
	
	public static String turnCheck()
	{
        String turnMessage = (turn == WHITE) ? "White's" : "Black's";
        
        return turnMessage;
	}
	
	public static void gameOver()
	{
		
	}
}
