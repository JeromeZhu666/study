package xin.jerome.sutdy.design.patterns.creational.abstractfactory;

/**
 * 家电
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 08:25
 */
public interface ElectricAppliance {

    /**
     * 生产冰箱
     *
     * @return 具体的冰箱对象
     */
    Refrigerator produceRefrigerator();

    /**
     * 生产空调
     *
     * @return 具体的空调对象
     */
    AirConditioner produceAirConditioner();
}
