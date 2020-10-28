import java.util.Hashtable;

import org.w3c.dom.Node;


public class LoopInspector {

  public int loopSize(Node node) {
    Hashtable<Node, Integer> nodeMap = new Hashtable<>();
    int count = 0;
    Node current = node;
    while(!nodeMap.containsKey(current))
    {
      count++;
      
      nodeMap.put(current,count);
      current = current.getNext();
    }
    return (nodeMap.size() - nodeMap.get(current) + 1);
  }

}