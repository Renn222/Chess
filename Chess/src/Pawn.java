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
			currentY = (getColour() == WHITE) ? getY() - i : getY() + i;
			currentX = getX();
			
			if(isLegal())
			{
				possTile = Board.boardState[currentX][currentY];
				
				if(!possTile.isPiece())
				{
					possTile.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
					possTile.isPossibleMove = true;
					tileOptions.add(possTile);
				} 
				
				else
				{
					break;
				}

			}
		}

		currentY = (getColour() == WHITE) ? getY() - 1 : getY() + 1;
		
		for(int i = - 1; i <= 1; i += 2)
		{
			currentX = getX() + i;
			if(isLegal())
			{
				possTile = Board.boardState[currentX][currentY];

				if(possTile.isPiece() && possTile.getPiece().getColour() != getColour())
				{
					possTile.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
					possTile.isPossibleMove = true;
					tileOptions.add(possTile);
				}
			}			
		}
		
		return tileOptions;
	}
}
