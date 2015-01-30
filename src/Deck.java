import java.util.*;
import java.io.*;

/*+----------------------------------------------------------------------
 ||
 ||  Class Deck
 ||
 ||         Author:  Spencer Klinge
 ||
 ||        Purpose:  The Deck class, is a node representation of card objects, With consturctors
 					that can read a file, given a file name, and compute each cards rank and suit
 					it then constructs the deck object, which can be shuffled, appened to, remove the last of, or inserted
 					into in a sorted fashing using sortInsert. This class also has a toString which can 
 					output the whole deck's contents in string format.
 ||  Inherits From:  N/A
 ||     Interfaces:  N/a
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  N/A
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors: Deck(), Deck(String), Deck(StringBuilder)
 
 ||  Class Methods:  N/A
 
 ||  Inst. Methods:  removeLast(), outShuffle(), add(Card), sortInsert(Card), inShuffle(), toString()
 ++-----------------------------------------------------------------------*/

public class Deck {
    Node deck;
    File fileRef;
    FileReader fileStream;
    BufferedReader textStream;
    String aLine;
    
    String Clubs= new String("CLUBS");
    String Hearts= new String("HEARTS");
    String Diamonds= new String ("DIAMONDS");
    String Spades= new String ("SPADES");
    
    

    /*---------------------------------------------------------------------
     |  Method Deck()
     |
     |  Purpose:  This method is a default constructor for the Deck.java class.
     |  Pre-condition:  N/A
     |
     |  Post-condition: Deck object will be constucted to null.
     |  Parameters:N/A
     
     |  Returns:  Nothing, constructor.
     *-------------------------------------------------------------------*/

    public Deck(){
    	deck=null;
    }
    

    /*---------------------------------------------------------------------
     |  Method Deck(String)
     |
     |  Purpose:  This method also constructs a deck object read from a file,
     				Given a string. please note that this use a string to distinguish
     				from deck(StringBuilder) which builds and sorts the deck, while this 
     				constructor only builds.
     |  Pre-condition:  N/A
     |  Post-condition: A deck object will be filled.
     
     |  Parameters:String- name of the file
     |
     |  Returns:  Nothing, constructor
     *-------------------------------------------------------------------*/

    public Deck(String fileName) throws FileNotFoundException{
    	fileRef= new File(fileName);
    	fileStream = new FileReader(fileRef);   // Throws the exception
        textStream = new BufferedReader(fileStream);
        int counter=0;
        
        

        try {
        	deck= new Node();
            aLine = textStream.readLine();
            while (aLine != null) {
            	aLine= aLine.trim();
            	aLine= aLine.toUpperCase();
            	String rank= aLine.substring(0, aLine.indexOf(" "));
            	String suit= aLine.substring(aLine.lastIndexOf(" ")+1, aLine.length());
            	if(Integer.parseInt(rank) > 0 && Integer.parseInt(rank) <= 13 && suit.equals(Spades)|| suit.equals(Hearts) 
            			|| suit.equals(Clubs) || suit.equals(Diamonds)){
            		Card tempCard= new Card(Integer.parseInt(rank), suit);
            		add(tempCard);
            		counter++;
            		aLine= textStream.readLine();
            		
            	}
            	else{ aLine= textStream.readLine();
            	
            	}
            }
            	if(counter % 2 != 0){
            		removeLast();
            		counter--;
            	}
            	
   
            

        } catch (IOException e) {

            System.out.println("I/O ERROR:  Something went wrong with the "
                             + "reading of the text file.\nHere's what "
                             + "I can tell you:");
            System.out.println("  The Error: " + e.getClass().getName());
            String mesg = e.getMessage();
            if (mesg == null) {
                System.out.println("The message:  None.");
            } else {
                System.out.println("The message: " + mesg);
            }
            System.out.println("The stack trace:");
            e.printStackTrace();

        } 

        System.out.println("-----------------------------------------");

        try {

            textStream.close();

        } catch (IOException e) {

            System.out.println("I/O ERROR:  Something went wrong with the "
                             + "closing of the text stream.\nHere's what "
                             + "I can tell you:");
            System.out.println("  The Error: " + e.getClass().getName());
            String mesg = e.getMessage();
            if (mesg == null) {
                System.out.println("The message:  None.");
            } else {
                System.out.println("The message: " + mesg);
            }
            System.out.println("The stack trace:");
            e.printStackTrace();

        } 

        System.out.println("Done!");

    }

