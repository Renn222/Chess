import java.util.List;

public class Rook extends Piece
{
	public Rook(int colour, int type) 
	{
		super(colour, type);
	}
	
	public List<Tile> getMoves()
	{
		for(int i = -8; i <= 8; i++)
		{
			possY = getY() + i;
			possX = getX();
			
			if(isLegal())
			{
				selectTile();
			}
			
			possY = getY();
			possX = getX() + i;
			
			if(isLegal())
			{
				selectTile();
			}
		}
		return tileOptions;
	}
}