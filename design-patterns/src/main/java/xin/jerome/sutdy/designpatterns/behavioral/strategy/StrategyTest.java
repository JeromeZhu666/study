package xin.jerome.sutdy.designpatterns.behavioral.strategy;

import org.junit.Test;

/**
 * 策略模式测试
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
