package xin.jerome.sutdy.design.patterns.behavioral.strategy;

/**
 * 商品没有促销策略
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 15:31
 */
public class NonPromotion implements PromotionStrategy {
    @Override
    public void executePromotion() {
        System.out.println("没有促销策略:非会员商品原价销售,没有促销!");
    }
}
