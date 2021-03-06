package xin.jerome.sutdy.design.principle.singleresponsibility;

/**
 * 可以跑的鸟
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 18:25
 */
public class RunnableBird extends AbstractBird {

    public RunnableBird(String birdName) {
        super(birdName);
    }

    @Override
    public void move() {
        System.out.println(super.birdName + ": 在地上跑.");
    }
}
