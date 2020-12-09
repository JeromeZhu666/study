package xin.jerome.sutdy.design.patterns.creational.factorymethod;

/**
 * 香蕉
 *
 * @author JeromeSoar
 * @since 2020年 11月 17日 18:55
 */
public class Banana extends Fruits {

    @Override
    void checkInventory() {
        System.out.println("加把劲，香蕉还有一半库存！");
    }
}
