package xin.jerome.sutdy.designpatterns.principle.openclose;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * 开闭原则的测试
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
