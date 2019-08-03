package xin.jerome.sutdy.designpatterns.creational.simplefactory;

/**
 * 柠檬
 *
 * @author Jerome Zhu
 * @since 2019.08.03 17:01
 */
public class Lemon implements Fruits {
    @Override
    public String taste() {
        return "柠檬是酸的";
    }
}
