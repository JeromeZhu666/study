package xin.jerome.sutdy.design.patterns.creational.abstractfactory;

/**
 * 美的冰箱
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:37
 */
public class MideaRefrigerator extends Refrigerator {

    @Override
    void running() {
        System.out.println("This is Midea refrigerator.");
    }
}
