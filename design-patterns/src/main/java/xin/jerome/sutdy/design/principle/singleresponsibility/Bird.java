package xin.jerome.sutdy.design.principle.singleresponsibility;

/**
 * 鸟 : 拥有移动的行为
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 17:27
 */
public class Bird {
    private String birdName;

    public Bird(String birdName) {
        this.birdName = birdName;
    }

    public void move() {
        System.out.println(birdName + ": 在天上飞.");
    }
}
