package xin.jerome.sutdy.designpatterns.creational.singleton;

import java.io.Serializable;

/**
 * 单例设计模式 : 线程安全的饿汉式实现 (在类加载时初始化实例对象)
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 21:42
 */
public class ThreadSafeEagerSingleton implements Serializable,Cloneable {
    /**
     * 定义统一实例对象并实例化
     */
    private static final ThreadSafeEagerSingleton INSTANCE = new ThreadSafeEagerSingleton();

    /**
     * 静态代码块初始化方式
     */
    private static final ThreadSafeEagerSingleton OTHER_INSTANCE;
    static{
        OTHER_INSTANCE = new ThreadSafeEagerSingleton();
    }

    /**
     * 构造器私有化,禁止通过构造器创建实例
     */
    private ThreadSafeEagerSingleton() {
        // 防止通过反射创建对象
        if(INSTANCE != null) {
            throw new IllegalArgumentException("Cannot reflectively create ThreadSafeEagerSingleton objects");
        }
    }

    /**
     * 提供静态方法供外部访问 线程安全
     * 但是这种方式,如果 {@code INSTANCE} 没有被使用将会对内存空间造成浪费.
     */
    public static ThreadSafeEagerSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 防止反序列化破坏单例模式
     * Resolves instances being deserialized to a single instance per currency.
     */
    private Object readResolve() {
        return getInstance();
    }

    /**
     * 防止克隆破坏单例模式
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        return getInstance();
    }
}
