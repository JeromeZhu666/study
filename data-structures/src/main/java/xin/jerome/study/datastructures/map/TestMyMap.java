package xin.jerome.study.datastructures.map;

import xin.jerome.study.datastructures.map.impl.AVLTreeMap;
import xin.jerome.study.datastructures.map.impl.BinarySearchTreeMap;
import xin.jerome.study.datastructures.map.impl.LikedListMap;

/**
 * 测试 {@link MyMap} 自定义实现的完整性.
 *
 * @author Jerome Zhu
 * @since 2019.06.30 18:51
 */
public class TestMyMap {

    public static void main(String[] args) {
        String word = "aaabbbbbccccdddddfkknnn";
        LikedListMap<Character, Integer> charMap = new LikedListMap<>();
        BinarySearchTreeMap<Character, Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();
        AVLTreeMap<Character, Integer> AVLTreeMap = new AVLTreeMap<>();
        test(word, AVLTreeMap);
        System.out.println(AVLTreeMap.isBST());
        System.out.println(AVLTreeMap.isBalance());
    }

    private static void test(String word, MyMap<Character, Integer> charMap) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (charMap.contains(c)) {
                charMap.set(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        System.out.println("word length " + word.length());
        // charMap.remove('j');
        System.out.println(charMap.get('b'));
        System.out.println("word has " + charMap.size() + " char.");
    }

}
