import java.util.List;

public class Rook extends Piece
{
	public Rook(int colour, int type) 
	{
		super(colour, type);
	}
	
	public List<Tile> getMoves()
	{		
		for(int i = 1; getY() + i <= 8; i++)
		{
			possY = getY() + i;
			possX = getX();

			if(isLegal())
			{
				highlight();
			}
		}
		
		isTherePiece = false;

		
		for(int i = 1; getY() - i >= 0; i++)
		{

			possY = getY() - i;
			possX = getX();

			if(isLegal())
			{
				highlight();
			}
		}
		isTherePiece = false;

		for(int i = 1; getX() + i <= 8; i++)
		{
			possY = getY();
			possX = getX() + i;

			if(isLegal())
			{
				highlight();
			}
		}
		
		isTherePiece = false;

		for(int i = 1; getX() - i >= 0; i++)
		{
			possY = getY();
			possX = getX() - i;
			
			if(isLegal())
			{
				highlight();
			}
		}
		
		isTherePiece = false;

		return tileOptions;
	}
}