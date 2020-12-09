package xin.jerome.sutdy.design.patterns.creational.factorymethod;

/**
 * 香蕉商店
 *
 * @author JeromeSoar
 * @since 2020年 11月 17日 18:56
 */
public class BananaStore implements FruitsStore {
    @Override
    public Fruits sellFruits() {
        System.out.println("售卖香蕉");
        return new Banana();
    }
}
