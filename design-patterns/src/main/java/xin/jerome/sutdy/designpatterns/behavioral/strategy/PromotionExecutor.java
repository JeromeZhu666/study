package xin.jerome.sutdy.designpatterns.behavioral.strategy;

/**
 * 策略的执行者
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 15:43
 */
public class PromotionExecutor {
    /**
     * 私有的策略属性，针对不同情况执行不同策略
     */
    private PromotionStrategy promotionStrategy;

    /**
     * 构造器注入具体实施的策略
     *
     * @param concretePromotionStrategy 具体的实施的优惠策略
     */
    public PromotionExecutor(PromotionStrategy concretePromotionStrategy) {
        this.promotionStrategy = concretePromotionStrategy;
    }

    /** 执行促销策略 */
    public void execute() {
        promotionStrategy.executePromotion();
    }
}
