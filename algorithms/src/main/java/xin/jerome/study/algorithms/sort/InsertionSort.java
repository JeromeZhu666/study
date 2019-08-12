package xin.jerome.study.algorithms.sort;

/**
 * 插入排序
 *
 * 通过构建有序序列,对于未排序数据,在已排序序列中从后向前扫描,找到相应位置并插入.
 * 
 * @author Jerome Zhu
 * @since 2019.08.09 08:19
 */
public class InsertionSort<T extends Comparable<T>> implements ISortTest<T> {

    /**
     * 对数组进行插入排序(从小到大)
     *
     * @param arr
     *            待排序的数组
     */
    public void insertionSort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // [0,i-1]是已经排好序的数据,对于当前元素i与已经排好序的序列从后向前比较,找到合适的插入位置一步一交换.
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                T temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    @Override
    public void sort(T[] arr) {
        insertionSort(arr);
    }
}
