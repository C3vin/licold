/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
 
    public boolean isPalindrome(ListNode head) {
 
         if(head == null) return true; 
        
         if(head.next == null) return true; 
       
        ListNode A = head; 
        ListNode B = headOfSecondHalf(head); 
        
        B = reverse(B); 
             
        
        while(B!=null && A!=null){
            
            if(A.val != B.val ) return false; 
            
            B = B.next; 
            A = A.next;
        
        }
        
        return true;  
        
    }
        
    
    public ListNode headOfSecondHalf(ListNode head){
        
               
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while(fast != null && fast.next != null){
            
            fast = fast.next.next; 
            
            slow = slow.next; 
            
        }
        
        return slow.next; 
         
    }
    
    public ListNode reverse (ListNode head) {
         
        ListNode pre = null; 
        
        ListNode curr = head; 
        
        while(curr!=null){
            
            ListNode tmp = curr.next; 
            
            curr.next = pre; 
            
            pre = curr; 
            
            curr = tmp; 
            
        }
        
        return pre; 
        
    }     
}
