package xin.jerome.study.interview.java.util;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * todo 线程安全List相关问题
 *   1.请说明List、Vector 以及CopyOnWriteArrayList的相同点和不同点?
 *   2.请说明Collections#synchronizedList(List)与Vector的相同点和不同点?
 *   3.Arrays#asList(Object...)方法是线程安全的吗?如果不是的话，如何实现替代方案?
 *     {@link ThreadSafeListQuestions#testArraysAsListMethodQuestion()}
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 11:16
 */
public class ThreadSafeListQuestions {


    /**
     * Arrays#asList(Object...)方法是线程安全的吗?如果不是的话，如何实现替代方案?
     * 不是线程安全的
     */
    @Test
    public void testArraysAsListMethodQuestion() {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        // 由 java.util.AbstractList.add(int, E) 会抛出 UnsupportedOperationException
//        integerList.add(6);
        // set 方法的确是篡改了数据
        integerList.set(1,0);
        integerList.forEach(System.out::println);
        // Java < 5 , Collections#synchronizedList ; Collections#unmodifiableList 只读
        // Java 5+  , CopyOnWriteArrayList
        // Java 9+  , List.of(...) 只读
    }
}
