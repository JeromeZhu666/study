package xin.jerome.study.datastructures.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 Trie (前缀树) 137 ms 51 MB 战胜 93.52 % 的 java 提交记录
 * 
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 <br>
 * 示例: Trie trie = new Trie(); <br>
 * trie.insert("apple"); <br>
 * trie.search("apple"); // 返回 true <br>
 * trie.search("app"); // 返回 false <br>
 * trie.startsWith("app"); // 返回 true <br>
 * trie.insert("app"); <br>
 * trie.search("app"); // 返回 true
 *
 * @author Jerome Zhu
 * @since 2019.07.15 20:10
 */
public class LeetCode0208 {

    private Node node;

    /** Initialize your data structure here. */
    public LeetCode0208() {
        node = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = node;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    private class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            isWord = false;
            next = new HashMap<>();
        }
    }
}
