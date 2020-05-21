package xin.jerome.study.algorithms.leetcode.string;

import java.util.*;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s , 请你返回满足以下条件的最长子字符串的长度: 每个元音字母, 
 * 即 'a', 'e', 'i', 'o', 'u' , 在子字符串中都恰好出现了偶数次.
 *
 * 示例 1: 
 * 输入: s = "eleetminicoworoep"
 * 输出: 13
 * 解释: 最长子字符串是 "leetminicowor" , 它包含 e, i, o 各 2 个, 以及 0 个 a, u .
 *
 * 提示:
 * - 1 <= s.length <= 5 x 10^5
 * - s 只包含小写英文字母.
 *
 * @author JeromeSoar
 * @since 2020年05月20日 14:26
 */
public class LeetCode1371 {

    public int findTheLongestSubstring(String s) {
        int[] pos = new int[1 << 5];
        int result = 0, aeiou = 0;
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                aeiou ^= (1 << 0);
            }
            else if(c == 'e'){
                aeiou ^= (1 << 1);
            }
            else if(c == 'i'){
                aeiou ^= (1 << 2);
            }
            else if(c == 'o'){
                aeiou ^= (1 << 3);
            }
            else if(c == 'u'){
                aeiou ^= (1 << 4);
            }

            if (pos[aeiou] >= 0) {
                result = Math.max(result, i + 1 - pos[aeiou]);
            } else {
                pos[aeiou] = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "eleetminicoworoep";
        System.out.println(new LeetCode1371().findTheLongestSubstring(str));
    }
}
