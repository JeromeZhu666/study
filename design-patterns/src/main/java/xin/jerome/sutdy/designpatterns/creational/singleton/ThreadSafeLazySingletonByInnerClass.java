package xin.jerome.sutdy.designpatterns.creational.singleton;

/**
 * 单例设计模式 : 私有静态内部类的线程安全的懒汉式实现 (适用于多线程)
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 21:42
 */
public class ThreadSafeLazySingletonByInnerClass {
    /**
     * 私有静态内部类
     */
    private static class InnerClass{
        private static final ThreadSafeLazySingletonByInnerClass INSTANCE = new ThreadSafeLazySingletonByInnerClass();
    }

    /**
     * 构造器私有化,禁止通过构造器创建实例
     */
    private ThreadSafeLazySingletonByInnerClass() {
    }

    /**
     * 提供静态方法供外部访问
     * 调用私有静态内部类的方式
     */
    public static ThreadSafeLazySingletonByInnerClass getInstance() {
        return InnerClass.INSTANCE;
    }
}
