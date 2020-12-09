package xin.jerome.sutdy.design.principle.dependencyinversion;

import org.junit.Test;

/**
 * 依赖倒置(反转)原则
 *
 * 依赖倒置(反转)原则 : 高层次的模块不依赖于低层次的模块的实现细节,依赖关系被颠倒(反转),从而使得低层次模块依赖于高层次模块的需求抽象.
 * 原则规定:
 *   1.高层次的模块不应该依赖于低层次的模块,两者都应该依赖于抽象接口.
 *   2.抽象接口不应该依赖于具体实现.而具体实现则应该依赖于抽象接口.
 *
 * 优点:可以减少类间的耦合性、提高系统稳定性,提高代码可读性和可维护性,可降低修改程序所造成的风险.
 *
 * 举例描述 : 一名顾客准备吃水果,但是顾客并没有确定吃哪些水果,都是间断性提出来的.
 * 
 * @author Jerome Zhu
 * @since 2019年12月10日 22:10
 */
public class DependencyInversionTest {

    @Test
    public void testDependencyInversionBefore() {
        // 顾客准备吃点水果
        Customer customer = new Customer();
        // 吃一个苹果
        customer.eatApple();
        // 吃一个香蕉
        customer.eatLemon();
        // 如果顾客还想吃香蕉,就得去 Customer 类里面去添加 , 这是面向过程编程没有面向对象编程.
    }

    @Test
    public void testDependencyInversion() {
        // 顾客准备吃点水果
        Customer customer = new Customer();
        // 吃一个苹果
        customer.eatFruits(new EatApple());
        // 吃一个香蕉
        customer.eatFruits(new EatLemon());
        // 如果顾客还想吃香蕉, 不需要动 Customer 类 和 EatFruits 接口
        // 只需新增一个实现 , 应用层调用一下就可以了
        customer.eatFruits(new EatBanana());
    }
}
