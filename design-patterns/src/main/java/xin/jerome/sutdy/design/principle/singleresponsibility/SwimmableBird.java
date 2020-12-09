package xin.jerome.sutdy.design.principle.singleresponsibility;

/**
 * 可以游泳的鸟
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 18:27
 */
public class SwimmableBird extends AbstractBird {

    public SwimmableBird(String birdName) {
        super(birdName);
    }

    @Override
    public void move() {
        System.out.println(super.birdName + ": 在水里游.");
    }
}
