package xin.jerome.sutdy.designpatterns.creational.singleton;

import java.io.Serializable;

/**
 * 单例设计模式 : 只在一个线程内是单例的
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 21:42
 */
public class ThreadSafeThreadLocalSingleton implements Serializable,Cloneable {
    /**
     * 定义统一实例对象并实例化
     */
    private static final ThreadLocal<ThreadSafeThreadLocalSingleton> INSTANCE =
            ThreadLocal.withInitial(ThreadSafeThreadLocalSingleton::new);

    /**
     * 构造器私有化,禁止通过构造器创建实例
     */
    private ThreadSafeThreadLocalSingleton() {
    }

    /**
     * 提供静态方法供外部访问 线程安全
     */
    public static ThreadSafeThreadLocalSingleton getInstance() {
        return INSTANCE.get();
    }
}
