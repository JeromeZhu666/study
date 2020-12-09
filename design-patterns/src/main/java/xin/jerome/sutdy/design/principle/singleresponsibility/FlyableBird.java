package xin.jerome.sutdy.design.principle.singleresponsibility;

/**
 * 可以飞的鸟
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 18:16
 */
public class FlyableBird extends AbstractBird {

    public FlyableBird(String birdName) {
        super(birdName);
    }

    @Override
    public void move() {
        System.out.println(super.birdName + ": 在天上飞.");
    }
}
