package xin.jerome.sutdy.designpatterns.creational.abstractfactory;

/**
 * 美的空调
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:38
 */
public class MideaAirConditioner extends AirConditioner {

    @Override
    void running() {
        System.out.println("This is Midea air conditioner.");
    }
}