    /*---------------------------------------------------------------------
     |  Method Deck(StringBuilder)
     |
     |  Purpose: This Deck Constructor takes a string builder argument to
     			distinguish itself from the other constutors. along with building
     			the deck, this method calls sortInsert instead of add to put the deck
     			in the order outlined by the assignment.
     			
     |  Pre-condition:  N/A
     |
     |  Post-condition: An ordered deck object will be constructed.
     |
     |  Parameters: StringBuilder- the name of the file being read from.
     				
     |
     |  Returns:  N/A
     *-------------------------------------------------------------------*/

    public Deck(StringBuilder temp) throws FileNotFoundException{
    	String fileName= temp.toString();
    	fileRef= new File(fileName);
    	fileStream = new FileReader(fileRef);   // Throws the exception
        textStream = new BufferedReader(fileStream);
        int counter=0;
        deck= new Node();
        
        

        try {

            aLine = textStream.readLine();
            while (aLine != null) {
            	aLine= aLine.trim();
            	aLine= aLine.toUpperCase();
            	String rank= aLine.substring(0, aLine.indexOf(" "));
            	String suit= aLine.substring(aLine.lastIndexOf(" ")+1, aLine.length());
            	if(Integer.parseInt(rank) > 0 && Integer.parseInt(rank) <= 13 && suit.equals(Spades)|| suit.equals(Hearts) 
            			|| suit.equals(Clubs) || suit.equals(Diamonds) ){
            		Card tempCard= new Card(Integer.parseInt(rank), suit);
            		//Node tempNode= null;
            		//deck.add(new Node(tempCard, tempNode));
            		sortInsert(tempCard);
            		//System.out.println("Adding card!");

            		//System.out.println(deck.toString());
            		
            		counter++;
            	}
            	aLine= textStream.readLine();
            }
    }
            	catch (IOException e) {

                    System.out.println("I/O ERROR:  Something went wrong with the "
                                     + "reading of the text file.\nHere's what "
                                     + "I can tell you:");
                    System.out.println("  The Error: " + e.getClass().getName());
                    String mesg = e.getMessage();
                    if (mesg == null) {
                        System.out.println("The message:  None.");
                    } else {
                        System.out.println("The message: " + mesg);
                    }
                    System.out.println("The stack trace:");
                    e.printStackTrace();
            	}
       // Collections.sort(deck);
        
                } 

    /*---------------------------------------------------------------------
     |  Method removeLast()
     |
     |  Purpose:  This method iterates to the end of the deck and find the last element,
     				in it, if there is one at all. it then removes this card by setting it to null.
     				
     |  Pre-condition: Deck object has to be constructed.
     |
     |  Post-condition:The deck object will be modified to have the last card removed.
     
     |  Parameters:N/a
     |
     |  Returns:  N/A
     *-------------------------------------------------------------------*/

	public void removeLast(){
		Node temp= deck;
		if(temp == null)
			return;
		if(temp.next == null)
			temp=null;
		while(temp.next.next!= null){//changed from .next to .next.next
			temp=temp.next; //changed fromt his.next to temp.next
		}
		temp.next=null;
	}
	

    /*---------------------------------------------------------------------
     |  Method outShuffle()
     |
     |  Purpose: This method makes two temp head objects. it then takes one of those
     			objects and iterates to the  middle of the deck. it then reorders the deck by shuffling back and 
     			forth between the two by putting it into an empty returner. This version of shuffle maintains
     			the orginal first card
     			
     |  Pre-condition: Deck object has been constructed.
     |
     |  Post-condition: The deck will be out shuffled.
     |
     |  Parameters:N/A
     |
     |  Returns:  A shuffled version of the deck
     *-------------------------------------------------------------------*/

    
    public void outShuffle(){
    	Node tempList= deck;
    	Node tempMid= deck;
    	Node returner= new Node();
    	Node iterator= returner;
    	if(deck.size() == 0)
    		return;
    	else{
    		int counter= 0;
    		while(counter < deck.size() / 2){
    			tempMid= tempMid.next;
    			counter++;
    		}
    		while(tempMid != null && tempList != null){
    			if(iterator.data == null)
    				iterator.data= tempList.data;
    			else{
    			iterator.next= new Node(tempList.data,null);
    			iterator= iterator.next;
    			}
    			iterator.next= new Node(tempMid.data,null);
    			iterator = iterator.next;
    			tempList= tempList.next;
    			tempMid= tempMid.next;
    			counter--;
    		}
    		
    		
    			
    	}
    	deck= returner;

    }


