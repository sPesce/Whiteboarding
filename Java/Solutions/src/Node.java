public class Node {
  //data of node
  private int data;
  //pointer to next node
  private Node next;

  public Node(int data){
    this.data = data;
  }

  public Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

  //getters & setters
  public int getData() {
    return this.data;
  }
  public Node getNext() {
    return this.next;
  }
  public void setNext(Node next){
    this.next = next;
  }
}
