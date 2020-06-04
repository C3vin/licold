class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        if(l1==null) return l2;  
        else if(l2==null) return l1; 
      
        Stack<Integer> s1 = new Stack<>(); 
        Stack<Integer> s2 = new Stack<>(); 
        
        while(l1!=null){
            s1.add(l1.val); 
            l1 = l1.next; 
        }
        
        while(l2!=null){
            s2.add(l2.val); 
            l2 = l2.next; 
        }
        
        ListNode cur = new ListNode(0); 
        
        int sum = 0;     int carry = 0;    int num = 0; 
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            if( !s1.isEmpty() ) sum = sum + s1.pop();
            if( !s2.isEmpty() ) sum = sum + s2.pop();
                         
            cur.val = sum %10; 
            
            ListNode head = new ListNode(sum/10); 
            
            head.next = cur; 
            
            cur = head; 
            
            sum = sum/10;
        }
         
        return cur.val == 0? cur.next:cur; 
    }
}
