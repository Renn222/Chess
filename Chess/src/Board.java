
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Board extends JPanel
{
	private static final int WHITE = 0;
    private static final int BLACK = 1;

    private static final int TYPE_ROOK = 1;
    private static final int TYPE_KNIGHT = 2;
    private static final int TYPE_BISHOP = 3;
    private static final int TYPE_QUEEN = 4;
    private static final int TYPE_KING = 5;
    private static final int TYPE_PAWN = 6;

    private static final int BOARD_START_X = 53;
    private static final int BOARD_START_Y = 35;

    private static Piece wr01,wr02,br01,br02;
	private static Piece wk01,wk02,bk01,bk02;
	private static Piece wb01,wb02,bb01,bb02;
	private static Piece wk, wq, bk, bq;
	private static Piece [] wp, bp;
	private static Piece P;
	
	public static Tile boardState[][];
    Tile tile;
      
    private List<Piece> pieces = new ArrayList<Piece>();

    public Board()
	{
      	this.setLayout(new GridLayout(8, 8, 0, 0));

    	
		wp = new Piece[8];
    	bp = new Piece[8];
        
    	
    	// create and place pieces
        //
        // rook, knight, bishop, queen, king, bishop, knight, and rook
	    wr01 = new Rook(WHITE, TYPE_ROOK);
        wr02 = new Rook(WHITE, TYPE_ROOK);
        br01 = new Rook(BLACK, TYPE_ROOK);
        br02 = new Rook(BLACK, TYPE_ROOK);	
        
        wk01 = new Knight(WHITE, TYPE_KNIGHT);
        wk02 = new Knight(WHITE, TYPE_KNIGHT);
        bk01 = new Knight(BLACK, TYPE_KNIGHT);
        bk02 = new Knight(BLACK, TYPE_KNIGHT);
               
        wb01 = new Bishop(WHITE, TYPE_BISHOP);
        wb02 = new Bishop(WHITE, TYPE_BISHOP);
        bb01 = new Bishop(BLACK, TYPE_BISHOP);
        bb02 = new Bishop(BLACK, TYPE_BISHOP);

        wk = new King(WHITE, TYPE_KING);
        wq = new Queen(WHITE, TYPE_QUEEN);
        bk = new King(BLACK, TYPE_KING);
        bq = new Queen(BLACK, TYPE_QUEEN);
        
        // pawns
        for (int x = 0; x < 8; x++)
        {
            wp[x] = new Pawn(WHITE, TYPE_PAWN);
        }

        for (int x = 0; x < 8; x++) 
        {
            bp[x] = new Pawn(BLACK, TYPE_PAWN);
        }
        
        boardState = new Tile[8][8];
        
	    for (int height = 0; height < 8; height++)
	    {
	        for (int width = 0; width < 8; width++) 
	        {
	            P = null;
	            // rooks
	            if (height == 0 && width == 0)
	                P = br01;
	            else if (height == 0 && width == 7)
	                P = br02;
	            else if (height == 7 && width == 0)
	                P = wr01;
	            else if (height == 7 && width == 7)
	                P = wr02;
	            
	            // knights
	            else if (height == 0 && width == 1)
	                P = bk01;
	            else if (height == 0 && width == 6)
	                P = bk02;
	            else if (height == 7 && width == 1)
	                P = wk01;
	            else if (height == 7 && width == 6)
	                P = wk02;
	            
	            // bishop
	            else if (height == 0 && width == 2)
	                P = bb01;
	            else if (height == 0 && width == 5)
	                P = bb02;
	            else if (height == 7 && width == 2)
	                P = wb01;
	            else if (height == 7 && width == 5)
	                P = wb02;
	            
	            // black king and queen
	            else if (height == 0 && width == 3)
	                P = bk;
	            else if (height == 0 && width == 4)
	                P = bq;
	            
	            // white king and queen
	            else if (height == 7 && width == 3)
	                P = wk;
	            else if (height == 7 && width == 4)
	                P = wq;
	            
	            // pawns
	            else if (height == 1)
	                P = bp[width];
	            else if (height == 6)
	                P = wp[width];
	            
	            tile = new Tile(width, height, P);
	            this.add(tile);
	            this.pieces.add(P);
	            boardState[width][height] = tile;
	        }
	    }
	}
    
    public Tile getTile(int x, int y)
    {
    	Tile i = boardState[x][y];
		return i;
    }
}

