package xin.jerome.study.datastructures.leetcode.hash;

/**
 * 字符串中的第一个唯一字符
 * 
 * 给定一个字符串,找到它的第一个不重复的字符,并返回它的索引.如果不存在,则返回 -1.
 * 
 * 案例: <br>
 * s = "leetcode", 返回 0. <br>
 * s = "loveleetcode", 返回 2. <br>
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author Jerome Zhu
 * @since 2019.08.02 07:50
 */
public class LeetCode0387 {

    /**
     * 查找字符串中第一个出现一次的字符 25 ms 48.7 MB 战胜 60.28 % 的 java 提交记录
     * 
     * @param s
     *            待验证的字符串
     * @return 第一个唯一字符在 s 中的索引.
     */
    public int firstUniqChar(String s) {
        // 统计次数,存入数组中(一共有26个英文字母)
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        // 再次遍历 字符串 s , 判断字符是否只出现了一次.
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找字符串中第一个出现一次的字符 34 ms 49.2 MB 战胜 50.12 % 的 java 提交记录
     *
     * @param s
     *            待验证的字符串
     * @return 第一个唯一字符在 s 中的索引.
     */
    public int firstUniqChar1(String s) {
        // 解决思路,从前向后在字符 c 和从后向前找字符 c 返回的索引一样表示只出现一次.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new LeetCode0387().firstUniqChar("z");
    }
}
