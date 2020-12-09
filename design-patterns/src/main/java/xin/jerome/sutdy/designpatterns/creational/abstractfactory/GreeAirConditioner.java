package xin.jerome.sutdy.designpatterns.creational.abstractfactory;

/**
 * 格力空调
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:34
 */
public class GreeAirConditioner extends AirConditioner {

    @Override
    void running() {
        System.out.println("This is Gree air conditioner.");
    }
}
