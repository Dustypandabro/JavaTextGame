public class MyLinkedList<E>  {
  private Node<E> head, tail;
 
  public MyLinkedList() {
     head = null;
	 tail = null;
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (head == null) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (head==null) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void prepend(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
   
    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void append(E item) {
    
	Node<E> newNode = new Node<>(item); // Create a new for element e

    if (head == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = newNode; // tail now points to the last node
    }
  }
  
  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (head == null) {
      return null;
    }
    else {
      E temp = head.element;
      head = head.next;
      if (head == null) {
        tail = null;
      }
      return temp;
    }
  }

public boolean delete(E item)
   {
	   Node<E> ptr = head;
	   Node<E> prvPtr = null;
	   while (ptr!= null&& ((Comparable)ptr.element).compareTo(item)!= 0)
	   {
		   prvPtr=ptr;
		   ptr=ptr.next;
	   }
	   if (ptr == null)//item not found
		   return false;
	   if (ptr==head) // item is first element
		   head= head.next;
	   else // general case
		   prvPtr.next=ptr.next;
	   if (ptr==tail)// last element
		   tail=prvPtr;
	   return true;
   }
   
   /*public void removeItem(E item)
   {
	   if(head == null)
	   {
		   return;
		   
	   }
	   
	   if(head.data.compareTo(item) == 0)
	   {
		   head = head.next;
		   return;
		   
	   }
	   
	   Node current = head;
	   Node prev = null;
	   
	   while(current != null && current.data.compareTo(item) != 0)
	   {
		   prev = current;
		   current = current.next;
		   
	   }
	   
	   if(current == null)
	   {
		   return;
		   
	   }
	   
	   prev.next = current.next;
	   
   }*/
   
   //////////////////////////////////////////////////
   
   public MyLinkedList getUnique(MyLinkedList param)
   {
	   int i=0;
	   int j=0;
	   int k=0;
	   
	   MyLinkedList temp = new MyLinkedList();
	   
	   Node<E> fptr = head;
	   Node<E> sptr = param.head;
	   Node<E> tptr = temp.head;
	   Node<E> tptrnext = tptr.next;
	   
	   while(fptr != null)
	   {
		   i++;
		   fptr = fptr.next;
		   
	   }
	   
	   while(sptr != null)
	   {
		   j++;
		   sptr = sptr.next;
		   
	   }
	   
	   for(int n=0; n<i; n++)
	   {
		   k++;
		   temp.append(fptr.element);
		   fptr = fptr.next;
		   
	   }
	   for(int n=0; n<j; n++)
	   {
		   k++;
		   temp.append(sptr.element);
		   sptr = sptr.next;
		   
	   }
	   
	   
	   
	   for(int n=1; n<k; n++)
	   {
		   for(int m=1; m<k; m++)
		   {
			   if(((Comparable)tptr.element).compareTo(tptrnext.element) == 0)
			   {
				   temp.delete(tptr.element);
				   k--;
				   
			   }
			   
			   if(tptrnext.next != null)
			   {
				   tptrnext = tptrnext.next;
				   
			   }
			   
		   }
		   
		   if(tptr.next != null)
		   {
			   tptr = tptr.next;
			   
		   }
		   
	   }
	   
	   return temp;
   }
   
   //////////////////////////////////////////////////
 
  public String toString() {
    String result = "";

    Node<E> ptr = head;
    for (ptr= head;ptr!=null; ptr=ptr.next) 
	{
		 result = result +  ptr.element.toString();     
		 if (ptr.next != null)
             result = result + "\n"; // add commas but not to the final 1   
	}
	
    return result;
  }


  public void clear() 
  {
     head = tail = null;
  }
  
  ///////////////////////////////
  
  public boolean contains(String target)
  {
	Node<E> curr = head;
	
	while(curr != null)
	{
		if(curr.element.equals(target))
		{
			return true;
			
		}
		curr = curr.next;
		
	}
	return false;
		
  }
  
  ///////////////////////////////


  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
	  next = null;
    }
  }
   
} // end myLinkedList class
