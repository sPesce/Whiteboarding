/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {   
  //result/returned linked list
  let firstNode;
  let current;
  let isFirst = true;//flag, is this the head?
  
  //value is 10^index place (reverse decimal)
  // in the example of 18, current will be 8, and 1 will be added to current.next
  let result = [0,0]// ex 18 >> [8,1]
  
  while(!!l1 || !!l1 || !!result[1])
  {   
      //add both current lls and the tens place from result (which is now 1s place)
      const sum = (!l1 ? 0 : l1.val) + (!l2 ? 0 : l2.val) + result[1];
      result = (sum > 9) ? [sum - 10,1] : [sum,0];
      const newNode = new ListNode(result[0]);
      
      if(isFirst)
      {
          firstNode = newNode;
          isFirst = false;
      }
      else
          current.next = newNode;
      
      //advance sum and both argument lists by one step
      current = newNode;
      l1 = (!l1 || !l1.next) ? null : l1.next
      l2 = (!l2 || !l2.next) ? null : l2.next        
  }
  return firstNode;    
};
