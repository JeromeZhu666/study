package xin.jerome.study.algorithms.sort;

/**
 * 快速排序
 *
 * @author Jerome Zhu
 * @since 2019.08.12 22:11
 */
public class QuickSort<T extends Comparable<T>> implements ISortTest<T> {

    public void quickSort(T[] arr, int l, int r) {
        // 没有数据或有一个元素,默认是有序的
        if (l >= r) {
            return;
        }

        int partitionIndex = partition(arr, l, r);
        quickSort(arr, l, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, r);
    }

    private int partition(T[] arr, int l, int r) {
        int partitionIndex = l;
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
