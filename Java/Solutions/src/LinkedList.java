public class LinkedList {
  
  //the first node
  private Node head;

  public LinkedList() {
    this.head = null;
  }

  public void push(int data) {
    Node newNode = new Node(data);
    
    if(head == null)
      head = newNode;//set head to the new node
    else//nonEmpty LL
    {  
      Node current = this.head;//start at front of LL
      
      while(current.getNext() != null)
      {
        current = current.getNext();
      }
      current.setNext(newNode);//put new node on end of list
    }
  }

}
