package xin.jerome.sutdy.designpatterns.principle.singleresponsibility;

/**
 * 改造鸟类
 *
 * @author Jerome Zhu
 * @since 2019年12月08日 18:11
 */
public abstract class RemouldBird {
    public String birdName;

    public RemouldBird(String birdName) {
        this.birdName = birdName;
    }

    /** 移动 */
    public abstract void move();
}
