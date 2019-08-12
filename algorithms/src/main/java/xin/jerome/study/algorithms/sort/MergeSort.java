package xin.jerome.study.algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 将两个已经排序的序列合并成一个序列的操作,把每个元素看成最小单元的有序序列.
 * 
 * @author Jerome Zhu
 * @since 2019.08.12 07:33
 */
public class MergeSort<T extends Comparable<T>> implements ISortTest<T> {

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
    private void mergeSort(T[] arr, int l, int r) {
        // 递归到底的情况
        if (l >= r) {
            return;
        }

        // 计算中间索引值
        int mid = (l + r) / 2;
        // 左右进行排序
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 左右排好序的区间进行归并
        merge(arr, l, mid, r);
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
        mergeSort(arr, 0, arr.length - 1);
    }
}
