package xin.jerome.sutdy.design.patterns.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品的促销策略 + 简单工厂实现
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 15:51
 */
public class PromotionStrategyFactory {

    /** 声明促销策略容器 : 用于存储目前已实现的所有的促销策略 */
    private static final Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    /** 非会员 */
    private static final String NON_MEMBER = "nonMember";
    /** 黄金会员 */
    private static final String GOLD_MEMBER = "goldMember";
    /** 钻石会员 */
    private static final String DIAMOND_MEMBER = "diamondMember";
    /** 没有促销策略 */
    private static final PromotionStrategy NON_PROMOTION = new NonPromotion();
    // 初始化所有的促销策略
    static {
        PROMOTION_STRATEGY_MAP.put(NON_MEMBER, NON_PROMOTION);
        PROMOTION_STRATEGY_MAP.put(GOLD_MEMBER, new DiscountPromotion());
        PROMOTION_STRATEGY_MAP.put(DIAMOND_MEMBER, new FreeOrderPromotion());
    }

    /**
     * 根据会员类型获取促销策略
     *
     * @param memberType 会员类型
     * @return 根据会员类型获取对应的促销策略，若不存在该类型，则返回 {@code NON_PROMOTION}
     */
    public static PromotionStrategy getPromotionStrategy(String memberType) {
        return PROMOTION_STRATEGY_MAP.getOrDefault(memberType, NON_PROMOTION);
    }
}
