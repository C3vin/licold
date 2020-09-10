class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        
        StringBuilder sb = new StringBuilder();
        
        _serialize(root, sb);   System.out.println(sb.toString()); return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        
        if (data == null) return null;
        
        return _deserialize(data.toCharArray(), new int[] {0});
    }
 
    private void _serialize(Node root, StringBuilder sb) {
        
        if (root == null) return;
        
        sb.append("[").append(root.val);
        
        if (root.children != null) {
            
            for (Node child: root.children) {  _serialize(child, sb); }
        }
        sb.append("]");
    }
    
    // 解压 --> p存储index
    private Node _deserialize(char[] s, int[] p) {  // 为何是 int[] p 而不是 int p ???
        
        // 边界条件，如果p[0]越界，那么返回空
        if (p[0] == s.length) return null;
        
        // 设置初始值 --> we need to plus one because we have "[" at the beginning of the string 
        int j = p[0] + 1;
         
        int val = 0;  // 初始化root的值 
        
        //     只要没有越界     并且s[j]是一个数字   --> 这里在还原val
        while (j < s.length && s[j] >= '0' && s[j] <= '9') {
            
            // 获取这个数字，因为可能是几位数比如145，而不是个位数
            val = val * 10 + (s[j] - '0');
            
            j++;
        }
     
        // 制造节点 --> using the previously rebuilt val
        Node root = new Node(val, new ArrayList<>());
         
        p[0] = j;  // 这时候j已经指向下一个"[" 或者 "]"
         
        // 给root加孩子  --> 这里自己画一画，就是每次制造节点，再给节点添加孩子。
        while (s[p[0]] == '[') {
            root.children.add(_deserialize(s, p));
        }
        
        p[0] += 1;
        return root;
    }
}