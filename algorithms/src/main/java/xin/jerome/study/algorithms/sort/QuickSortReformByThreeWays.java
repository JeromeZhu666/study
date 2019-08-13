package xin.jerome.study.algorithms.sort;

/**
 * 快速排序 {@link QuickSort} ,基于将数据分为 < = > 三部分的改造,避免重复元素过多的情况.
 *
 * @author Jerome Zhu
 * @since 2019.08.13 21:55
 */
public class QuickSortReformByThreeWays<T extends Comparable<T>> implements ISortTest<T> {

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

        // partition start
        // 随机选择[l,r]中的元素作为基准元素
        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);
        T partitionVal = arr[l];
        // lt区间: arr[l+1,lt] < partitionVal
        int lt = l;
        // eq区间: (arr[lt+1,gt-1] == arr[lt+1,i]) == partitionVal
        int i = l + 1;
        // gt区间: arr[gt,r] > partitionVal
        int gt = r + 1;
        // 当 i == gt 时,区间[l,r]遍历结束.
        while (i < gt) {
            if (partitionVal.compareTo(arr[i]) > 0) {
                // 当前i元素值小于partitionVal,将i值交换到lt区间的最后一个元素,交换来的是一个比较过的元素 i++.
                swap(arr, i, ++lt);
                i++;
            } else if (partitionVal.compareTo(arr[i]) < 0) {
                // 当前i元素值大于partitionVal,将i值交换到gt区间的第一个元素,i不变因为交换来的是一个未比较的元素.
                swap(arr, i, --gt);
            } else {
                // 当前i元素值等于partitionVal,不用交换,因为i值就在eq区间的末尾,只需要将 i++
                i++;
            }
        }
        // 交换partitionVal到eq区间的首部,维护区间状况为:
        // lt区间: arr[l,lt] < partitionVal ,eq区间: arr[lt+1,gt-1] == partitionVal ,gt区间:
        // arr[gt,r].
        swap(arr, l, lt--);
        // partition end

        quickSort(arr, l, lt);
        quickSort(arr, gt, r);
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
            for (; j > l && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
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
