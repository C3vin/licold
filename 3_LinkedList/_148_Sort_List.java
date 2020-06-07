class Solution {
    
       public ListNode sortList(ListNode head) {
 
            /** Check corner case**/
            if (head == null || head.next == null) return head;

            /** 1. Define slow & fast pointer */
            ListNode slow = head;
            ListNode fast = head.next;

            /** 2. Let the pointer stop at correct place */
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            /** 3. Get header for 2nd half */
            ListNode mid = slow.next;
            slow.next = null;

            /** 4. Start Merge **/
            return merge(sortList(head), sortList(mid));
        }

        /** 4. Start Merge **/
        public ListNode merge(ListNode l1, ListNode l2) {
 
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
 
            while (l1 != null && l2 != null) {

                if(l1.val > l2.val) {
                    tail.next = l2;
                    l2 = l2.next;
                } else {
                    tail.next = l1;
                    l1 = l1.next;
                }

                tail = tail.next;
            }
 
            tail.next = (l1 == null) ? l2 : l1;
 
            return dummy.next;

        }
}
 