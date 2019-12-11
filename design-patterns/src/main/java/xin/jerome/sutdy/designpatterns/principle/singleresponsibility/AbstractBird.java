package xin.jerome.sutdy.designpatterns.principle.singleresponsibility;

/**
 * 抽象出鸟类的共性
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 18:11
 */
public abstract class AbstractBird {
    public String birdName;

    public AbstractBird(String birdName) {
        this.birdName = birdName;
    }

    /** 移动 */
    public abstract void move();
}
