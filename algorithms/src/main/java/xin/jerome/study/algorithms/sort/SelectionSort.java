package xin.jerome.study.algorithms.sort;

/**
 * 选择排序
 * 
 * 在未排序序列中找到最小(大)元素,存放到排序序列的起始位置.
 * 再从剩余未排序元素中继续寻找最小(大)元素,然后放到已排序序列的末尾.以此类推,直到所有元素均排序完毕. 时间复杂度:O(n^2)
 *
 * @author Jerome Zhu
 * @since 2019.08.08 08:55
 */
public class SelectionSort<T extends Comparable<T>> implements ISortTest<T> {

    /**
     * 对数组进行选择排序(从小到大)
     * 
     * @param arr
     *            待排序的数组
     */
    public void selectionSort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 存储未排序序列的最小值所在索引
            int minIndex = i;
            // 比较并遍历为排序序列找到未排序序列中最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换最小值与当前值
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    @Override
    public void sort(T[] arr) {
        selectionSort(arr);
    }
}
