class Solution {
    
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null) return ; 
        
        ListNode A = head; 
        ListNode B = findMid(head); 
        
        B = reverseList(B); 
        
        while( B != null){              //这个可以心里重复演算一下
                                        //上下两排，对齐演算
            
            ListNode tmp_A = A.next; 
            ListNode tmp_B = B.next;
            
            A.next = B;                 
            
            B.next = tmp_A; 
            
            A = tmp_A; 
            
            B = tmp_B; 
            
        }
        return ; 
    }
    
    private ListNode findMid(ListNode head){
 
        ListNode fast = head.next; 
        ListNode slow = head; 
        
        while(fast!=null && fast.next!=null){
            
            fast = fast.next.next; 
            slow = slow.next; 
        }
 
        ListNode halfHead = slow.next;
        slow.next = null;
        
        return halfHead;  
    }
    
    private ListNode reverseList(ListNode head){
        
        ListNode pre = null; 
        
        ListNode curr = head; 
        
        while(curr != null){  // 右左右右
            
            ListNode tmp = curr.next; 
            
            curr.next = pre; 
            pre = curr; 
            
            curr = tmp;  
        }
        
        return pre; 
    }
}
 

