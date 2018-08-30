import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Tile extends JPanel implements Cloneable
{
	public boolean isPossibleMove;
	private JLabel content;
	private Piece piece;
	int x,y;                             //is public because this is to be accessed by all the other class
	public boolean isSelected = false;
	public List<Tile> tileOptions = new ArrayList<Tile>();
	PiecesDragAndDropListener listener;
	
	int colour;
	private static final int WHITE = 0;
    private static final int BLACK = 1;
    
    private static final int TYPE_ROOK = 1;
    private static final int TYPE_KNIGHT = 2;
    private static final int TYPE_BISHOP = 3;
    private static final int TYPE_QUEEN = 4;
    private static final int TYPE_KING = 5;
    private static final int TYPE_PAWN = 6;

	public Tile(int x, int y, Piece p)
	{		
		this.x = x;
		this.y = y;
		piece = p;

		
		setLayout(new BorderLayout());
	
		if((this.x + this.y) % 2 == 0)
		{
			setBackground(new Color(128, 128, 128));
			colour = BLACK;
		}
	
		else
		{
			setBackground(Color.white);
			colour = WHITE;
		}
	 
		if(piece!=null)
		{
			setPiece(piece);
		}
		
		this.listener = new PiecesDragAndDropListener(this, piece);

	    this.addMouseListener(listener);
	}
	
	public void setPiece(Piece p)    
	{
		piece = p;
		piece.setX(x);
		piece.setY(y);
		piece.setTile(this);
		
		ImageIcon img = piece.getImageIcon();
		content = new JLabel(img);
		this.add(content);
	}
	
	public void removePiece()     
	{
		piece.isFirstMove = false;
		
		piece = null;
		listener.piece = null;
		this.remove(content);
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
			
			tileOptions = piece.getMoves();
			for(Tile i: tileOptions)
			{
				i.listener.setOriginTile(this);
			}
		}	
	}
	
	public void deselect()
	{
		if(colour == BLACK)
		{
			setBackground(new Color(128, 128, 128));
		}
		else if(colour == WHITE)
		{
			setBackground(Color.white);
		}
		
		if(Board.check && piece.type == TYPE_KING)
		{
			setBackground(new Color(255,0,0));
		}
		
		for(Tile i: tileOptions)
		{
			i.setBorder(null);
		}
		
		for(Tile d: tileOptions)
		{
			d.isPossibleMove = false;
		}
		
		isSelected = false;	
		Game.isAnySelected = false;
	}

	public Piece getPiece() 
	{
		return piece;
	}
	
	public int getTileX()
	{
		return x;
	}
	
	public int getTileY()
	{
		return y;
	}
}
