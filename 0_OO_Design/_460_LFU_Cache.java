public class LFUCache {
    
    /** 单个Node */
    class Node {
        
        int key, val, cnt;
        
        Node prev, next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }
     
    /** 双向链表 */
    class DLList {
        
        Node head, tail;
        
        int size;
        
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        
        void addToHead(Node node) {
            
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
            
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }
    
    int capacity, size, min;
    
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> countMap;
    
    /* 初始化 */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    /* get */
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }
    
    /* put */
    public void put(int key, int value) {
        
        if (capacity == 0) return;
        
        Node node;
        
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            
            /** 如果满了就删除最低频的，最旧的一个，最后一个 */
            if (size == capacity) {
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            
            size++;
            
            /* 新的最低频 */
            min = 1;
            
            /* 假如频率为1的list */
            DLList newList = countMap.getOrDefault(1, new DLList());
            
            /* 假如这个list */
            newList.addToHead(node);
            
            /* 添加countMap */
            countMap.put(node.cnt, newList);
        }
    }
    
    private void update(Node node) {
        
        /** 找到旧的频率list */
        DLList oldList = countMap.get(node.cnt);
        
        /*  从这个频率list中移除*/
        oldList.remove(node);
        
        /*  如果这是最低频，也是唯一一个低频，那么就min加一 */
        if (node.cnt == min && oldList.size == 0) min++; 
        
        /*  频率加一，因为被update */
        node.cnt++;
        
        /* 找到这个新频率的List */
        DLList newList = countMap.getOrDefault(node.cnt, new DLList());
        
        /* 假如这个新List */
        newList.addToHead(node);
        
        /* 更新countMap */
        countMap.put(node.cnt, newList);
    }
}