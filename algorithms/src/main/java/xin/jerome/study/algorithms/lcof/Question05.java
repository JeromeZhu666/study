package xin.jerome.study.algorithms.lcof;

/**
 * 面试题05. 替换空格
 * 请实现一个函数, 把字符串 s 中的每个空格替换成"%20".
 *
 * @author JeromeSoar
 * @since 2020年05月13日 21:17
 */
public class Question05 {

    /**
     * 利用 String#replaceAll(String, String) 方法实现
     * 正则匹配, 匹配一次替换一次  2 ms  37.6 MB
     * @param s 替换空格
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
    /**
     * 利用 String#replace(CharSequence, CharSequence) 方法实现
     * 字符遍历  0 ms  37.6 MB
     * @param s 替换空格
     */
    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 手动实现(一个一个字符添加替换): 遍历字符串的每个字符, 遇到空格就替换值
     * 时间复杂度 O(n) 空间复杂度 O(1)  1 ms  37.8 MB
     * @param s 替换空格
     */
    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 手动实现(一段一段替换): 找到空白字符所在位置
     * 时间复杂度 O(n) 空间复杂度 O(1)  0 ms  37.3 MB
     * @param s 替换空格
     */
    public String replaceSpace3(String s) {
        String spaceStr = " ";
        int appendedIndex = 0;
        int curSpaceIndex = s.indexOf(spaceStr);

        StringBuilder sb = new StringBuilder();
        while (curSpaceIndex >= 0) {
            sb.append(s, appendedIndex, curSpaceIndex).append("%20");
            appendedIndex = curSpaceIndex + 1;
            curSpaceIndex = s.indexOf(spaceStr, appendedIndex);
        }
        return sb.append(s, appendedIndex, s.length()).toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(new Question05().replaceSpace3(str));
    }
}
