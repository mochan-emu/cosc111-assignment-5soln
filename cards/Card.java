package cards;

import cards.Card.Suit;

public class Card 
{
	// Suit of the card
	public enum Suit
	{
		Spade,
		Heart,
		Diamond,
		Club
	}
	
	// Suit and value of the card
	int value;
	Suit suit;
	
	// Constructor
	public Card (int value, Suit suit)
	{
		this.value = value;
		this.suit = suit;
	}
	
	// Getters and setters
	public int getValue() { return value; }
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public Suit getSuit() { return suit; }
	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}
	
	// Helper for printing the suit to the console
	public String getSuitSymbol()
	{
		return Card.getSuitSymbol(getSuit());
	}
	
	public String getFaceSymbol()
	{
		switch(value)
		{
		case 1:
			return "A";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		default:
			return Integer.toString(value);
		}
	}
	
	public static String getSuitSymbol(Suit s)
	{
		switch(s)
		{
		case Spade:
			return "\u2660";
		case Heart:
			return "\u2665";
		case Diamond:
			return "\u2666";
		case Club:
			return "\u2663";
		default:
			return "";
		}
	}

	public static Suit getSuitFromIndex(int i) 
	{
		return Suit.values()[i];
	}
}
