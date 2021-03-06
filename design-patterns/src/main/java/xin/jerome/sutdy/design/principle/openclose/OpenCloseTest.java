package xin.jerome.sutdy.design.principle.openclose;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * 开闭原则的测试
 *
 * 开闭原则 : 软件中的对象(类,模块,函数等等)应该对于扩展是开放的,但是对于修改是封闭的.
 *
 * 梅耶开闭原则 : 一个类的实现只应该因错误而修改,新的或者改变的特性应该通过新建不同的类实现.<br>
 * 新建的类可以通过继承的方式来重用原类的代码.
 *
 * 多态开闭原则 : 多态开闭原则的定义倡导对抽象基类的继承.接口规约可以通过继承来重用,但是实现不必重用.<br>
 * 已存在的接口对于修改是封闭的,并且新的实现必须,实现原来的那个接口.
 *
 * 举例描述 : 一名大四学生才弟,当下在准备考取研究生,临近考试时又准备面试大厂检验一下自己.
 *
 * @author Jerome Zhu
 * @since 2019.08.03 09:21
 */
public class OpenCloseTest {

    Logger logger = Logger.getLogger(OpenCloseTest.class.getSimpleName());

    /** 测试一个人的追求 */
    @Test
    public void testPursuance() {
        // 才弟已经23岁了,大四学生.他当下的追求就是考取研究生.
        Pursuance pursuance = new StudentPursuance("才弟", 23, "考取研究生");
        logger.info(pursuance.toString());
        // 不知不觉已经11月份了,距离考研就剩一个月时间,才弟周围没考研的同学已经拿到了大厂的offer.
        // 此时,才弟害怕自己考研失利最后一无所获.所以才弟在准备考研的同时,想关注一下大厂的招聘机会.
        logger.info("才弟的需求变了,他想考研的同时(修改封闭的),尝试能否获取大厂offer(拓展开放).");
        pursuance = new StudentAnotherPursuance(pursuance, "获取阿里offer");
        logger.info(pursuance.toString());
    }

}
