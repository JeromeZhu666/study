package xin.jerome.study.algorithms.leetcode.string;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s, 找到 s 中最长的回文子串. 你可以假设 s 的最大长度为 1000。
 *
 * 示例 1:
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * @author JeromeSoar
 * @since 2020年05月21日 10:15
 */
public class LeetCode0005 {

    /**
     * 暴力解法: 先判断本串是否是回文串, 再判断左右字串是否是回文串
     * 时间复杂度 O(n^2) 空间复杂度 O(n)  超出时间限制  N/A  N/A
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            String longestSubPalindrome = longestPalindrome(s.substring(1, s.length() - 1));
            if (longestSubPalindrome.length() == s.length() - 2) {
                return s;
            }
        }

        String longestLeftSubPalindrome = longestPalindrome(s.substring(0, s.length() - 1));
        String longestRightSubPalindrome = longestPalindrome(s.substring(1));
        String result = longestLeftSubPalindrome.length() > longestRightSubPalindrome.length() ?
                longestLeftSubPalindrome : longestRightSubPalindrome;
        return result;
    }

    /**
     * 暴力解法: 先判断本串是否是回文串, 再判断左右字串是否是回文串
     * 时间复杂度 O(n^2) 空间复杂度 O(n)  超出时间限制  N/A  N/A
     */
    public String longestPalindrome1(String s, int start, int end) {

        if (start >= end || validPalindrome1(s, start, end)) {
            return s.substring(start, end + 1);
        }

        String longestLeftSubPalindrome = longestPalindrome1(s, start, end - 1);
        String longestRightSubPalindrome = longestPalindrome1(s, start + 1, end);
        String result = longestLeftSubPalindrome.length() > longestRightSubPalindrome.length() ?
                longestLeftSubPalindrome : longestRightSubPalindrome;
        return result;
    }

    public boolean validPalindrome1(String s, int start, int end) {
        // 当游标不相撞时开始遍历
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            // 如果相等, start 后移, end 前移.
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "bddda";
        System.out.println(new LeetCode0005().longestPalindrome1(str, 0, str.length() - 1));
    }
}
