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
		for(int i = -2; i <= 2; i += 4)
		{			
			for(int n = -1; n <= 1; n += 2)
			{
				possY = getY() + i;
				possX = getX() + n;
				
				if(isLegal())
				{
					highlight();
				}
				
				possY = getY() + n;
				possX = getX() + i;
				
				if(isLegal())
				{
					highlight();
				}
			}
		}		
		return tileOptions;
	}
}