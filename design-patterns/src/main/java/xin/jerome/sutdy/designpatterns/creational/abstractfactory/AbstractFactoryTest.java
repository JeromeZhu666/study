package xin.jerome.sutdy.designpatterns.creational.abstractfactory;

import org.junit.Test;

/**
 * 抽象工厂
 * 解决的是同一产品族的问题
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:17
 */
public class AbstractFactoryTest {

    @Test
    public void testElectricAppliance() {
        ElectricAppliance electricAppliance = new MideaElectricAppliance();
        AirConditioner airConditioner = electricAppliance.produceAirConditioner();
        airConditioner.running();
        Refrigerator refrigerator = electricAppliance.produceRefrigerator();
        refrigerator.running();
    }
}
