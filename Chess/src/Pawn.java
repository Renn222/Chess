import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

public class Pawn extends Piece
{
	List<Tile> tileOptions = new ArrayList<Tile>();
	
	public Pawn(int colour, int type, int x, int y) 
	{
		super(colour, type, x, y);
		isFirstMove = true;
	}
	
	public List<Tile> getMoves()
	{
		int distance = 1;
		Tile tile = null;
		int currentY = 0;
		
		if(isFirstMove)
		{
			distance = 2;
		}

		for(int i = 1; i <= distance; i++)
		{
			currentY = (getColour() == WHITE) ? getY() - i : getY() + i;
			tile = Board.boardState[getX()][currentY];
			
			if(!tile.isPiece())
			{
				tile.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
				tile.isPossibleMove = true;
				tileOptions.add(tile);
			}		
		}
		
		return tileOptions;
	}

}
