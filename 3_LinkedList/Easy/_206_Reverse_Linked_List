class Solution {
    
    public ListNode reverseList(ListNode head) {
        
        ListNode pre = null; 
        
        ListNode curr = head; 
        
        while(curr != null){
            
            ListNode tmp = curr.next; 
            
            curr.next = pre; 
            
            pre = curr; 
            
            curr = tmp; 
              

         }

         return pre; 
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
