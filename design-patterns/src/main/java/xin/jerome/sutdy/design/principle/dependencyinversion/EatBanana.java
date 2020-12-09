package xin.jerome.sutdy.design.principle.dependencyinversion;

/**
 * 吃香蕉
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 22:32
 */
public class EatBanana implements EatFruits {

    @Override
    public void eatFruits() {
        System.out.println("吃一根香蕉!");
    }
}
