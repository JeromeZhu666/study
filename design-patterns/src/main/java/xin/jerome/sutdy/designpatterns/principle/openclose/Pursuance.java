package xin.jerome.sutdy.designpatterns.principle.openclose;

/**
 * 追求 : 每个人不同年龄有不同追求,但是在为当前追求努力的时候,也可以同时关心着别的方向.
 * 
 * 开闭原则 : 软件中的对象(类,模块,函数等等)应该对于扩展是开放的,但是对于修改是封闭的.
 * 
 * 梅耶开闭原则 : 一个类的实现只应该因错误而修改,新的或者改变的特性应该通过新建不同的类实现.<br>
 * 新建的类可以通过继承的方式来重用原类的代码.
 * 
 * 多态开闭原则 : 多态开闭原则的定义倡导对抽象基类的继承.接口规约可以通过继承来重用,但是实现不必重用.<br>
 * 已存在的接口对于修改是封闭的,并且新的实现必须,至少,实现那个接口.
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
