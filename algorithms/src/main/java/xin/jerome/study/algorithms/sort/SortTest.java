package xin.jerome.study.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 排序方法测试类
 *
 * @author Jerome Zhu
 * @since 2019.08.08 08:56
 */
public class SortTest {

    @Test
    public void testSort() {
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        testSort(new SelectionSort<>(), arr);
        testSort(new MergeSort<Integer>(), arr2);
    }

    private void testSort(ISortTest<Integer> sortTest, Integer[] arr) {
        long startTime = System.nanoTime();
        sortTest.sort(arr);
        Double time = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(String.format("%s,time:%fs", sortTest.getClass().getSimpleName(), time));
    }

}
