class Solution {
    public ListNode oddEvenList(ListNode head) {
       
        if(head == null) return null; 
        
        ListNode dummyHead = new ListNode(-1); 
        
        ListNode A = head; 
        ListNode B = head.next; 
        
        ListNode M = head.next; 
        
        while(B != null && B.next != null){
            A.next = B.next; 
            A = A.next; 
            B.next = A.next; 
            B = B.next; 
        }
        
        A.next = M; 
        
        return head; 
        
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
