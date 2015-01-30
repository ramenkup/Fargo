/*+----------------------------------------------------------------------
 ||
 ||  Class Node.java
 ||
 ||         Author:  Spencer Klinge
 ||
 ||        Purpose:  This class emulates a linked list of node objects, with each object
 					containing a 'data' reference to a card object and a 'next' to link
 					to the next node object. this class comes fully equiped with getters, setters
 					 and size for the class operations. the node object can also be displayed to 
 					 the user using the toString method.
 					 
 ||  Inherits From: N/A
 ||     Interfaces: N/A
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  N/a
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  Node(Card, Node), Node()
 
 ||  Class Methods:  N/a
 ||
 ||  Inst. Methods:  getData(), getNext(), setData(Card), setNext(Node), size(), toString()
 ++-----------------------------------------------------------------------*/


public class Node {

	public Card data;
	
	public Node	next;
	
    /*---------------------------------------------------------------------
    |  Method: Node(Card, Node)
    |
    |  Purpose: Constructs a Node object and sets the data and next variables using
    			the arguments.
    |
    |  Pre-condition: n/A
    |
    |  Post-condition: Node object will be constructed with non null instance variables
    |
    |  Parameters: Card temp, Node next; sets data and next
    
    |  Returns:  N/a
    *-------------------------------------------------------------------*/
	public Node(Card temp, Node next){
	this.data=temp;
	this.next= next;
	}
    /*---------------------------------------------------------------------
    |  Method Node()
    |
    |  Purpose:  Serves as a default constructor for the Deck class, constructing a
    			Node object, but keeping its instance variables null.
    |
    |  Pre-condition: N/A
    |
    |  Post-condition: Node object will be constructed with null instance variables.
    |
    |  Parameters: N/A
    |  Returns:  N/A
    *-------------------------------------------------------------------*/
	public Node(){
	}
	
	
	

    /*---------------------------------------------------------------------
    |  Method: getData, getNext(), setData(Card), setNext(Node)
    |
    |  Purpose: Handle the getting and setting of Node.java's data and next instance
    			variables.
    |
    |  Pre-condition: N/a
    |
    |  Post-condition: Either the get methods will return the called object to the user
    					or the setters will change the data of the calling object.
    |
    |  Parameters: setters (setData, setNext) have node arguments that are changing the object.
    |
    |  Returns:  getData and getNext() return  Card and Node objects. setters on the otherhand,
    			return void.
    *-------------------------------------------------------------------*/
	public Card getData(){
		return data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setData(Card temp){
		data= temp;
	}
	
	public void setNext(Node temp){
		next= temp;
	}
	


	
    /*---------------------------------------------------------------------
    |  Method size()
    |
    |  Purpose:  Iterates a temp varible representing this until a null is found.=
    			each time, one is added to counter, then counter is returned
    |
    |  Pre-condition: n/A
    |
    |  Post-condition: size of the list will be returned.
    |
    |  Parameters: N/A
    |
    |  Returns: the count objects in the linked list.
    *-------------------------------------------------------------------*/
	public int size(){
		int counter= 0;
		Node temp= this;
		while(temp != null){
			counter++;
			temp= temp.next;
		}
		return counter;
	}
    /*---------------------------------------------------------------------
    |  Method toString()
    |
    |  Purpose: displays the linked list in a vertical string representation.
    			the suit is represented by the first letter of the name of the suit,
    			and the rank is either represented as a number of the first letter of the
    			royalty card(Jack, King, Queen).
    |
    |  Pre-condition: N/A
    |
    |  Post-condition: returns a string version of the Node.
    |
    |  Parameters:N/A
    	
    	
      returns: void
    *-------------------------------------------------------------------*/
	public String toString(){
		String returner= "";
		Node temp= this;
		while(temp != null){
			returner+=temp.data.toString() + "\n";
			temp= temp.next;
		}
		return returner;
	}
	
/*	public Node[] toArray(){
		Node[] temp= new Node[this.size()];
		Node iterator= this;
		for(int i=0; i < temp.length; i++){
			if(iterator != null){
			temp[i]= iterator.getData();
			iterator= this.next;
			}
		}
		return temp;
	}*/
}
