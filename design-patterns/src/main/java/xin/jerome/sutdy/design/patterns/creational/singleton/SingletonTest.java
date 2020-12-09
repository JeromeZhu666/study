package xin.jerome.sutdy.design.patterns.creational.singleton;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例设计模式
 *
 * 单例模式,单例对象的类必须保证只有一个实例存在.类的构建方式有两种 : 懒汉式 和 饿汉式.
 *   懒汉式(LAZY) : 指全局的单例实例在第一次被使用时构建.
 *     1.线程不安全的懒汉式实现 (适用于单线程) {@link ThreadUnsafeLazySingleton}
 *     2.线程安全的懒汉式实现 (适用于多线程) {@link ThreadSafeLazySingleton}
 *     3.私有静态内部类的线程安全的懒汉式实现 (适用于多线程) {@link ThreadSafeLazySingletonByInnerClass}
 *   饿汉式(EAGER) : 指全局的单例实例在类装载时构建.
 *     1.类加载时初始化实例对象线程安全的饿汉式实现. {@link ThreadSafeEagerSingleton}
 *     2.枚举类的线程安全的饿汉式实现. {@link ThreadSafeEagerSingletonByEnum}
 *     3.ThreadLocal实现只在一个线程内是单例的 {@link ThreadSafeThreadLocalSingleton}
 *
 * ps:当实例未创建的时候,要保证不同的线程获取到的是同一个对象.
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 19:57
 */
public class SingletonTest {

    @Test
    public void testThreadUnsafeLazySingleton() {
        ThreadUnsafeLazySingleton instance = ThreadUnsafeLazySingleton.getInstance();
        ThreadUnsafeLazySingleton otherInstance = ThreadUnsafeLazySingleton.getInstance();
        System.out.println(instance == otherInstance);
    }

    @Test
    public void testThreadSafeLazySingleton() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(ThreadSafeLazySingleton.getInstance()));
        Thread t2 = new Thread(() -> System.out.println(ThreadSafeLazySingleton.getInstance()));
        t1.start();
        t2.start();
    }

    @Test
    public void testThreadSafeLazySingletonByInnerClass() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(ThreadSafeLazySingletonByInnerClass.getInstance()));
        Thread t2 = new Thread(() -> System.out.println(ThreadSafeLazySingletonByInnerClass.getInstance()));
        t1.start();
        t2.start();
    }

    @Test
    public void testThreadSafeEagerSingleton() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(ThreadSafeEagerSingleton.getInstance()));
        Thread t2 = new Thread(() -> System.out.println(ThreadSafeEagerSingleton.getInstance()));
        t1.start();
        t2.start();
    }

    /**
     * 防止反序列化破坏单例模式
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testPreventDeserializationDestructionSingleton() throws IOException, ClassNotFoundException {
        ThreadSafeEagerSingleton instance = ThreadSafeEagerSingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ThreadSafeEagerSingleton newInstance = (ThreadSafeEagerSingleton) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }

    /**
     * 防止克隆破坏单例模式
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws CloneNotSupportedException
     */
    @Test
    public void testPreventCloneDestructionSingleton() throws IOException,
            ClassNotFoundException, CloneNotSupportedException {
        ThreadSafeEagerSingleton instance = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton newInstance = (ThreadSafeEagerSingleton) instance.clone();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }

    /**
     * 防止反射破坏单例模式
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws CloneNotSupportedException
     */
    @Test
    public void testPreventReflectDestructionSingleton() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        ThreadSafeEagerSingleton instance = ThreadSafeEagerSingleton.getInstance();
        Class<ThreadSafeEagerSingleton> threadSafeEagerSingletonClass = ThreadSafeEagerSingleton.class;
        // 获取构造方法
        Constructor<ThreadSafeEagerSingleton> constructor = threadSafeEagerSingletonClass.getDeclaredConstructor();
        // 修改构造方法的访问性
        constructor.setAccessible(true);
        ThreadSafeEagerSingleton newInstance = constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }

    /**
     * 线程安全的枚举实现单例
     */
    @Test
    public void testThreadSafeEagerSingletonByEnum() {
        ThreadSafeEagerSingletonByEnum instance = ThreadSafeEagerSingletonByEnum.getInstance();
        ThreadSafeEagerSingletonByEnum newInstance = ThreadSafeEagerSingletonByEnum.getInstance();
        instance.action();
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance.compareTo(newInstance));
    }

    /**
     * 线程安全的枚举实现单例
     */
    @Test
    public void testThreadSafeThreadLocalSingleton() {
        System.out.println(ThreadSafeThreadLocalSingleton.getInstance());
        System.out.println(ThreadSafeThreadLocalSingleton.getInstance());
        System.out.println(ThreadSafeThreadLocalSingleton.getInstance());
        System.out.println(ThreadSafeThreadLocalSingleton.getInstance());
        System.out.println(ThreadSafeThreadLocalSingleton.getInstance());
        Thread subThread = new Thread(
                ()-> System.out.println(ThreadSafeThreadLocalSingleton.getInstance()),"subThread");
        subThread.start();
    }

}
