package xin.jerome.study.algorithms.sort;

/**
 * 插入排序 {@link InsertionSort} ,基于记录插入位置的改造.
 *
 * @author Jerome Zhu
 * @since 2019.08.12 08:13
 */
public class InsertionSortReformByInsertIndex<T extends Comparable<T>> implements ISortTest<T> {

    /**
     * 对数组进行插入排序(从小到大)
     *
     * @param arr
     *            待排序的数组
     */
    public void insertionSortReform(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 待插入的元素
            T temp = arr[i];
            // 待插入的位置
            int j = i;
            for (; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                // 待插入的元素比排好序的元素小,将排好序的元素后移.
                arr[j] = arr[j - 1];
            }
            // 已经遍历找到插入的位置
            arr[j] = temp;
        }
    }

    @Override
    public void sort(T[] arr) {
        insertionSortReform(arr);
    }
}
