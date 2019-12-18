package xin.jerome.study.interview.java.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.junit.Test;

/**
 * 线程安全集合相关问题
 *   1.请在Java集合框架以及J.U.C 框架中各举出List、Set以及Map的实现?
 *     {@link ThreadSafeCollectionQuestions#testListCollectionInterfaceImplementationInJUC()}
 *   2.如何将普通List、Set以及Map转化为线程安全对象?
 *     {@link ThreadSafeCollectionQuestions#testImplementTheadSafeCollection()}
 *   3.如何在Java 9+实现将普通List、Set以及Map转化为线程安全对象?
 *     {@link ThreadSafeCollectionQuestions#testImplementTheadSafeCollectionInJava9()}
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 10:39
 */
public class ThreadSafeCollectionQuestions {

    /**
     * 请在Java集合框架以及J.U.C 框架中各举出List、Set以及Map的实现?
     */
    @Test
    public void testListCollectionInterfaceImplementationInJUC() {
    }

    /**
     * 如何将普通List、Set以及Map转化为线程安全对象?
     */
    @Test
    public void testImplementTheadSafeCollection() {
        List<Integer> integerList = Arrays.asList(1,2);
        Set<Integer> integerSet = new HashSet<>(integerList);
        Map<String,Integer> integerMap = new HashMap<>();
        integerMap.put("key",1);

        // 不能做修改的集合就是线程安全的
        integerList = Collections.unmodifiableList(integerList);
        integerSet = Collections.unmodifiableSet(integerSet);
        integerMap = Collections.unmodifiableMap(integerMap);

        // 使用 Collections#synchronized* 返回
        // Wrapper 设计模式（所有的方法都被 synchronized 同步或互斥）
        integerList = Collections.synchronizedList(integerList);
        integerSet = Collections.synchronizedSet(integerSet);
        integerMap = Collections.synchronizedMap(integerMap);

        // 使用线程安全的实现 进行包装
        integerList = new CopyOnWriteArrayList<>(integerList);
        integerSet = new CopyOnWriteArraySet<>(integerSet);
        integerMap = new ConcurrentHashMap<>(integerMap);
    }

    /**
     * 如何在Java 9+实现将普通List、Set以及Map转化为线程安全对象?
     */
    @Test
    public void testImplementTheadSafeCollectionInJava9() {
        // 返回的是 ImmutableCollection 对象
//        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
//        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
//        Map<String,Integer> integerMap = Map.of("key", 1);
    }

}
