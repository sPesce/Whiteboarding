import java.util.Hashtable;
//what node class is being imported?
public class LoopInspector {

  public int loopSize(Node node) {
    Hashtable<Node, Integer> nodeMap = new Hashtable<>();    
    
    Node current = node;

    for(int i = 0; !nodeMap.containsKey(current) ; i++)
    {
      nodeMap.put(current,i);
      current = current.getNext();
    } 

    return nodeMap.size() - nodeMap.get(current);
  }
}