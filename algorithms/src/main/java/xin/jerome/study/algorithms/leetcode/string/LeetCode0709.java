package xin.jerome.study.algorithms.leetcode.string;

/**
 * 转换成小写字母:
 * <br>实现函数 ToLowerCase(),该函数接收一个字符串参数 str,
 * 并将该字符串中的大写字母转换成小写字母,之后返回新的字符串.
 *
 * <p>示例:
 * <br>输入: "Hello"
 * <br>输出: "hello"
 *
 * @author Jerome Zhu
 * @since 2019.06.06 20:54
 */
public class LeetCode0709 {

    /**
     * 转换成小写字母
     *
     * @param str 待转换字符串
     * @return 转换后的字符串
     */
    public String toLowerCase(String str) { // 0 ms	33.2 MB 战胜 100.00 % 的 java 提交记录
        return str.toLowerCase();
    }

    /**
     * 转换成小写字母
     *
     * @param str 待转换字符串
     * @return 转换后的字符串
     */
    public String toLowerCase1(String str) { // 0 ms 34.1 MB 战胜 100.00 % 的 java 提交记录
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z')
                chars[i] = (char) (chars[i] + 32);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0709().toLowerCase1("Hello"));
    }
}
