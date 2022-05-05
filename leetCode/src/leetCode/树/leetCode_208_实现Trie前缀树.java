package leetCode.树;

public class leetCode_208_实现Trie前缀树 {
    public static void main(String[] args) {

    }

    class Trie {

        class TrieNode {
        //标记单词是否存在
            boolean end;
            TrieNode[] tns = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                //如果不存在这个字母 ，就新创建一个
                if (p.tns[ch] == null){
                    p.tns[ch] = new TrieNode();
                }
                //存在就把指针指向下一个位置
                p=p.tns[ch];
            }
            p.end=true;

        }

        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i)-'a';
                if (p.tns[ch]==null){
                    return false;
                }
                p=p.tns[ch];
            }
            return p.end;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for(int i = 0; i < prefix.length(); i++) {
                int u = prefix.charAt(i) - 'a';
                if (p.tns[u] == null) {
                    return false;
                }
                p = p.tns[u];
            }
            return true;
        }
    }
}
