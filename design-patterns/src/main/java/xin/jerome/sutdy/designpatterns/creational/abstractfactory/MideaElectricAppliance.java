package xin.jerome.sutdy.designpatterns.creational.abstractfactory;

/**
 * 美的家电
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:36
 */
public class MideaElectricAppliance implements ElectricAppliance {
    @Override
    public Refrigerator produceRefrigerator() {
        return new MideaRefrigerator();
    }

    @Override
    public AirConditioner produceAirConditioner() {
        return new MideaAirConditioner();
    }
}
