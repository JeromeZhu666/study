package xin.jerome.study.algorithms.string.leetcode;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * @author JeromeSoar
 * @since 2020年05月19日 21:38
 */
public class LeetCode0680 {

    /**
     * 递归调用验证方法: 验证开始和结束字符是否相等.
     * 时间复杂度 O(n) 空间复杂度 O(n)  31 ms  46.3 MB
     * @param s 字符
     */
    public boolean validPalindrome(String s) {
        return validSubPalindrome(s, 0, s.length() - 1, false);
    }
    public boolean validSubPalindrome(String s, int start, int end, boolean deleted) {
        // 递归到底的情况两指针相撞
        if (start >= end) {
            return true;
        }

        // 如果两端字符不相等, 则验证删除左侧或右侧后的字串是否是回文串
        if (s.charAt(start) != s.charAt(end) ) {
            return !deleted && (validSubPalindrome(s, start + 1, end, true) || validSubPalindrome(s, start, end - 1, true));
        }
        // 如果两端字符相等则验证删除左侧和右侧后的字串是否是回文串
        return validSubPalindrome(s, start + 1, end - 1, deleted);
    }

    /**
     * 迭代遍历验证方法: 验证开始和结束字符是否相等.
     * 时间复杂度 O(n) 空间复杂度 O(1)  15 ms  40.8 MB, 加完 break 后  9 ms  40.7 MB
     * @param s 字符
     */
    public boolean validPalindrome1(String s) {
        // 申请两个游标
        int start = 0;
        int end = s.length() - 1;
        // 当游标不相撞时开始遍历
        while (start < end) {
            // 如果相等, start 后移, end 前移.
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            // 如果不相等, 判断字串是否是回文串
            else {
                // 判断删除左侧后的字串是否是回文串
                boolean delStart = true;
                for (int subStart = start + 1, subEnd = end; subStart < subEnd; subStart++, subEnd--) {
                    if (s.charAt(subStart) != s.charAt(subEnd)) {
                        delStart = false;
                        break;
                    }
                }
                // 判断删除右侧后的字串是否是回文串
                boolean delEnd = true;
                for (int subStart = start, subEnd = end - 1; subStart < end; subStart++, subEnd--) {
                    if (s.charAt(subStart) != s.charAt(subEnd)) {
                        delEnd = false;
                        break;
                    }
                }
                return delStart || delEnd;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abca";
        System.out.println(new LeetCode0680().validPalindrome1(str));
    }
}
