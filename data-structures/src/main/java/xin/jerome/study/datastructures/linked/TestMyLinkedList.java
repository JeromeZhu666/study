package xin.jerome.study.datastructures.linked;

import xin.jerome.study.datastructures.linked.impl.LinkedList;
import xin.jerome.study.datastructures.linked.impl.LinkedListDummyHead;

/**
 * 测试 {@link MyLinkedList} 的功能完整性
 *
 * @author Jerome Zhu
 * @since 2019.06.23 21:35
 */
public class TestMyLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        testMyLinkedListDelElement(list);
        System.out.println("-------------------");
        LinkedListDummyHead<Integer> listDummyHead = new LinkedListDummyHead<>();
        testMyLinkedListDelElement(listDummyHead);
    }

    /**
     * 测试链表删除指定元素
     * @param list 普通链表
     */
    private static void testMyLinkedListDelElement(MyLinkedList<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.addHead(i);
        }
        System.out.println(list);
        list.del(Integer.valueOf(0));
        System.out.println(list);
        list.del(Integer.valueOf(5));
        System.out.println(list);
        list.del(Integer.valueOf(9));
        System.out.println(list);
        list.del(Integer.valueOf(10));
        System.out.println(list);
    }

}
