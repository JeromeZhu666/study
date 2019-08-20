package xin.jerome.study.algorithms.sort;

/**
 * 堆排序
 * <p>
 * 利用堆这种数据结构所设计的一种排序算法.堆是一个近似完全二叉树的结构,<br>
 * 同时满足堆积的性质:即子节点的键值或索引总是小于(或者大于)它的父节点.
 *
 * @author Jerome Zhu
 * @since 2019.08.20 07:25
 */
public class HeapSort<T extends Comparable<T>> implements ISortTest<T> {

    private void heapSort(T[] arr) {
        int len = arr.length;
        for (int i = parent(len - 1); i >= 0; i--) {
            siftDown(arr, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            // 将最大的元素交换到数组的末尾
            swap(arr, 0, i);
            // 将索引为0的元素在区间[0,len)下沉
            siftDown(arr, 0, i);
        }
    }

    /**
     * 将指定位置的元素在区间[0,len)下沉
     *
     * @param arr
     *            源数组
     * @param index
     *            指定的位置
     * @param len
     *            数组的长度
     */
    private void siftDown(T[] arr, int index, int len) {
        // 当左孩子节点的索引小于数组的长度说明当前节点有左孩子
        while (left(index) < len) {
            // 假定左孩子为最大的元素
            int maxChild = left(index);
            // 当前节点存在右孩子,并且比最大的元素还要大
            if (right(index) < len && arr[right(index)].compareTo(arr[maxChild]) > 0) {
                // 当前节点的右孩子为最大的元素
                maxChild = right(index);
            }
            // 若子节点中最大的元素比当前节点小,则终止循环
            if (arr[maxChild].compareTo(arr[index]) < 0) {
                break;
            }
            // 若子节点中最小的元素比当前节点小,则进行交换
            swap(arr, maxChild, index);
            // 维护index的值
            index = maxChild;
        }
    }

    /**
     * 交换数组中的值
     *
     * @param arr
     *            源数组
     * @param minChild
     *            交换位置的索引
     * @param index
     *            交换位置的索引
     */
    private void swap(T[] arr, int minChild, int index) {
        T temp = arr[minChild];
        arr[minChild] = arr[index];
        arr[index] = temp;
    }

    /**
     * 获取指定节点的父亲节点的索引
     *
     * @param index
     *            指定节点的索引
     * @return 父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取指定节点的左孩子节点的索引(从0开始存储元素)
     *
     * @param index
     *            指定节点的索引
     * @return 左孩子节点的索引
     */
    private int left(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取指定节点的右孩子节点的索引(从0开始存储元素)
     *
     * @param index
     *            指定节点的索引
     * @return 右孩子节点的索引
     */
    private int right(int index) {
        return index * 2 + 2;
    }

    @Override
    public void sort(T[] arr) {
        heapSort(arr);
    }
}
