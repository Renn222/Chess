
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;


import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public abstract class Piece 
{
    private Image img;
    private int x;
    private int y;
    private int colour;
    public int type;
    
	public int possY;
	public int possX;
	public boolean isTherePiece = false;
	public boolean isFirstMove;
	static boolean kingTileChecking = false;
	
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    
    private static final int TYPE_ROOK = 1;
    private static final int TYPE_KNIGHT = 2;
    public static final int TYPE_BISHOP = 3;
    public static final int TYPE_QUEEN = 4;
    public static final int TYPE_KING = 5;
    public static final int TYPE_PAWN = 6;

	List<Tile> tileOptions = new ArrayList<Tile>();
	Tile possTile;


    public Piece(int colour, int type) 
    {
        this.colour = colour;
        this.type = type;
        
    	Image img = getImageForPiece(colour);
        this.img = img;
    }

    public int getX() 
    {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public int getWidth() 
    {
        return img.getHeight(null);
    }

    public int getHeight() 
    {
        return img.getHeight(null);
    }
    
    public ImageIcon getImageIcon() 
    {
    	ImageIcon image = new ImageIcon(img);
        return image;
    }
    
    public Image getImage() 
    {
    	return img;
    }
    
    public List<Tile> getMoves()
    {
		return null;
    }
    
    public int getColour()
    {
    	return colour;
    }
    
    private Image getImageForPiece(int colour) 
    {
        String filename = "";

        filename += (colour == WHITE ? "White_" : "Black_");
        switch (type) 
        {
            case TYPE_BISHOP:
                filename += "Bishop";
                break;
            case TYPE_KING:
                filename += "King";
                break;
            case TYPE_KNIGHT:
                filename += "Knight";
                break;
            case TYPE_PAWN:
                filename += "Pawn";
                break;
            case TYPE_QUEEN:
                filename += "Queen";
                break;
            case TYPE_ROOK:
                filename += "Rook";
                break;
        }
        filename += ".png";

        URL urlPieceImg = getClass().getResource("images/" + filename);
        return new ImageIcon(urlPieceImg).getImage();        
    }
    
    public boolean isLegal()
    {
    	if(!isTherePiece)
    	{
    		if((possY >= 0 && possY <= 7) && (possX >= 0 && possX <= 7))
        	{
    			possTile = Board.boardState[possX][possY];
    			
    			if(type == TYPE_KING && kingTiles())
    			{
    				return false;
    			}
    			
    			if(possTile.isPiece())
    			{
    				isTherePiece = (type == TYPE_KNIGHT || type == TYPE_PAWN) ? false: true;

    				if(possTile.getPiece().getColour() == getColour())
    				{
    					return false;
    				}
    			}	

    			return true;
        	}
    	}
		return false;
    }
    
    public boolean kingTiles()
    {
    	List<Tile> ddd;
    	kingTileChecking = true;
    	Tile kingTile = possTile;

    	for (Piece piece: Board.pieces)
    	{
    		if(piece.getColour() == BLACK && piece.type == TYPE_BISHOP)
    		{

    		}
    		if(piece.type != TYPE_KING && piece.colour != getColour())
    		{
    			ddd = piece.getMoves();
    			
    			for(Tile d : ddd)
        		{
        			if(kingTile == d)
        			{
        		    	kingTileChecking = false;
        				return true;
        			}
        		}
    			
    			//List<Tile> getRidOfTiles = tileOptions;

    			piece.tileOptions.clear();
    			//for(Tile d: getRidOfTiles)
            	{
        		//	piece.tileOptions.remove(d);
            	}
    		}
       	}
    	kingTileChecking = false;

    	return false;
    }
    
    public void highlight()
    {
    	if(!kingTileChecking)
    	{
        	possTile.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
    		possTile.isPossibleMove = true;
    	}
       	
		tileOptions.add(possTile);
    }
}
