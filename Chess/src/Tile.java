import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Tile extends JPanel implements Cloneable
{
	private boolean ispossibledestination;
	private JLabel content;
	private Piece piece;
	int x,y;                             //is public because this is to be accessed by all the other class
	public boolean isSelected=false;
	private boolean ischeck=false;
	
	int colour;
	int black = -1;
	int white = 1;
	
	public Tile(int x, int y, Piece p)
	{		
		this.x = x;
		this.y = y;
		
		setLayout(new BorderLayout());
	
		if((x + y) % 2 == 0)
		{
			setBackground(new Color(128, 128, 128));
			colour = black;
		}
	
		else
		{
			setBackground(Color.white);
			colour = white;
		}
	 
		if(p!=null)
		{
			setPiece(p);
		}
		
		PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this);

	    this.addMouseListener(listener);
	}
	
	public void setPiece(Piece p)    //Function to inflate a cell with a piece
	{
		piece=p;
		ImageIcon img = p.getImageIcon();
		//ImageIcon img = new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content = new JLabel(img);
		this.add(content);
	}
	
	public void removePiece()      //Function to remove a piece from the cell
	{
		/*if (piece instanceof King)
		{
			piece=null;
			this.remove(content);
		}
		else*/
		{
			piece=null;
			this.remove(content);
		}
	}
	public boolean isPiece()
	{
		if(piece != null)
		{
			return true;
		}
		return false;
	}
	
	public void select()
	{
		if(isSelected)
		{
			deselect();
		}
		
		else if(!Game.isAnySelected)
		{
			
			setBackground(new Color(143, 188, 143));
			isSelected = true;
			Game.isAnySelected = true;
		}
		
	}
	
	public void deselect()
	{
		if(colour == black)
		{
			setBackground(new Color(128, 128, 128));
		}
		else if(colour == white)
		{
			setBackground(Color.white);
		}
		isSelected = false;
		Game.isAnySelected = false;
	}
}
