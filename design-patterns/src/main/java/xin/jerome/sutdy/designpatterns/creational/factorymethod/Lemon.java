package xin.jerome.sutdy.designpatterns.creational.factorymethod;

/**
 * 柠檬
 *
 * @author JeromeSoar
 * @since 2020年 11月 17日 18:52
 */
public class Lemon extends Fruits{

    @Override
    void checkInventory() {
        System.out.println("柠檬已售罄！");
    }
}
