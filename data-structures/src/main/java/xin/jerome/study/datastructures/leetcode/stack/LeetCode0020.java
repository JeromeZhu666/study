package xin.jerome.study.datastructures.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号:
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：
 * <li>左括号必须用相同类型的右括号闭合。
 * <li>左括号必须以正确的顺序闭合。
 * <li>注意空字符串可被认为是有效字符串。
 *
 * <p>示例 1:
 * <br>输入: "()[]{}"
 * <br>输出: true
 * <br>示例 2:
 * <br>输入: "(]"
 * <br>输出: false
 *
 * @author Jerome Zhu
 * @since 2018.10.23 21:14
 */
public class LeetCode0020 {

    /**
     * 验证括号是否匹配
     * 解决思路将匹配规则放入 map 中，随后将字符压入栈中
     *
     * @param s 待验证的符号
     * @return 验证结果
     */
    public boolean isValid(String s) { //   5 ms 33.4 MB 战胜 85.02 % 的 java 提交记录
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != mappings.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 验证括号是否匹配
     * 将字符压入栈中，直接匹配
     *
     * @param s 待验证的符号
     * @return 验证结果
     */
    public boolean isValid1(String s) { // 4 ms	33.2 MB 战胜 92.19 % 的 java 提交记录
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                // 首先判断栈里面是否还有元素
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        LeetCode0020 leetCode0020 = new LeetCode0020();
        System.out.println(leetCode0020.isValid(s));
    }
}
