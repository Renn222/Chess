

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class PiecesDragAndDropListener implements MouseListener
{

    private List<Piece> pieces;
    private Piece piece;
    private Tile tile;

    private Piece dragPiece;
    private int dragOffsetX;
    private int dragOffsetY;


    public PiecesDragAndDropListener(Tile tile) 
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
    }

    
    private boolean mouseOverPiece(Piece piece, int x, int y) 
    {
        return piece.getX() <= x
                && piece.getX()+piece.getWidth() >= x
                && piece.getY() <= y
                && piece.getY()+piece.getHeight() >= y;
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
