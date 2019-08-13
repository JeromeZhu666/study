package xin.jerome.study.algorithms.sort;

import java.util.Random;

/**
 * 快速排序 {@link QuickSort} ,基于随机选择基准的改造.
 *
 * @author Jerome Zhu
 * @since 2019.08.13 20:47
 */
public class QuickSortReformByRandomPivot<T extends Comparable<T>> implements ISortTest<T> {
    /**
     * 排序方法转换因子
     */
    public static final int SORT_METHOD_TRANSFER_FACTOR = 8;

    /**
     * 对数组中[l,r]区间中的元素进行排序.
     *
     * @param arr
     *            待排序的数组
     * @param l
     *            左边界
     * @param r
     *            右边界
     */
    public void quickSort(T[] arr, int l, int r) {
        // 如果数据量小于转换因子,则将[l,r]区间的数据进行插入排序.
        if (r - l <= SORT_METHOD_TRANSFER_FACTOR) {
            insertionSort(arr, l, r);
            return;
        }

        int partitionIndex = partition(arr, l, r);
        quickSort(arr, l, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, r);
    }

    /**
     * 对数组arr且在区间[l,r]中的数据进行插入排序
     *
     * @param arr
     *            source 数组
     * @param l
     *            左闭范围
     * @param r
     *            右闭范围
     */
    private void insertionSort(T[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            T temp = arr[i];
            int j = i;
            for (; j > l && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 随机选择[l,r]中的索引作为基准,对数组中[l,r]区间中的元素进行分割. 因为当数组arr近乎有序的情况下,若选择l作为基准会导致分割极度不均匀.
     *
     * @param arr
     *            待排序的数组
     * @param l
     *            左边界
     * @param r
     *            右边界
     * @return 基准元素的索引
     */
    private int partition(T[] arr, int l, int r) {
        // 随机选择[l,r]中的元素作为基准元素
        int partitionIndex = new Random().nextInt() % (r - l + 1) + l;
        // 基准元素值
        T partitionVal = arr[l];
        // 对区间[l,r]中的元素遍历,维护关系 l == v , [l+1,j] < v , [j+1, i-1]>v .
        for (int i = l + 1; i <= r; i++) {
            if (partitionVal.compareTo(arr[i]) > 0) {
                swap(arr, i, ++partitionIndex);
            }
        }
        // 将v放到j的位置,[l,r]的关系就变成:[l,j-1] < v , j == v , [j+1,r] > v .
        swap(arr, l, partitionIndex);
        return partitionIndex;
    }

    /**
     * 交换元素
     *
     * @param arr
     *            源数组
     * @param i
     *            待交换的元素索引
     * @param j
     *            待交换的元素索引
     */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
