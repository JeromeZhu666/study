package xin.jerome.sutdy.design.patterns.creational.factorymethod;

/**
 * 水果店
 *
 * @author JeromeSoar
 * @since 2020年 11月 17日 18:42
 */
public interface FruitsStore {

    /**
     * 销售水果
     * @return 返回售卖的水果
     */
    Fruits sellFruits();
}
