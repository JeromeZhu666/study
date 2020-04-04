package xin.jerome.study.algorithms.leetcode.tree;

import java.util.TreeMap;

/**
 * 键值映射 106 ms 36.5 MB 战胜 57.38 % 的 java 提交记录
 * 
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。<br>
 * 如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null <br>
 * 输入: sum("ap"), 输出: 3 <br>
 * 输入: insert("app", 2), 输出: Null <br>
 * 输入: sum("ap"), 输出: 5
 *
 * @author Jerome Zhu
 * @since 2019.07.26 08:02
 */
public class LeetCode0677 {

    public static void main(String[] args) {
        LeetCode0677 leetCode0677 = new LeetCode0677();
        leetCode0677.insert("apple", 3);
        System.out.println(leetCode0677.sum("ap"));
        leetCode0677.insert("app", 2);
        System.out.println(leetCode0677.sum("ap"));
    }

    private Node root;

    /** Initialize your data structure here. */
    public LeetCode0677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {

        int res = node.val;
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    private class Node {
        public int val;
        public TreeMap<Character, Node> next;

        public Node() {
            this.val = 0;
            next = new TreeMap<>();
        }
    }
}
