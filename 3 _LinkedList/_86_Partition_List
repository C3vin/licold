/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
         
                /** Create two pointers */
                ListNode before_head = new ListNode(0);    ListNode before = before_head;
                ListNode after_head  = new ListNode(0);    ListNode after = after_head;

                /** Loop Begins! Check every Note */
                while (head != null) {

                    /** if small than x */
                    if (head.val < x) {
                        before.next = head;
                        before = before.next;
                    /** if larger than x */
                    } else {
                        after.next = head;
                        after = after.next;
                    }

                    /** head 前進 */
                    head = head.next;
                }

                /** end with null */
                after.next = null;

                /** Combine two Linked List */
                before.next = after_head.next;

                return before_head.next;
            }
        
    
}
