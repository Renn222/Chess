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
		isTherePiece = false;
		if(!kingTileChecking)
		{	
			if(isFirstMove)
			{
				distance = 2;
			}
			
			for(int i = 1; i <= distance; i++)
			{
				possY = (getColour() == WHITE) ? getY() - i : getY() + i;
				possX = getX();
				
				if(isLegal() && !possTile.isPiece())
				{
					highlight();
				}	

			}
		}
		
		possY = (getColour() == WHITE) ? getY() - 1 : getY() + 1;
		
		for(int i = - 1; i <= 1; i += 2)
		{
			possX = getX() + i;

			if(isLegal())
			{
				if(!kingTileChecking)
				{
					if(possTile.isPiece() && possTile.getPiece().getColour() != getColour())
					{
						highlight();
					}
				}
				else
				{
					highlight();
				}
				
			}			
		}

		isTherePiece = false;
		return tileOptions;
	}
}
