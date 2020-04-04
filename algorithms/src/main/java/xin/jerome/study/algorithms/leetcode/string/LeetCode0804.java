package xin.jerome.study.algorithms.leetcode.string;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 唯一摩尔斯密码词:
 * <br>国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串.
 * 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * <p>
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","..
 * .","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * <p>例如:
 * <br>输入: words = ["gin", "zen", "gig", "msg"]
 * <br>输出: 2
 * <br>解释: 各单词翻译如下:
 * <br>"gin" -> "--...-."
 * <br>"zen" -> "--...-."
 * <br>"gig" -> "--...--."
 * <br>"msg" -> "--...--."
 * <br>共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 * @author Jerome Zhu
 * @since 2019.06.30 16:59
 */
public class LeetCode0804 {

    /**
     * 判断给定单词列表中有多少不同的摩斯密码组合
     *
     * @param words 单词列表
     * @return 不同组合的数量
     */
    public int uniqueMorseRepresentations(String[] words) { // 4 ms 35.5 MB 战胜 93.72 % 的 java 提交记录
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> resultSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                sb.append(codes[word[j] - 'a']);
            }
            resultSet.add(sb.toString());
        }

        return resultSet.size();
    }



    /**
     * 判断给定单词列表中有多少不同的摩斯密码组合()
     *
     * @param words 单词列表
     * @return 不同组合的数量
     */
    public int uniqueMorseRepresentations1(String[] words) { // 4 ms 35.5 MB 战胜 93.72 % 的 java 提交记录
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> resultSet = new TreeSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                sb.append(codes[word.charAt(j) - 'a']);
            }
            resultSet.add(sb.toString());
        }

        return resultSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new LeetCode0804().uniqueMorseRepresentations(words));
    }
}
