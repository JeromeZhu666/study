package xin.jerome.sutdy.design.patterns.creational.abstractfactory;

/**
 * 格力电器
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:31
 */
public class GreeElectricAppliance implements ElectricAppliance {
    @Override
    public Refrigerator produceRefrigerator() {
        return new GreeRefrigerator();
    }

    @Override
    public AirConditioner produceAirConditioner() {
        return new GreeAirConditioner();
    }
}
