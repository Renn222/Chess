
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;


import javax.swing.ImageIcon;

public abstract class Piece 
{

    private Image img;
    private int x;
    private int y;
    private int colour;
	public int possY;
	public int possX;
	public boolean isTherePiece = false;
	public boolean isFirstMove;
	
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    
    private static final int TYPE_ROOK = 1;
    private static final int TYPE_KNIGHT = 2;
    private static final int TYPE_BISHOP = 3;
    private static final int TYPE_QUEEN = 4;
    private static final int TYPE_KING = 5;
    private static final int TYPE_PAWN = 6;

	List<Tile> tileOptions = new ArrayList<Tile>();
	Tile possTile;


    public Piece(int colour, int type) 
    {
    	Image img = getImageForPiece(colour, type);
        this.img = img;
        this.colour = colour;
        
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
    
    private Image getImageForPiece(int colour, int type) 
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
    	if(isTherePiece != true)
    	{
    		if((possY >= 0 && possY <= 7) && (possX >= 0 && possX <= 7))
        	{
    			possTile = Board.boardState[possX][possY];
    			
    			if(possTile.isPiece() != false)
    			{
    				if(possTile.getPiece().getColour() == getColour())
    				{
    					isTherePiece = true;
    					return false;
    				}
    			}	
    			
    		return true;
        	}
        }
    	
    	return false;
    }
    
    public void selectTile()
    {
    	possTile.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		possTile.isPossibleMove = true;
		tileOptions.add(possTile);
    }
}
