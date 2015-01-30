/*+----------------------------------------------------------------------
 ||
 ||  Class: Card.java
 ||
 ||         Author:  Spencer Klinge
 ||
 ||        Purpose:  The class representing each individual object in the deck object.
 					The card object contatins data for the suit and rank of each card.
 					rank is represented as ints 1-13 and suits are represented as strings.
 					This class is also responsible fot the implitation of Comparable so cards can be
 					compared to each other based on the parameters set by the assignment.
 					
 ||  Inherits From:  N/A
 ||     Interfaces:  Comparible
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  N/A
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  Card(int,String)
 ||
 ||  Class Methods:  N/A
 ||
 ||  Inst. Methods:  getRank(), getSuit() toString(), compareTo(Card)
 ++-----------------------------------------------------------------------*/

public class Card implements Comparable<Card> {
	int rank;
	String suit;	//D-68-Dimond,H-72-Heart,S-83-Spade,C-67-Club
	
    /*---------------------------------------------------------------------
    |  Method Card(int, String)
    |
    |  Purpose:  Card Constructor. intializes the rank int and suit
    			String.
    			
    |  Pre-condition:  N/a
    |
    |  Post-condition:Card object will be constructed.
    |
    |  Parameters: int- rank, String-Suit
    |  Returns:  N/A
    *-------------------------------------------------------------------*/
	public Card(int r, String str){
		rank=r;
		suit=str;
	}
    /*---------------------------------------------------------------------
    |  Method getRank(), getSuit()
    |
    |  Purpose:  These methods merely return the data of the two Card class parameters
    			suit and rank.
    |  Pre-condition: N/A
    
    |  Post-condition: N/a
    
    |  Parameters:N/A
    |
    |  Returns:  the data of each parameter
    *-------------------------------------------------------------------*/
	public int getRank(){
		return rank;
	}
	
	public String getSuit(){
		return suit;
	}
    /*---------------------------------------------------------------------
    |  Method ToString()
    |
    |  Purpose:  Using the rank and suit of the Card object, this method first
    			switchs between 1-13 to assin a number or letter depending on the card,
    			then, using the defualt .uppercase version of the suit, compares it to the trimed
    			and capatalized version of the given suit
    |  Pre-condition:  Cards exist!
    |
    |  Post-condition: String will be returned cotaing string card data.
    
    |  Parameters:Na
    
    |  Returns:  String.
    *-------------------------------------------------------------------*/
	public String toString(){
		String temp= new String("");
		int tempRank=rank;
		switch(tempRank){
		case 1: temp+= "A";
			break;
		case 2: temp+= "2";
			break;
		case 3: temp+= "3";
			break;
		case 4: temp+= "4";
			break;
		case 5: temp+= "5";
			break;
		case 6: temp+= "6";
			break;
		case 7:	temp+= "7";
			break;
		case 8:	temp+= "8";
			break;
		case 9:	temp+= "9";
			break;
		case 10: temp+= "10";
			break;
		case 11: temp+="J";
			break;
		case 12: temp+="Q";
			break;
		case 13: temp+="K";
			break;
		default: temp+="!";
		}
		if(suit.compareTo("CLUBS")==0)//67=C= Club
			temp+="C";
		if(suit.compareTo("DIAMONDS") == 0)//68= D= Diamond
			temp+="D";
		if(suit.compareTo("HEARTS") == 0)//72=H= Heart
			temp+="H";
		if(suit.compareTo("SPADES") == 0)//83=S=Spade
			temp+="S";
		
		return temp;
		
	}

    /*---------------------------------------------------------------------
    |  Method: CompareTo(Card)
    |
    |  Purpose:  Compares each card as greater than or less than according to the 
    			the parameters outlined by the spec. It is calulated by applying a value
    			to the numerical value of the rank + a numerical value dependent on the verified suit.
    			it then just compares these total values.
    			
    |  Pre-condition:  N/a
    |  Post-condition: Comparison will be made.
    |  Parameters: Card c- card being compared to this card.
    |  Returns:  1, 0, or -1
    *-------------------------------------------------------------------*/
	@Override
	//should this be comparing nodes or Cards?
	public int compareTo(Card o) {
		int ovalue=0;
		int thisValue=0;
		if(o.getSuit().compareTo("CLUBS") == 0){
			ovalue= o.getRank();
		}
		if(o.getSuit().compareTo("DIAMONDS") == 0){
			ovalue= o.getRank() + 13;
	}
		if(o.getSuit().compareTo("HEARTS") == 0){
			ovalue= o.getRank()+ 26;
		}
		if(o.getSuit().compareTo("SPADES") == 0){
			ovalue= o.getRank() + 39;
		}


		
		if(this.getSuit().compareTo("CLUBS") == 0){
			thisValue= this.getRank();
		}
		if(this.getSuit().compareTo("DIAMONDS") == 0){
			thisValue= this.getRank() + 13;
	}
		if(this.getSuit().compareTo("HEARTS") == 0){
			thisValue= this.getRank()+ 26;
		}
		if(this.getSuit().compareTo("SPADES") == 0){
			thisValue= this.getRank() + 39;
		}
		if(thisValue > ovalue)
			return 1;
		if(thisValue < ovalue)
			return -1;
		return 0;
		
		/*
		if(this.getRank()== o.getRank() && this.getSuit() == o.getSuit())
			return 0;
		if(this.getRank() == o.getRank()){
			if(this.getSuit().charAt(0) > o.getSuit().charAt(0))
				return 1;
			return -1;
		}
		else{
			if(this.getRank() == 1 && o.getRank() != 1)
				return 1;
			if(this.getRank() != 1 && o.getRank() == 1)
				return -1;
			if(this.getRank() > o.getRank())
				return 1;
			if(this.getRank() < o.getRank())
				return -1;
			//chekc aces
			
		}
		return 0;//UNREACHABLE CASE*/
	}
	
}
