package xin.jerome.sutdy.design.patterns.behavioral.strategy;

import org.junit.Test;

/**
 * 策略模式测试
 *
 * 策略模式 : 指对象有某个行为,但是在不同的场景中,该行为有不同的实现算法.
 *
 * 举例描述 : 一家拥有会员制度的商场,最近搞促销活动,针对不同的顾客(会员)实施不同的促销力度.
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 14:18
 */
public class StrategyTest {

    /**
     * 简单策略模式的实现 : 针对不同的会员级别有有不同的策略实现
     */
    @Test
    public void testPromotionStrategy() {
        // 非会员
        PromotionExecutor nonMemberExecutor = new PromotionExecutor(new NonPromotion());
        nonMemberExecutor.execute();
        // 黄金会员
        PromotionExecutor goldMemberExecutor = new PromotionExecutor(new DiscountPromotion());
        goldMemberExecutor.execute();
        // 钻石会员
        PromotionExecutor diamondMemberExecutor = new PromotionExecutor(new FreeOrderPromotion());
        diamondMemberExecutor.execute();
    }

    /**
     * 简单策略模式+简单工厂的实现 : 针对不同的会员级别有有不同的策略实现
     */
    @Test
    public void testPromotionStrategyFactory() {
        // 非会员
        String nonMember = "nonMember";
        // 黄金会员
        String goldMember = "goldMember";
        // 钻石会员
        String diamondMember = "diamondMember";
        PromotionExecutor nonMemberExecutor = new PromotionExecutor(PromotionStrategyFactory.getPromotionStrategy(diamondMember));
        nonMemberExecutor.execute();
    }
}
