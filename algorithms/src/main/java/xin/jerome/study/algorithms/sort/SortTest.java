package xin.jerome.study.algorithms.sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 排序方法测试类
 *
 * @author Jerome Zhu
 * @since 2019.08.08 08:56
 */
public class SortTest {

    @Test
    public void testHeapSort() {
        Integer[] arr1 = generateRandomArray(50, 0, 1000);
        testSort(new HeapSort<>(), arr1);
    }

    @Test
    public void testMergeSortAndQuickSort() {
        Integer[] arr1 = generateRandomArray(50000, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        testSort(new MergeSort<>(), arr1);
        testSort(new MergeSortReformByInsertion<>(), arr2);
        testSort(new QuickSort<>(), arr3);
        testSort(new QuickSortReformByInsertion<>(), arr4);
        testSort(new QuickSortReformByRandomPivot<>(), arr5);
        testSort(new QuickSortReformByThreeWays<>(), arr6);
    }

    @Test
    public void testSelectionSortAndInsertionSort() {
        Integer[] arr1 = generateRandomArray(500, 0, 10000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        testSort(new SelectionSort<>(), arr1);
        testSort(new InsertionSort<>(), arr2);
        testSort(new InsertionSortReformByInsertIndex<>(), arr3);
        testSort(new InsertionSortReformByInsertIndex<>(), arr4);
    }

    /**
     * 测试排序算法对数组的排序,并统计消耗时间以及结果是否有序.
     * 
     * @param sortTest
     *            测试排序类的接口
     * @param arr
     *            测试数组
     */
    private void testSort(ISortTest<Integer> sortTest, Integer[] arr) {
        long startTime = System.nanoTime();
        sortTest.sort(arr);
        Double time = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(
            String.format("%s,time:%fs,isSorted:%s", sortTest.getClass().getSimpleName(), time, isSorted(arr)));
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     * 
     * @param n
     *            数组大小
     * @param rangeLeft
     *            数组的元素的左取值范围
     * @param rangeRight
     *            数组的元素的右取值范围
     */
    private Integer[] generateRandomArray(int n, int rangeLeft, int rangeRight) {

        assert rangeLeft <= rangeRight;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int)(Math.random() * (rangeRight - rangeLeft + 1) + rangeLeft));
        }
        return arr;
    }

    /**
     * 验证数组是不是有序的
     * 
     * @param arr
     *            待验证数组
     * @return 数组有序返回 true , 否则返回false.
     */
    private boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
