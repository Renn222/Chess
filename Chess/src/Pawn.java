import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

public class Pawn extends Piece
{	
	public Pawn(int colour, int type) 
	{
		super(colour, type);
		isFirstMove = true;
	}
	
	public List<Tile> getMoves()
	{
		int distance = 1;
		
		if(isFirstMove)
		{
			distance = 2;
		}

		for(int i = 1; i <= distance; i++)
		{
			possY = (getColour() == WHITE) ? getY() - i : getY() + i;
			possX = getX();
			
			possTile = Board.boardState[possX][possY];

			if(isLegal())
			{
				selectTile();
			}	

		}

		possY = (getColour() == WHITE) ? getY() - 1 : getY() + 1;
		
		for(int i = - 1; i <= 1; i += 2)
		{
			possX = getX() + i;

			if(isLegal())
			{

				if(possTile.isPiece() && possTile.getPiece().getColour() != getColour())
				{
					selectTile();
				}
			}			
		}
		
		isTherePiece = false;
		return tileOptions;
	}
}
