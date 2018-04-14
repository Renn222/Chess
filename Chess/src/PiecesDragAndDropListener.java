

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class PiecesDragAndDropListener implements MouseListener
{

    private List<Piece> pieces;
    public Piece piece;
    private Tile tile;
    private Tile originTile;

    private Piece dragPiece;
    private int dragOffsetX;
    private int dragOffsetY;


    public PiecesDragAndDropListener(Tile tile, Piece piece) 
    {
        this.pieces = pieces;
        this.tile  = tile;
        this.piece = piece;
    }

    @Override
    public void mousePressed(MouseEvent evt) 
    {   
        if(tile.isPiece())
        {
        	tile.select();
        }
        else if(tile.isPossibleMove)
        {
        	setPiece(originTile.getPiece());
        	tile.setPiece(piece);
			
        	originTile.removePiece();
			originTile.deselect();
			
			for(Tile i: originTile.tileOptions)
			{
				i.isPossibleMove = false;
				i.isPossibleMove = false;
			}
        }
    }

    public void setPiece(Piece p)
    {
    	piece = p;
    }
    
    public void setOriginTile(Tile t)
    {
    	originTile = t;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) 
    {
    	
        this.dragPiece = null;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    	
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

}
