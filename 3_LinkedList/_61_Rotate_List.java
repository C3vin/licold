/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
           public ListNode rotateRight(ListNode head, int k) {

                if(head == null || head.next == null) return head;

                ListNode tool = head;

                int C = 1;

                while(tool.next !=null ){
                    tool = tool.next;
                    C++;
                }

                tool.next = head;

                ListNode newTail = new ListNode(-1);

                newTail = head;

                int moveCount = C - k%C -1 ;

                for(int i = 1; i<=moveCount; i++){
                    newTail = newTail.next;
                }

                ListNode newHead = newTail.next;

                newTail.next = null;

                return newHead;


            }

}
