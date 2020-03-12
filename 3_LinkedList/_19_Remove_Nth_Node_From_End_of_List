class Solution {
    
        public ListNode removeNthFromEnd(ListNode head, int n) {

            if(head == null) return head; 

            ListNode DummyHead = new ListNode(-1); 

            DummyHead.next = head; 

            ListNode a = DummyHead;
            ListNode b = DummyHead;

            while(n>0){
                n--; 
                a = a.next; 
            }

            while(a!=null && a.next !=null){
                a = a.next; 
                b = b.next; 
            }

            b.next = b.next.next; 

            return DummyHead.next; 

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
