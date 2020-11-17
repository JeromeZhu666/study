package xin.jerome.sutdy.designpatterns.creational.factorymethod;


/**
 * 柠檬商店
 *
 * @author JeromeSoar
 * @since 2020年 11月 17日 18:51
 */
public class LemonStore implements FruitsStore {

    @Override
    public Fruits sellFruits() {
        System.out.println("售卖柠檬");
        return new Lemon();
    }
}
