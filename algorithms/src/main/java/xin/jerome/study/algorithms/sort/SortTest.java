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
    public void testSort() {
        Integer[] arr = generateRandomArray(50000, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        testSort(new InsertionSortReformByInsertIndex<>(), arr);
        testSort(new MergeSort<>(), arr2);
        testSort(new MergeSortReformByInsertion<>(), arr3);
    }

    private void testSort(ISortTest<Integer> sortTest, Integer[] arr) {
        long startTime = System.nanoTime();
        sortTest.sort(arr);
        Double time = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(String.format("%s,time:%fs", sortTest.getClass().getSimpleName(), time));
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
}
