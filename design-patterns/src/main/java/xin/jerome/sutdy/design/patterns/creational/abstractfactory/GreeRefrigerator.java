package xin.jerome.sutdy.design.patterns.creational.abstractfactory;

/**
 * 格力冰箱
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:34
 */
public class GreeRefrigerator extends Refrigerator {

    @Override
    void running() {
        System.out.println("This is Gree refrigerator.");
    }
}
