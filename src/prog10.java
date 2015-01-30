import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/*=============================================================================
|   Assignment:  Program #[10]:  [Fargo]
|       Author:  [Spencer Klinge (sklinge@email.arizona.edu)]
| Sect. Leader:  [Lizzie]
|
|       Course:  [CSC227]
|   Instructor:  L. McCann
|     Due Date:  [Wed, April 23rd 2014]
|
|  Description:  [This Java Program emulates a deck of cards being shuffled in either outshuffle
					or in shuffle order. both shuffles cut the deck in half,  and interval, however,
					out shuffle preserves the orginal to card. the there are two deck constructers of the
					deck.java class, one that appends cards to each node, and one that list them  in a numerical
					value based ordering outlined in the assignment. The 'Deck' is essential the header nod of 
					the deck of cards, and within each node, is stored a Card.java object as the .data. along with sorting,
					adding, and shuffling, this  ]
|                
| Deficiencies:  [None Know Deficiencies.]
*===========================================================================*/



public class prog10 {

	
	  /*---------------------------------------------------------------------
    |  Method testNode
    |
    |  Purpose:  This method handles all test cases for the Node class and Card
    			 Class, including the testing of all the neccessary methods, including
    			 add, toString, removeLast, and of course the constructers and all the getters and setters
    			 
    |
    |  Pre-condition:  Node.java, Deck.java, and Card.java are in the same java folder.
    |
    |  Post-condition: The methods will test
    |
    |  Parameters: TEST METHOD
    |
    |  Returns: VOID
    *-------------------------------------------------------------------*/

	@Test
	public void testNode() {
		Deck temp= new Deck();
		Card Card1= new Card(1, "SPADES");
		Card Card2= new Card(2, "CLUBS");
		Card Card3= new Card(3, "DIAMONDS");
		//System.out.println(Card3.toString());
		Card Card4= new Card(4, "CLUBS");
		//System.out.println(Card4.toString());
		temp.add(Card1);
		//System.out.println(temp.toString());
		temp.add(Card2);
		System.out.println(temp.deck.getData().toString());
		System.out.println(temp.deck.getNext().toString());
		System.out.println(temp.deck.size());
		//System.out.println(temp.toString());
		temp.add(Card3);
		//System.out.println(temp.toString());
		temp.add(Card4);
		//System.out.println(temp.toString());
		temp.removeLast();
		System.out.println(temp.deck.getNext().toString());
		//System.out.println(temp.toString());
		temp.removeLast();
		System.out.println(temp.deck.size());
		//System.out.println(temp.toString());
		temp.add(Card4);
		System.out.println(temp.toString());
		temp.add(Card4);
		temp.removeLast();
		System.out.println(temp.deck.getData().toString());
		System.out.println(temp.toString());
		temp.deck.setData(Card2);
		temp.deck.setData(Card4);
		System.out.println(temp.toString());
		System.out.println(temp.toString());
		temp.deck.setNext(new Node(Card3,null));
		temp.deck.setNext(new Node(Card4,null));
		System.out.println(temp.toString());




		




		
		
	}
	
	  /*---------------------------------------------------------------------
    |  Method Deck Tester
    |
    |  Purpose:  This method handels all the testing for the deck class, for its non
    			ordered constructor
    |  Pre-condition:  ANY NON-OBVIOUS CONDITIONS THAT MUST EXIST
    |      OR BE TRUE BEFORE WE CAN EXPECT THIS METHOD TO FUNCTION
    |      CORRECTLY.
    |
    |  Post-condition: Methods will test
    
    |  Parameters:None
    |
    |  Returns:  Void
    *-------------------------------------------------------------------*/

	@Test
	public void deckTester(){
		try {
			//System.out.println("madeit");
			Deck decker= new Deck("prog10test.txt");
			//System.out.println(decker.toString());
			//System.out.println("");
			decker.outShuffle();//
			System.out.println(decker.toString());
			decker.outShuffle();//
			System.out.println(decker.toString());
			decker.inShuffle();//
			System.out.println(decker.toString());
			decker.inShuffle();//
			System.out.println(decker.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	  /*---------------------------------------------------------------------
    |  Method:string build
    |
    |  Purpose:  This method hanedls the testing for the stringbuilder version
    			of the deck constructors, which orders the cards.
    			
    |  Pre-condition: All necessary java files are in place.
    |
    |  Post-condition: The Deck constructor will be tested and displayed to the user.
    
    |  Parameters: N/A
    |
    |  Returns:  void
    *-------------------------------------------------------------------*/

	@Test
	public void stringBuildTester(){
		try{
			System.out.print("madeit again");
			StringBuilder stringer= new StringBuilder("prog10test.txt");
			
			Deck decker= new Deck(stringer);
			//System.out.println("*********");
			System.out.println(decker.toString());
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	

}
