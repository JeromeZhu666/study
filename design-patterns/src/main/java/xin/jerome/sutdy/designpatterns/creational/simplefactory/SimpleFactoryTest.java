package xin.jerome.sutdy.designpatterns.creational.simplefactory;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * 简单工厂测试
 * 
 * 简单工厂(静态工厂方法),它属于类创建型模式.在简单工厂模式中,可以根据参数的不同返回不同类的实例.
 * 简单工厂模式专门定义一个类来负责创建其他类的实例,被创建的实例通常都具有共同的父类(接口或抽象类).
 *
 * @author Jerome Zhu
 * @since 2019.08.03 16:16
 */
public class SimpleFactoryTest {

    Logger logger = Logger.getLogger(SimpleFactoryTest.class.getSimpleName());

    @Test
    public void testGetFruitsByName() {
        // 才弟给水果店老板说给我来个苹果
        Fruits apple = FruitsStore.getFruitsByName("apple");
        logger.info(String.format("尝一尝苹果的味道 : %s", apple.taste()));
        // 才弟觉得苹果很甜,吃的好爽,又说再来个柠檬
        Fruits lemon = FruitsStore.getFruitsByName("lemon");
        logger.info(String.format("尝一尝柠檬的味道 : %s", lemon.taste()));
        // 才弟觉得味道不错,又给服务员说再给我来个香蕉
        Fruits banana = FruitsStore.getFruitsByName("banana");
        if (banana == null) {
            logger.info("店里香蕉卖完了,下次来就有了！");
            return;
        }
    }

    @Test
    public void testGetFruitsByClassName() {
        // 才弟再次来到水果店,看到老板说我想不起来水果叫什么了,但是我知道它的源产地,好像是山东烟台.
        Fruits apple = FruitsStore.getFruitsByClassName(Apple.class.getName());
        logger.info(String.format("尝一尝苹果的味道 : %s", apple.taste()));
    }
}
