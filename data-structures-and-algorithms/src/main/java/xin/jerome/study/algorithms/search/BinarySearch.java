package xin.jerome.study.algorithms.search;

/**
 * 二分查找法
 * 
 * 在有序数组中查找某一特定元素的搜索算法.
 *
 * @author Jerome Zhu
 * @since 2019.08.28 07:38
 */
public class BinarySearch<T extends Comparable<T>> {

    /**
     * 在有序数组 sourceArray 中查找 target 所在的位置.
     * 
     * @param sourceArray
     *            原数组
     * @param target
     *            目标值
     * @return 如果数组中存在 target 返回对应的索引,否则返回 -1.
     */
    public int binarySearch(T[] sourceArray, T target) {
        int l = 0;
        int r = sourceArray.length - 1;
        while (l <= r) {
            // 使用减法运算,防止int值溢出
            int mid = l + (r - l) / 2;
            if (target.compareTo(sourceArray[mid]) < 0) {
                r = mid - 1;
            } else if (target.compareTo(sourceArray[mid]) > 0) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 在有序数组 sourceArray [l,r]中查找 target 所在的位置(递归实现).
     * 
     * @param sourceArray
     *            原数组
     * @param target
     *            目标值
     * @return 如果数组中存在 target 返回对应的索引,否则返回 -1.
     */
    public int recursiveBinarySearch(T[] sourceArray, int l, int r, T target) {
        // 递归到底的情况
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (target.compareTo(sourceArray[mid]) < 0) {
            return recursiveBinarySearch(sourceArray, l, mid - 1, target);
        } else if (target.compareTo(sourceArray[mid]) > 0) {
            return recursiveBinarySearch(sourceArray, mid + 1, r, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new BinarySearch<Integer>().binarySearch(arr, 10));
        System.out.println(new BinarySearch<Integer>().recursiveBinarySearch(arr, 0, arr.length - 1, 10));
    }
}
