import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JPanel implements Cloneable
{
	private boolean ispossibledestination;
	private JLabel content;
	private Piece piece;
	int x,y;                             //is public because this is to be accessed by all the other class
	private boolean isSelected=false;
	private boolean ischeck=false;
	
	public Tile(int x,int y,Piece p)
	{		
		this.x=x;
		this.y=y;
		
		setLayout(new BorderLayout());
	
		if((x + y) % 2 == 0)
		{
			setBackground(new Color(128, 128, 128));
		}
	
		else
		{
			setBackground(Color.white);
		}
	 
		if(p!=null)
		{
			setPiece(p);
		}
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
}
