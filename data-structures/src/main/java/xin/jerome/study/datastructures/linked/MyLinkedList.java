package xin.jerome.study.datastructures.linked;

/**
 * 自定义链表接口
 *
 * @author Jerome Zhu
 * @since 2019.06.23 22:01
 */
public interface MyLinkedList<E> {

    /**
     * 向链表头添加元素
     *
     * @param e 添加的元素
     */
    void addHead(E e);

    /**
     * 删除指定的元素
     *
     * @param e 指定元素e
     */
    void del(E e);

}
