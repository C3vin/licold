class WordDictionary {
 
            public class TrieNode {
                public TrieNode[] children = new TrieNode[26];  /** 1. 定義 TrieNode 數據結構 */
                public boolean item = false;
            }

            private TrieNode root = new TrieNode();  /** 2. 製造 root */
 
            public void addWord(String word) {

                TrieNode node = root;  /** ～1. 初始化 node */

                for (char c : word.toCharArray()) {   /** ～2 遍歷word字母 */

                    /** ～2.1 如果 該位置的children是null, 就加入新的TrieNode */
                    if (node.children[c - 'a'] == null)    node.children[c - 'a'] = new TrieNode();

                    /** ~2.2 更新 node */
                    node = node.children[c - 'a'];
                }

                /** ～3 把這個詞加到最後面 */
                node.item = true;
            }
 
            public boolean search(String word) {  /** 4. 子函數search */

                return match(word.toCharArray(), 0, root);
            }
 
            private boolean match(char[] chs, int k, TrieNode node) {  /** 5. 子函數match */

                /** ～1 如果找到 "" 空，那麼就返回false */
                if (k == chs.length) return node.item;
 
                if (chs[k] != '.') {   /** ～2 如果不等於 "." 那麼就 */

                    return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
                    
                } else {  /** ～2 如果等於 "." 就  */

                    /** ～3 遍歷孩子 */
                    for (int i = 0; i < node.children.length; i++) {

                        /** ～4  */
                        if (node.children[i] != null) {

                            if (match(chs, k + 1, node.children[i])) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
}

