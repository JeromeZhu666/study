package xin.jerome.sutdy.designpatterns.behavioral.strategy;

/**
 * 商品的折扣促销策略
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 15:24
 */
public class DiscountPromotion implements PromotionStrategy{
    @Override
    public void executePromotion() {
        System.out.println("商品的折扣策略:黄金会员全场商品九折!");
    }
}
