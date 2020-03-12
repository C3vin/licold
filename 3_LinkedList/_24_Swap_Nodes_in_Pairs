class Solution {
    
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head; 
        
        ListNode M = head.next; 
        
        head.next = swapPairs(head.next.next); 
        
        M.next = head; 
        
        return M;
         
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
