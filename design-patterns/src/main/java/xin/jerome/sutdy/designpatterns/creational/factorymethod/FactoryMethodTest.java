package xin.jerome.sutdy.designpatterns.creational.factorymethod;

import org.junit.Test;

/**
 * 工厂方法
 *
 * @author JeromeSoar
 * @since 2020年 11月 17日 18:40
 */
public class FactoryMethodTest {

    @Test
    public void testSellFruits() {
        // 水果商店 -> 柠檬专卖
        FruitsStore fruitsStore = new LemonStore();
        // 销售柠檬
        Fruits fruits = fruitsStore.sellFruits();
        // 检查柠檬库存
        fruits.checkInventory();
    }

    @Test
    public void testSellBanana() {
        // 水果商店 -> 香蕉专卖
        FruitsStore fruitsStore = new BananaStore();
        // 销售香蕉
        Fruits fruits = fruitsStore.sellFruits();
        // 检查香蕉库存
        fruits.checkInventory();
    }
}
