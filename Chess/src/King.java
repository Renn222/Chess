import java.util.List;

public class King extends Piece
{

	public King(int colour, int type) 
	{
		super(colour, type);
	}
	
	public List<Tile> getMoves()
	{
		possY = getY() + 1;
		possX = getX();

		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY() - 1;
		possX = getX();

		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY();
		possX = getX() + 1;

		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY();
		possX = getX() - 1;
		
		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY() + 1;
		possX = getX() + 1;

		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY() - 1;
		possX = getX() - 1;
		
		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY() - 1;
		possX = getX() + 1;
		
		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		
		possY = getY() + 1;
		possX = getX() - 1;
		
		if(isLegal())
		{
			highlight();
		}
		isTherePiece = false;

		return tileOptions;
	}
}