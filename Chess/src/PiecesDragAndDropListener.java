

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
    
    final int WHITE = 0;
    final int BLACK = 1;

    public PiecesDragAndDropListener(Tile tile, Piece piece) 
    {
        this.tile  = tile;
        this.piece = piece;
    }

    @Override 
    public void mousePressed(MouseEvent evt) 
    {  
    	if(tile.isPossibleMove)
        {
    		if(tile.isPiece())
    		{
    			tile.removePiece();
    		}
    		
        	setPiece(originTile.getPiece());
        	tile.setPiece(piece);
			
        	originTile.removePiece();
			originTile.deselect();
			Game.turn = (Game.turn == WHITE) ? BLACK : WHITE;
			
	        String turnMessage = Game.turnCheck();
			Game.txtpnHello.setText(turnMessage + " turn");

			
			for(Tile i: originTile.tileOptions)
			{
				i.isPossibleMove = false;
				i.isPossibleMove = false;
			}
        }
    	
    	else if(tile.isPiece())
        {
        	if(tile.getPiece().getColour() == Game.turn)
        	{
        		tile.select();
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
    public void mouseClicked(MouseEvent arg0) {
    	
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
