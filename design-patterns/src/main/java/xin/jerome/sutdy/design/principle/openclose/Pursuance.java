package xin.jerome.sutdy.design.principle.openclose;

/**
 * 追求 : 每个人不同年龄有不同追求,但是在为当前追求努力的时候,也可以同时关心着别的方向.
 *
 * @author Jerome Zhu
 * @since 2019.08.03 08:58
 */
public interface Pursuance {

    /**
     * 人名
     * 
     * @return 当前人的名字
     */
    String getName();

    /**
     * 年龄
     * 
     * @return 当前人的年龄
     */
    Integer getAge();

    /**
     * 当前追求
     * 
     * @return 当下的追求
     */
    String getCurrentPursuance();

}
