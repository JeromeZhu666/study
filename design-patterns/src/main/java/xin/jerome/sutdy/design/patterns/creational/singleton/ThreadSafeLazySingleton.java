package xin.jerome.sutdy.design.patterns.creational.singleton;

/**
 * 单例设计模式 : 线程安全的懒汉式实现 (适用于多线程)
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 21:42
 */
public class ThreadSafeLazySingleton {
    /**
     * 定义统一实例对象
     */
    private static ThreadSafeLazySingleton threadUnsafeLazySingleton = null;

    /**
     * 构造器私有化,禁止通过构造器创建实例
     */
    private ThreadSafeLazySingleton() {
    }

    /**
     * 提供静态方法供外部访问 线程安全
     */
    public static ThreadSafeLazySingleton getInstance() {
        return getThreadSafeLazySingletonBySynchronizeCodeBlockDoubleCheck();
    }

    /**
     * 加synchronized关键字保证安全,但是性能会差,因为多线程同时获取对象被阻塞.
     */
    private static synchronized ThreadSafeLazySingleton getThreadSafeLazySingletonBySynchronize() {
        if (threadUnsafeLazySingleton == null) {
            threadUnsafeLazySingleton = new ThreadSafeLazySingleton();
        }
        return threadUnsafeLazySingleton;
    }

    /**
     * 利用synchronized代码块,但是性能会差,因为多线程同时获取对象被阻塞.
     */
    private static ThreadSafeLazySingleton getThreadSafeLazySingletonBySynchronizeCodeBlock() {
        synchronized(ThreadSafeLazySingleton.class) {
            if (threadUnsafeLazySingleton == null) {
                threadUnsafeLazySingleton = new ThreadSafeLazySingleton();
            }
        }
        return threadUnsafeLazySingleton;
    }

    /**
     * 利用synchronized代码块,增加双重检查,解决性能问题.
     * 因为加synchronized自是为了保证第一次创建时只创建一个实例.
     */
    private static ThreadSafeLazySingleton getThreadSafeLazySingletonBySynchronizeCodeBlockDoubleCheck() {
        if (threadUnsafeLazySingleton == null) {
            // 第一次创建,只允许一个线程执行调用动作
            synchronized (ThreadSafeLazySingleton.class) {
                if (threadUnsafeLazySingleton == null) {
                    threadUnsafeLazySingleton = new ThreadSafeLazySingleton();
                }
            }
        }
        return threadUnsafeLazySingleton;
    }
}
