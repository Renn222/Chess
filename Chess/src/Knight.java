import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;

public class Knight extends Piece
{

	public Knight(int colour, int type) 
	{
		super(colour, type);
	}
	
	public List<Tile> getMoves()
	{
		for(int i = -2; i < 2; i += 4)
		{
			currentY = getY() + i;
			
			for(int n = -1; n < 2; n += 2)
			{
				currentX = getX() + n;
				possTile = Board.boardState[currentX][currentY];

				if(isLegal())
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