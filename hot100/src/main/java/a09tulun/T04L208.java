package a09tulun;

public class T04L208 {
    static class Trie{
        public Trie[] child;
        public boolean isEnd;
        public Trie(){
            child = new Trie[26];
            isEnd = false;
        }

        public void insert(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(node.child[c - 'a'] == null){
                    node.child[c - 'a'] = new Trie();
                }
                node = node.child[c - 'a'];
            }
            node.isEnd = true;
        }


        public  boolean search(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(node.child[c - 'a'] == null){
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix){
            Trie node = this;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(node.child[c - 'a'] == null){
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return true;
        }
    }
}
