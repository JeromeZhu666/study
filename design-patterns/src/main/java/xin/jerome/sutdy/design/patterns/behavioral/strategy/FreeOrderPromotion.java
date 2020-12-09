package xin.jerome.sutdy.design.patterns.behavioral.strategy;

/**
 * 商品的免单促销策略
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 15:26
 */
public class FreeOrderPromotion implements PromotionStrategy {
    @Override
    public void executePromotion() {
        System.out.println("商品的免单策略:钻石会员1000元内免单!");
    }
}
