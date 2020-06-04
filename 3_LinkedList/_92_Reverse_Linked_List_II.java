/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      
        
        
      
            /** 1. 邊界條件  **/
            if(head == null) return head;

            /** 2. 製造Dummy   **/
            ListNode dummy = new ListNode(0);

            /** 3. 讓Dummy 指向head  **/
            dummy.next = head;

            /** 4. 讓 mNode, nNode 站在 head 位置  **/
            ListNode mNode = head;
            ListNode nNode = head;

            /** 5. 讓 preM 站在 Dummy 位置  **/
            ListNode preM = dummy;

            /** 6. 移動 mNode 到正確位置  **/
            for(int i = 1; i < m; i++){
                preM = mNode;
                mNode = mNode.next;
            }

            /** 7. 移動 nNode 到正確位置  **/
            for(int i = 1; i < n; i++) {
                nNode = nNode.next;
            }

            /** 8. 把最頭的，查到nNode後面  **/
            while (mNode != nNode) {

                /** ~更新 preM 的槍  **/
                preM.next = mNode.next;

                /** ~讓mNode指向，nNode的槍口  **/
                mNode.next = nNode.next;

                /** ~nMode槍口指向 mNode，這樣 --> mNode變成 nNode 直接下屬 **/
                nNode.next = mNode;

                /** ~讓mNode移到下一位 **/
                mNode = preM.next;
            }

            /** 草稿
             *              p   m                       n
             *          A   B   C   D   E   F   G   H   I   J   K
             *
             *              p   m                       n
             *          A   B   C   D   E   F   G   H   I   J   K
             *
             *
             *
             * **/
            return dummy.next;  
   
    }
}
