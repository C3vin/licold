class MyHashSet {
     
    List<Integer>[] lists;  /* 注意: 这里不是LinkedList，这里是LinkedList的数组*/
    
    int numBuckets = 1107;
 
    public MyHashSet() {
        lists = new LinkedList[numBuckets];
    }
    
    public int hashing(int key)  
    {
        return key%numBuckets;
    }
 
    public void add(int key) {
        
        int i = hashing(key);
        
        if(lists[i]==null) lists[i] = new LinkedList<>();
        
        if(lists[i].indexOf(key)==-1) lists[i].add(key);   
    }
 
    public void remove(int key) {
        
        int i = hashing(key);
        
        if(lists[i]==null) return;
        
        if(lists[i].indexOf(key)!=-1) lists[i].remove(lists[i].indexOf(key));
    }
 
    public boolean contains(int key) {
        
        int i = hashing(key);
        
        if(lists[i]==null||lists[i].indexOf(key)==-1)
            return false;
        else
            return true;
    }
}
 