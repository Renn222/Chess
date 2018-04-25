

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
					
			for(Tile i: originTile.tileOptions)
			{
				i.isPossibleMove = false;
				i.isPossibleMove = false;
			}
        }
    	
    	else if(tile.isPiece())
        {
        	tile.select();
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
<<<<<<< HEAD
    public void mouseClicked(MouseEvent arg0) {
    	
    }

    @Override
=======
    public void mouseDragged(MouseEvent evt) 
    {
    	System.out.println(evt.getPoint().x);
        if(this.dragPiece != null)
        {
        	if((evt.getPoint().y - this.dragOffsetY) > 100)
        	{
        		System.out.println("Yes");
        	}
        	this.dragPiece.setX(evt.getPoint().x - this.dragOffsetX);
            this.dragPiece.setY(evt.getPoint().y - this.dragOffsetY);
            this.chessGui.repaint();
        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    	
    }

    @Override
>>>>>>> master
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
