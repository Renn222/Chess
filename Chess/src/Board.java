import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel
{
	private static final int COLOR_WHITE = 0;
    private static final int COLOR_BLACK = 1;

    private static final int TYPE_ROOK = 1;
    private static final int TYPE_KNIGHT = 2;
    private static final int TYPE_BISHOP = 3;
    private static final int TYPE_QUEEN = 4;
    private static final int TYPE_KING = 5;
    private static final int TYPE_PAWN = 6;

    private static final int BOARD_START_X = 53;
    private static final int BOARD_START_Y = 35;

    private static final int TILE_OFFSET_X = 62;
    private static final int TILE_OFFSET_Y = 61;

    private static Piece wr01,wr02,br01,br02;
	private static Piece wk01,wk02,bk01,bk02;
	private static Piece wb01,wb02,bb01,bb02;
	private static Piece wk, wq, bk, bq;
	private static Piece [] wp, bp;
	private static Piece P;
	
	private Tile boardState[][];
    Tile tile;
    
    private Container content;
    
    private List<Piece> pieces = new ArrayList<Piece>();

    public Board()
	{
		wp = new Piece[8];
    	bp = new Piece[8];
        JFrame f = new JFrame();
        content = f.getContentPane();
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setLayout(new BorderLayout(0, 0));
        
        f.getContentPane().add(this, BorderLayout.CENTER);
        this.setLayout(new GridLayout(8, 8, 0, 0));
        f.setResizable(false);
        f.setSize(800, 800);
        f.setTitle("Chess");
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
    	
        // load and set background image
        //URL urlBackgroundImg = getClass().getResource("/images/chessboard.jpg");
        //this.imgBackground = new ImageIcon(urlBackgroundImg).getImage();
    	
    	// create and place pieces
        //
        // rook, knight, bishop, queen, king, bishop, knight, and rook
	    wr01 = createAndAddPiece(COLOR_WHITE, TYPE_ROOK, BOARD_START_X + TILE_OFFSET_X * 0, BOARD_START_Y + TILE_OFFSET_Y * 7);
        wr02 = createAndAddPiece(COLOR_WHITE, TYPE_ROOK, BOARD_START_X + TILE_OFFSET_X * 7, BOARD_START_Y + TILE_OFFSET_Y * 7);
        br01 = createAndAddPiece(COLOR_BLACK, TYPE_ROOK, BOARD_START_X + TILE_OFFSET_X * 0, BOARD_START_Y + TILE_OFFSET_Y * 0);
        br02 = createAndAddPiece(COLOR_BLACK, TYPE_ROOK, BOARD_START_X + TILE_OFFSET_X * 7, BOARD_START_Y + TILE_OFFSET_Y * 0);	
        
        wk01 = createAndAddPiece(COLOR_WHITE, TYPE_KNIGHT, BOARD_START_X + TILE_OFFSET_X * 1, BOARD_START_Y + TILE_OFFSET_Y * 7);
        wk02 = createAndAddPiece(COLOR_WHITE, TYPE_KNIGHT, BOARD_START_X + TILE_OFFSET_X * 6, BOARD_START_Y + TILE_OFFSET_Y * 7);
        bk01 = createAndAddPiece(COLOR_BLACK, TYPE_KNIGHT, BOARD_START_X + TILE_OFFSET_X * 1, BOARD_START_Y + TILE_OFFSET_Y * 0);
        bk02 = createAndAddPiece(COLOR_BLACK, TYPE_KNIGHT, BOARD_START_X + TILE_OFFSET_X * 6, BOARD_START_Y + TILE_OFFSET_Y * 0);
               
        wb01 = createAndAddPiece(COLOR_WHITE, TYPE_BISHOP, BOARD_START_X + TILE_OFFSET_X * 2, BOARD_START_Y + TILE_OFFSET_Y * 7);
        wb02 = createAndAddPiece(COLOR_WHITE, TYPE_BISHOP, BOARD_START_X + TILE_OFFSET_X * 5, BOARD_START_Y + TILE_OFFSET_Y * 7);
        bb01 = createAndAddPiece(COLOR_BLACK, TYPE_BISHOP, BOARD_START_X + TILE_OFFSET_X * 2, BOARD_START_Y + TILE_OFFSET_Y * 0);
        bb02 = createAndAddPiece(COLOR_BLACK, TYPE_BISHOP, BOARD_START_X + TILE_OFFSET_X * 5, BOARD_START_Y + TILE_OFFSET_Y * 0);

        wk = createAndAddPiece(COLOR_WHITE, TYPE_KING, BOARD_START_X + TILE_OFFSET_X * 3, BOARD_START_Y + TILE_OFFSET_Y * 7);
        wq = createAndAddPiece(COLOR_WHITE, TYPE_QUEEN, BOARD_START_X + TILE_OFFSET_X * 4, BOARD_START_Y + TILE_OFFSET_Y * 7);
        bk = createAndAddPiece(COLOR_BLACK, TYPE_QUEEN, BOARD_START_X + TILE_OFFSET_X * 3, BOARD_START_Y + TILE_OFFSET_Y * 0);
        bq = createAndAddPiece(COLOR_BLACK, TYPE_KING, BOARD_START_X + TILE_OFFSET_X * 4, BOARD_START_Y + TILE_OFFSET_Y * 0);
        
        // pawns
        for (int i = 0; i < 8; i++)
        {
            wp[i] = createAndAddPiece(COLOR_WHITE, TYPE_PAWN, BOARD_START_X + TILE_OFFSET_X * i, BOARD_START_Y + TILE_OFFSET_Y * 6);
        }

        for (int i = 0; i < 8; i++) 
        {
            bp[i] = createAndAddPiece(COLOR_BLACK, TYPE_PAWN, BOARD_START_X + TILE_OFFSET_X * i, BOARD_START_Y + TILE_OFFSET_Y * 1);
        }
        
        boardState = new Tile[8][8];
        
	    for (int i = 0; i < 8; i++)
	    {
	        for (int j = 0; j < 8; j++) 
	        {
	            P = null;
	            if (i == 0 && j == 0)
	                P = br01;
	            else if (i == 0 && j == 7)
	                P = br02;
	            else if (i == 7 && j == 0)
	                P = wr01;
	            else if (i == 7 && j == 7)
	                P = wr02;
	            else if (i == 0 && j == 1)
	                P = bk01;
	            else if (i == 0 && j == 6)
	                P = bk02;
	            else if (i == 7 && j == 1)
	                P = wk01;
	            else if (i == 7 && j == 6)
	                P = wk02;
	            else if (i == 0 && j == 2)
	                P = bb01;
	            else if (i == 0 && j == 5)
	                P = bb02;
	            else if (i == 7 && j == 2)
	                P = wb01;
	            else if (i == 7 && j == 5)
	                P = wb02;
	            else if (i == 0 && j == 3)
	                P = bk;
	            else if (i == 0 && j == 4)
	                P = bq;
	            else if (i == 7 && j == 3)
	                P = wk;
	            else if (i == 7 && j == 4)
	                P = wq;
	            else if (i == 1)
	                P = bp[j];
	            else if (i == 6)
	                P = wp[j];
	            tile = new Tile(i, j, P);
	            this.add(tile);
	            PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this.pieces, this);

	    	    this.addMouseListener(listener);
	    	    this.addMouseMotionListener(listener);

	            boardState[i][j] = tile;
	        }
	    }
	    content.add(this);
        f.setVisible(true);
	}
	
	private Piece createAndAddPiece(int color, int type, int x, int y) 
	{
	   	Image img = getImageForPiece(color, type);
	    Pawn piece = new Pawn(img, x, y);
	    this.pieces.add(piece);
	    return piece;
	}

	    /**
	     * load image for given color and type. This method translates the color and
	     * type information into a filename and loads that particular file.
	     *
	     * @param color color constant
	     * @param type type constant
	     * @return image
	     */
    private Image getImageForPiece(int color, int type) 
    {
        String filename = "";

        filename += (color == COLOR_WHITE ? "White_" : "Black_");
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
 
    public static void main(String[] args) 
    {
        new Board();
    }

}

