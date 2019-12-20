package xin.jerome.sutdy.designpatterns.creational.singleton;

import java.io.Serializable;

/**
 * 单例设计模式 : 枚举类的线程安全的饿汉式实现
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 21:42
 */
public enum ThreadSafeEagerSingletonByEnum {
    INSTANCE{
        protected void action() {
            System.out.println("枚举实现");
        }
    };

    protected abstract void action();


    /**
     * 提供静态方法供外部访问 线程安全
     */
    public static ThreadSafeEagerSingletonByEnum getInstance() {
        return INSTANCE;
    }

}
