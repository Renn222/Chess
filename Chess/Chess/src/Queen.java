import java.util.List;

public class Queen extends Piece
{

	public Queen(int colour, int type) 
	{
		super(colour, type);
	}
	
	public List<Tile> getMoves()
	{
		/* Rook Code */
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
		
		
		/* Bishop code*/
		for(int i = 1; getY() + i <= 8; i++)
		{			
			possY = getY() + i;
			possX = getX() + i;

			if(isLegal())
			{
				highlight();
			}
		}
		
		isTherePiece = false;

		for(int i = 1; getY() - i >= 0; i++)
		{
			possY = getY() - i;
			possX = getX() - i;
			
			if(isLegal())
			{
				highlight();
			}
		}
		
		isTherePiece = false;
		
		for(int i = 1; (getY() - i >= 0 && getX() + i <= 8); i++)
		{
			possY = getY() - i;
			possX = getX() + i;
			
			if(isLegal())
			{
				highlight();
			}
		}
		
		isTherePiece = false;
		
		for(int i = 1; (getY() + i <= 8 && getX() - i >= 0); i++)
		{
			possY = getY() + i;
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