package xin.jerome.sutdy.design.principle.dependencyinversion;

/**
 * 吃柠檬
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 22:29
 */
public class EatLemon implements EatFruits {

    @Override
    public void eatFruits() {
        System.out.println("吃一个柠檬!");
    }
}
