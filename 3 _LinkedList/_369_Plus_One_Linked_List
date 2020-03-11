/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
     
        if(head == null) return null; 
        
        ListNode preHead = new ListNode(0); 
        
        preHead.next = head; 
        
        ListNode non_Nine = preHead; 
        
        while(head != null){
 
            if(head.val != 9) non_Nine = head;
            
            head = head.next; 
        }
        
        non_Nine.val++; 
        
        non_Nine = non_Nine.next; 
        
        while(non_Nine != null){
            non_Nine.val = 0; 
            non_Nine = non_Nine.next; 
        }
        
        return preHead.val != 0 ? preHead: preHead.next; 
         
    }
}
