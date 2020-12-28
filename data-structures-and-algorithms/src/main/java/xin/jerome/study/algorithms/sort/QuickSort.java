package xin.jerome.study.algorithms.sort;

/**
 * 快速排序
 * 
 * 从数列中挑出一个元素,作为"基准".所有比基准值小的元素移动到基准前面,所有比基准值大的元素移动到基准后面.
 * 递归地将小于基准值元素的子序列和大于基准值元素的子序列排序.时间复杂度:O(nlogn)
 *
 * @author Jerome Zhu
 * @since 2019.08.12 22:11
 */
public class QuickSort<T extends Comparable<T>> implements ISortTest<T> {

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
        // 没有数据或有一个元素,默认是有序的
        if (l >= r) {
            return;
        }

        int partitionIndex = partition(arr, l, r);
        quickSort(arr, l, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, r);
    }

    /**
     * 选择l作为基准,对数组中[l,r]区间中的元素进行分割.
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
        // 选择l作为基准元素
        int partitionIndex = l;
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
