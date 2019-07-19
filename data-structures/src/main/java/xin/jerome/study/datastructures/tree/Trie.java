package xin.jerome.study.datastructures.tree;

import java.util.TreeMap;

/**
 * 字典树(前缀树)
 * 
 * 字典树的定义:是一种有序树,用于保存关联数组,其中的键通常是字符串.
 *
 * @author Jerome Zhu
 * @since 2019.07.13 22:44
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 向字典树中添加一个元素
     * 
     * @param word
     *            待添加的元素
     */
    public void add(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word is null.");
        }

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查看字典树中是否包含 {@code word} 这个单词
     * 
     * @param word
     *            待验证的单词
     * @return 如果包含返回 {@code true} ,否则返回 {@code false}
     */
    public boolean contains(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word is null.");
        }

        Node cur = root;
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
     * 查看字典树中是否包含 {@code prefix} 这个前缀
     *
     * @param prefix
     *            待验证的前缀
     * @return 如果包含返回 {@code true} ,否则返回 {@code false}
     */
    public boolean isPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix is null.");
        }
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 查看当前字典树是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取当前字典树存储了多少个单词
     */
    public int size() {
        return size;
    }

    /**
     * 字典树的节点
     */
    private class Node {
        // 当前节点是否是一个单词
        boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }
}