    /*---------------------------------------------------------------------
     |  Method add()
     |
     |  Purpose:  This method iterates to the end of the deck, and then
     			appends its argument card onto the end of the list.
     |
     |  Pre-condition:  Deck should be constructed.
     |
     |  Post-condition: Deck will updated to have  an appended card on it.
     |
     |  Parameters: c- card being appended to the deck.
     |
     |  Returns:  void
     *-------------------------------------------------------------------*/

	public void add(Card c){
		if(deck == null){
			deck= new Node(c,null);
		}
		else
		if(deck.data == null){
			deck.data = c;
		}
		else{
		Node temp= deck;
		while(temp.next != null){
			temp =temp.next;//changed from this.next ot temp.next
		}
		temp.next= new Node(c, null);//changed from null to temp.next
		}
		
	}

    /*---------------------------------------------------------------------
     |  Method: sortInsert(Card c)
     |
     |  Purpose:  This method is called by the Deck(StingBuilder) constructor,
     				and inserts each card into the deck according to its ordering,
     				relative to the cards that have been inserted already.
     				
     |  Pre-condition: Deck has been construced.
     |
     |  Post-condition: Card will properly instead in right location.
     
     |  Parameters:c- card being insterted.
     
     |  Returns: void.
     *-------------------------------------------------------------------*/

	public void sortInsert(Card c){
		Node temp= deck;
		
		if(temp== null){
			temp= new Node(c,null);
			return;
			}
		
		if(temp.data == null && temp.next == null ){//checks to see if the list is empty
			temp.data=c;
			return;
		}

		
		while(temp != null && c.compareTo(temp.data) > 0){//changed to temp.next.data
			temp = temp.next;
		}
		
		//if(c.compareTo(temp.data) < 0){//checks see if c is less than first
			//c.compareTo(this.data);
			Node tempNode= new Node(temp.data, temp.next);//changed from this to temp EXACT SAME NODE
			temp.data=c;
			temp.next=tempNode;
			return;
		//}


	}
	  /*---------------------------------------------------------------------
    |  Method outShuffle()
    |
    |  Purpose: This method makes two temp head objects. it then takes one of those
    			objects and iterates to the  middle of the deck. it then reorders the deck by shuffling back and 
    			forth between the two by putting it into an empty returner. This version of shuffle maintains
    			does puts the middle temps head on top instead of maintaining the orginial top card.
    			
    |  Pre-condition: Deck object has been constructed.
    |
    |  Post-condition: The deck will be in shuffled.
    |
    |  Parameters:N/A
    |
    |  Returns:  A shuffled version of the deck.
    *-------------------------------------------------------------------*/
  
    public void inShuffle(){
    	Node tempList= deck;
    	Node tempMid= deck;
    	Node returner= new Node();
    	Node iterator= returner;
    	if(deck.size() == 0)
    		return;
    	else{
    		int counter= 0;
    		while(counter < deck.size() / 2){
    			tempMid= tempMid.next;
    			counter++;
    		}
    		while(tempMid != null && tempList != null){
    			if(iterator.data == null)
    				iterator.data= tempMid.data;
    			else{
    			iterator.next= new Node(tempMid.data,null);
    			iterator= iterator.next;
    			}
    			iterator.next= new Node(tempList.data,null);
    			iterator = iterator.next;
    			tempList= tempList.next;
    			tempMid= tempMid.next;
    			counter--;
    		}
    		
    		
    			
    	}
    	deck= returner;

    }

    /*---------------------------------------------------------------------
     |  Method toString()
     |
     |  Purpose:  Iterates through the deck, and calls the Card.java's version
     				of to string, loading all the results into a returner string.
     |
     |  Pre-condition:  Deck contatins cards.
     |
     |  Post-condition: deck will be returned as a string.
     |
     |  Parameters: N/a
     |
     |  Returns:  String 
     *-------------------------------------------------------------------*/

    public String toString(){
    	String returner="";
    	Node temp= deck;
    	while(temp!= null){
    		returner+= temp.data.toString() + "\n";
    		temp= temp.next;
    	}
    	return returner;
    }
    
          
    }
    


