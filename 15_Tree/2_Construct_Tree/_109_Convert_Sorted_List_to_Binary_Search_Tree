class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
   
        if(head == null) return null; 
        
        ListNode mid = this.findMid(head);
        
        TreeNode T = new TreeNode(mid.val); 
        
        
        if(head == mid) return T; 
        
        
        T.left = this.sortedListToBST(head); 
        T.right = this.sortedListToBST(mid.next); 
        
        return T; 
    }
    
    public ListNode findMid(ListNode node){
        
        ListNode pre = null; 
        ListNode slow_Ptr = node; 
        ListNode fast_Ptr = node; 
        
        while(fast_Ptr!=null && fast_Ptr.next != null){
            
            pre = slow_Ptr; 
            slow_Ptr = slow_Ptr.next; 
            fast_Ptr = fast_Ptr.next.next; 
            
        } 
        
        if(pre != null)
            {        
                pre.next = null;
            } 
        
        return slow_Ptr; 
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
