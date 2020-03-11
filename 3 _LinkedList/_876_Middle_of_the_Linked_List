/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while(fast != null && fast.next != null){
            
            fast = fast.next.next; 
            slow = slow.next; 
            
        }
        
        if(fast!=null){
            return slow.next; 
        } else return slow;
         
    }
}
