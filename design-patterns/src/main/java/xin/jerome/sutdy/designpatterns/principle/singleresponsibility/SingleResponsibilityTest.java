package xin.jerome.sutdy.designpatterns.principle.singleresponsibility;

import org.junit.Test;

/**
 * 单一职责测试
 *
 * 单一职责原则 : 规定每个类都应该有一个单一的功能,并且该功能应该由这个类完全封装起来.一个类或者模块应该有且只有一个改变的原因.
 * 即,方法定义的粒度越细,当有需求变更时受到的影响越小.
 *
 * 举例描述 : 鸟类的移动方式,并不是所有的鸟都是能飞的.例: 鸵鸟和企鹅都是地上跑的;野鸭是在水里游的.
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 16:28
 */
public class SingleResponsibilityTest {

    /**
     * 测试单一原则之前的逻辑
     */
    @Test
    public void testSingleResponsibilityBefore() {
        // 鹦鹉
        Bird parrot = new Bird("鹦鹉");
        parrot.move(); // 鹦鹉: 在天上飞.
        // 企鹅
        Bird penguin = new Bird("企鹅");
        penguin.move(); // 企鹅: 在天上飞.
        // 这里企鹅用翅膀飞已经违背的原则,这时就需要改造 Bird 类.
        // ps : 如果这个时候再来个 在水里游得野鸭 , 又要改造原有逻辑 , 而且相互之间会有影响
    }

    @Test
    public void testSingleResponsibility() {
        // 鹦鹉
        AbstractBird parrot = new FlyableBird("鹦鹉");
        parrot.move(); // 鹦鹉: 在天上飞.
        // 企鹅
        AbstractBird penguin = new RunnableBird("企鹅");
        penguin.move(); // 企鹅: 在地上跑.
        // 野鸭
        AbstractBird mallard = new SwimmableBird("野鸭");
        mallard.move(); // 野鸭: 在水里游.
    }
}
