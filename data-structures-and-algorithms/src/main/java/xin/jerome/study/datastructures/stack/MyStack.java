package xin.jerome.study.datastructures.stack;

/**
 * 自定义 stack 接口
 * 栈(堆栈): 是允许在同一端进行插入和删除操作的特殊线性表.
 * 栈也叫做先进后出(FILO-First in last out)的线性表.
 *
 * @author Jerome Zhu
 * @since 2018.10.23 20:27
 */
public interface MyStack<E> {

    /**
     * 向栈中添加一个元素
     * @param e 需要添加的元素
     */
    void push(E e);

    /**
     * 栈顶元素出栈
     * @return 栈顶的元素 E
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return 栈顶的元素 E
     */
    E peek();

    /**
     * 获取栈的大小
     * @return 元素个数
     */
    int size();

    /**
     * 判断栈是否为空
     * @return true or false
     */
    boolean isEmpty();

}
