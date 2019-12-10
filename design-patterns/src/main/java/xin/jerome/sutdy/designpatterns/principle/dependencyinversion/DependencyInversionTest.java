package xin.jerome.sutdy.designpatterns.principle.dependencyinversion;

import org.junit.Test;

/**
 * 依赖倒置原则
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 22:10
 */
public class DependencyInversionTest {

    @Test
    public void testDependencyInversionBefore() {
        // 客户准备吃点水果
        Customer customer = new Customer();
        // 吃一个苹果
        customer.eatApple();
        // 吃一个香蕉
        customer.eatLemon();
        // 如果客户还想吃香蕉，就得去 Customer 类里面去添加 , 这是面向过程编程没有面向对象编程.
    }

    @Test
    public void testDependencyInversion() {
        // 客户准备吃点水果
        Customer customer = new Customer();
        // 吃一个苹果
        customer.eatFruits(new EatApple());
        // 吃一个香蕉
        customer.eatFruits(new EatLemon());
        // 如果客户还想吃香蕉, 不需要动 Customer 类 和 EatFruits 接口
        // 只需新增一个实现 , 应用层调用一下就可以了
        customer.eatFruits(new EatBanana());
    }
}
