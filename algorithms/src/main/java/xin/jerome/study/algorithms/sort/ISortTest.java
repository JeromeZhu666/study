package xin.jerome.study.algorithms.sort;

/**
 * 测试排序算法的接口
 *
 * @author Jerome Zhu
 * @since 2019.08.12 08:00
 */
public interface ISortTest<T extends Comparable<T>> {
    /**
     * 测试排序方法的接口
     * 
     * @param arr
     *            待排序的数据数组
     */
    void sort(T[] arr);
}
