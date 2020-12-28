package xin.jerome.study.datastructures.set;

/**
 * 自定义集合接口
 *
 * @author Jerome Zhu
 * @since 2019.06.23 19:55
 */
public interface MySet<E> {
    /**
     * 向集合中添加一个元素，不能添加重复元素
     *
     * @param e 将要添加进集合的元素
     */
    void add(E e);

    /**
     * 删除集合中的一个元素
     *
     * @param e 待删除的元素
     */
    void remove(E e);

    /**
     * 判断当前集合中是否包含待验证元素
     *
     * @param e 待验证的元素
     * @return 布尔值验证结果
     */
    boolean contains(E e);

    /**
     * 获取当前集合中元素的个数
     *
     * @return 个数
     */
    int getSize();

    /**
     * 判断当前集合是否为空
     *
     * @return 布尔值验证结果
     */
    boolean isEmpty();
}
