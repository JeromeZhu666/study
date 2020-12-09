package xin.jerome.sutdy.design.patterns.creational.simplefactory;

/**
 * 苹果
 *
 * @author Jerome Zhu
 * @since 2019.08.03 17:00
 */
public class Apple implements Fruits {
    @Override
    public String taste() {
        return "苹果是甜的";
    }
}
