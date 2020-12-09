package xin.jerome.sutdy.design.patterns.creational.singleton;

/**
 * 单例设计模式 : 线程不安全的懒汉式实现 (适用于单线程)
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 21:42
 */
public class ThreadUnsafeLazySingleton {
    /**
     * 定义统一实例对象
     */
    private static ThreadUnsafeLazySingleton threadUnsafeLazySingleton = null;

    /**
     * 构造器私有化,禁止通过构造器创建实例
     */
    private ThreadUnsafeLazySingleton() {
    }

    /**
     * 提供静态方法供外部访问 线程不安全
     */
    public static ThreadUnsafeLazySingleton getInstance() {
        if (threadUnsafeLazySingleton == null) {
            threadUnsafeLazySingleton = new ThreadUnsafeLazySingleton();
        }
        return threadUnsafeLazySingleton;
    }
}
