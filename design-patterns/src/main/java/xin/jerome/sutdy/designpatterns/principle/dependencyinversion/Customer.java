package xin.jerome.sutdy.designpatterns.principle.dependencyinversion;

/**
 * 顾客
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 22:21
 */
public class Customer {

    /**
     * 吃一个苹果
     */
    public void eatApple() {
        System.out.println("吃一个苹果!");
    }

    /**
     * 吃一个柠檬
     */
    public void eatLemon() {
        System.out.println("吃一个柠檬!");
    }

    /**
     * 吃水果
     */
    public void eatFruits(EatFruits eatFruits) {
        eatFruits.eatFruits();
    }
}
