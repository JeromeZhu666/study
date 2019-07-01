package xin.jerome.study.datastructures.heap;

import xin.jerome.study.datastructures.heap.impl.MaxHeap;

import java.util.Random;

/**
 * 测试自定义堆的完整性
 *
 * @author Jerome Zhu
 * @since 2019.07.01 23:35
 */
public class TestHeap {

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        int n = 1000000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        System.out.println("completed.");

    }
}
