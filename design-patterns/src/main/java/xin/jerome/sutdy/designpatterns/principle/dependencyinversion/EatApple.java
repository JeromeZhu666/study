package xin.jerome.sutdy.designpatterns.principle.dependencyinversion;

/**
 * 吃苹果
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 22:28
 */
public class EatApple implements EatFruits {

    @Override
    public void eatFruits() {
        System.out.println("吃一个苹果!");
    }
}
