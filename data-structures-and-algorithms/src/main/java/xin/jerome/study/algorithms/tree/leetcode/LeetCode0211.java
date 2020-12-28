package xin.jerome.study.algorithms.tree.leetcode;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 添加与搜索单词 - 数据结构设计 231 ms 78.9 MB 战胜 8.02 % 的 java 提交记录
 * 
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word) <br>
 * boolean search(word) <br>
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例: <br>
 * addWord("bad") <br>
 * addWord("dad") <br>
 * addWord("mad") <br>
 * search("pad") -> false <br>
 * search("bad") -> true <br>
 * search(".ad") -> true <br>
 * search("b..") -> true
 *
 * @author Jerome Zhu
 * @since 2019.07.15 20:34
 */
public class LeetCode0211 {

    public static void main(String[] args) {
        LeetCode0211 leetCode0211 = new LeetCode0211();
        leetCode0211.addWord("bad");
        leetCode0211.addWord("dad");
        leetCode0211.addWord("mad");
        System.out.println(leetCode0211.search("pad"));
        System.out.println(leetCode0211.search("bad"));
        System.out.println(leetCode0211.search(".ad"));
        System.out.println(leetCode0211.search("b.."));
    }

    private final char COMMON_CHAR = '.';

    private Node node;

    /** Initialize your data structure here. */
    public LeetCode0211() {
        node = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(node, word, 0);
    }

    /** 从当前节点匹配单词word */
    private boolean search(Node cur, String word, int index) {
        // 已经是最后一个字符了,只需要看看到当前节点是否是一个单词
        if (index == word.length()) {
            return cur.isWord;
        }

        Character c = word.charAt(index);
        if (COMMON_CHAR == c) {
            Set<Character> characters = cur.next.keySet();
            for (Character character : characters) {
                if (search(cur.next.get(character), word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!cur.next.containsKey(c)) {
                return false;
            }
            return search(cur.next.get(c), word, index + 1);
        }
    }

    private class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            isWord = false;
            next = new TreeMap<>();
        }
    }
}
