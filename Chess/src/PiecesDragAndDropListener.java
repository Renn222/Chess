

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
    			Board.pieces.remove(piece);
    			tile.removePiece();
    		}
    		
        	setPiece(originTile.getPiece());
        	tile.setPiece(piece);
        	this.setPiece(piece);
        	
        	originTile.removePiece();
			//Board.checkCheck();
			originTile.deselect();
			Game.turn = (Game.turn == WHITE) ? BLACK : WHITE;
			
	        String turnMessage = Game.turnCheck();
			Game.txtpnHello.setText(turnMessage + " turn");
			
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j< 8; j++)
				{
					Board.boardState[i][j].isPossibleMove = false;
				}
			}
			
			for(int i = 0; i < piece.tileOptions.size(); i++)
			{
				piece.tileOptions.remove(i);
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
