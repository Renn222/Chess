import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class Game 
{
    private Container content;
    public Game()
    {
    	JFrame f = new JFrame();
    	content = f.getContentPane();
        Board board = new Board();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	board.setLayout(new BorderLayout(0, 0));
        
        f.add(board);
      	board.setLayout(new GridLayout(8, 8, 0, 0));
        f.setResizable(true);
        f.setSize(800, 800);
        f.setTitle("Chess");
        
        content.add(board);
        f.setVisible(true);
    }

	public static void main(String [] args)
	{
		new Game();
	}
}
