package xin.jerome.study.interview.java.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import org.junit.Test;

/**
 * 线程安全Set相关问题
 *   1.请至少举出三种线程安全的Set实现?
 *     {@link ThreadSafeSetQuestions#testListAtLeastThreeThreadSafeSetImplementation()}
 *   2.在J.U.C框架中,存在HashSet的线程安全实现?如果不存在的话，要如何实现?
 *     不存在，可以利用 {@link ConcurrentHashMap} 模仿 {@link HashSet}的实现来实现.
 *     或者用 Java 6 提供的 {@link Collections#newSetFromMap(java.util.Map)} 方法实现.
 *   todo 3.当Set#iterator() 方法返回Iterator对象后，能否在其迭代中,给Set对象添加新的元素?
 *     不一定，传统实现，会有fail-fast，而在 JUC 里是弱一直性，还是可以在迭代中添加元素的
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 11:41
 */
public class ThreadSafeSetQuestions {

    /**
     * 1.请至少举出三种线程安全的Set实现?
     */
    @Test
    public void testListAtLeastThreeThreadSafeSetImplementation() {
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        // 不可修改的,即线程安全的
        integerSet = Collections.unmodifiableSet(integerSet);
        // java 9的实现
        // integerSet = Set.of(1, 2, 3, 4, 5);

        // 可修改的线程安全实现
        integerSet = Collections.synchronizedSet(integerSet);
        integerSet = new CopyOnWriteArraySet<>(integerSet);
        integerSet = new ConcurrentSkipListSet<>(integerSet);
    }
}
