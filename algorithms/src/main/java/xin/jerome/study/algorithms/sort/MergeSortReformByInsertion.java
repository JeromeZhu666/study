package xin.jerome.study.algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序 {@link MergeSort} ,基于未排序序列数据量小时采用插入排序的改造.
 *
 * @author Jerome Zhu
 * @since 2019.08.12 21:07
 */
public class MergeSortReformByInsertion<T extends Comparable<T>> implements ISortTest<T> {

    /**
     * 排序方法转换因子
     */
    public static final int SORT_METHOD_TRANSFER_FACTOR = 8;

    /**
     * 递归函数,递归的将数组进行拆分并排序
     *
     * @param arr
     *            source 数组
     * @param l
     *            左闭范围
     * @param r
     *            右闭范围
     */
    private void mergeSortReform(T[] arr, int l, int r) {
        // 如果数据量小于转换因子,则将[l,r]区间的数据进行插入排序.
        if (r - l <= SORT_METHOD_TRANSFER_FACTOR) {
            insertionSort(arr, l, r);
            return;
        }

        // 计算中间索引值
        int mid = (l + r) / 2;
        // 左右进行排序
        mergeSortReform(arr, l, mid);
        mergeSortReform(arr, mid + 1, r);
        // 如果左右排好序的区间不是有序的,则进行归并操作.
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
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
     * 将数组中[l,r]区间中的元素进行排序
     *
     * @param arr
     *            待排序的数组
     * @param l
     *            左闭范围
     * @param mid
     *            中间索引值
     * @param r
     *            右闭范围
     */
    private void merge(T[] arr, int l, int mid, int r) {
        // 构造一个临时数组空间存储区间中的数据
        T[] tempArr = Arrays.copyOfRange(arr, l, r + 1);
        // 记录两侧位置
        int left = l;
        int right = mid + 1;
        for (int i = l; i <= r; i++) {
            if (left > mid) {
                // 左侧遍历完右侧没有遍历完
                arr[i] = tempArr[right - l];
                right++;
            } else if (right > r) {
                // 右侧遍历完左侧没有遍历完
                arr[i] = arr[left - l];
                left++;
            } else if (tempArr[left - l].compareTo(tempArr[right - l]) <= 0) {
                // 两侧都没有遍历完,比较左右区间的值
                // 左侧值小于等于右侧的值,将左侧值归并的数组中
                arr[i] = tempArr[left - l];
                left++;
            } else {
                // 两侧都没有遍历完,比较左右区间的值
                // 左侧的值大于右侧的值,将右侧的值归并的数组中
                arr[i] = tempArr[right - l];
                right++;
            }
        }
    }

    @Override
    public void sort(T[] arr) {
        mergeSortReform(arr, 0, arr.length - 1);
    }
}
