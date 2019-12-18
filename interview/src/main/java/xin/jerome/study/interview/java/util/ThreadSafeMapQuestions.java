package xin.jerome.study.interview.java.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Hashtable.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;

/**
 * 线程安全Map相关问题
 *   1.请说明Hashtable、HashMap以及ConcurrentHashMap的区别？
 *     {@link ThreadSafeMapQuestions#testCompareDistinction()}
 *   2.请说明ConcurrentHashMap在不同的JDK中的实现?
 *     {@link ThreadSafeMapQuestions#testConcurrentHashMapDifferentJDKImplement()}
 *   3.请说明ConcurrentHashMap与ConcurrentSkipListMap 各自的优势与不足?
 *     {@link ThreadSafeMapQuestions#testCompareConcurrentHashMapAndConcurrentSkipListMapDistinction()}
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 12:00
 */
public class ThreadSafeMapQuestions {

    /**
     * 请说明Hashtable、HashMap以及ConcurrentHashMap的区别？
     *   1) Hashtable  value 不能为空,属于方法强制校验 {@link Hashtable#put(java.lang.Object, java.lang.Object)}
     *                 key 不能为空,属于调用 key.hashCode(); 由hashCode() 方法抛出的空指针异常.
     *      HashMap    value 都可以为空
     *                 key 可以为空 {@link HashMap#hash(java.lang.Object)}, key为空时, 放回的hash值为0.
     *      ConcurrentHashMap key 和 value 都不可以为空,方法强制校验.
     *                 {@link ConcurrentHashMap#putVal(java.lang.Object, java.lang.Object, boolean)}
     *   2) Hashtable           -> 数组 + 链表实现 {@link Entry}
     *      HashMap             -> Java8 之后是数组 + 链表 + 红黑树 实现 , 当阈值 >= 8时 链表转红黑树; <= 6时 红黑树转链表
     *      ConcurrentHashMap   -> 和 HashMap 一样的
     */
    @Test
    public void testCompareDistinction() {
    }

    /**
     * todo 请说明ConcurrentHashMap在不同的JDK中的实现?
     *   1) Java6 分离锁的方式 : 读的时候不加锁 ， 写的时候完全锁.
     *   2) Java7 读的时候不加锁 ， 写的时候需要锁.
     *   3) Java8 读的时候不加锁 ， 写的时候需要锁. 解决Hash冲突使用红黑树的方式
     */
    @Test
    public void testConcurrentHashMapDifferentJDKImplement() {
    }

    /**
     * todo 请说明ConcurrentHashMap与ConcurrentSkipListMap 各自的优势与不足?
     */
    @Test
    public void testCompareConcurrentHashMapAndConcurrentSkipListMapDistinction() {
    }

}
