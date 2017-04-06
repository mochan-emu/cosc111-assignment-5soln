
import cards.*;

import java.util.*;

// Application for generating random cards
public class CardApp 
{
	public static void main(String[] args) 
	{
		System.out.println("Please enter the number of cards to generate:");
		
		// Random to create random values
		Random rand = new Random();
		
		// Get the number of cards to generate from the user
		Scanner kb = new Scanner(System.in);
		int ncards = kb.nextInt();

		// Create the array of cards
		Card[] cards = new Card[ncards];
		for (int i=0; i<cards.length; i++)
		{
			int face = rand.nextInt(13) + 1;
			Card.Suit suit = Card.getSuitFromIndex(rand.nextInt(4));
			cards[i] = new Card(face, suit);
		}
		
		// Print the array of cards
		for (int i=0; i<cards.length; i++)
		{
			Card c = cards[i];
			
			System.out.println(c.getSuitSymbol() + " " + c.getFaceSymbol());
		}
	}
}
