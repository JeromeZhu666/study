package xin.jerome.sutdy.designpatterns.creational.simplefactory;

/**
 * 水果商店
 *
 * @author Jerome Zhu
 * @since 2019.08.03 16:55
 */
public class FruitsStore {

    /** 苹果 */
    public static final String APPLE = "apple";

    /** 柠檬 */
    public static final String LEMON = "lemon";

    /** 根据水果的名字,获得水果 */
    public static Fruits getFruitsByName(String fruitsName) {
        if (APPLE.equalsIgnoreCase(fruitsName)) {
            return new Apple();
        } else if (LEMON.equalsIgnoreCase(fruitsName)) {
            return new Lemon();
        }
        return null;
    }

    /** 根据水果的源产地获取水果 */
    public static Fruits getFruitsByClassName(String fruitsClassName) {
        Fruits fruits = null;
        try {
            fruits = (Fruits)Class.forName(fruitsClassName).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return fruits;
    }
}
