package xin.jerome.study.datastructures.set.impl;

import xin.jerome.study.datastructures.set.MySet;
import xin.jerome.study.datastructures.tree.BinarySearchTree;

/**
 * 集合 {@link MySet} 的二分搜索树 {@link BinarySearchTree} 实现
 *
 * @author Jerome Zhu
 * @since 2019.06.23 20:05
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements MySet<E> {
    /**
     * 存放容器
     */
    private BinarySearchTree<E> bsTree;

    /**
     * 初始化容器
     */
    public BinarySearchTreeSet() {
        bsTree = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bsTree.add(e);
    }

    @Override
    public void remove(E e) {
        bsTree.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return bsTree.contains(e);
    }

    @Override
    public int getSize() {
        return bsTree.size();
    }

    @Override
    public boolean isEmpty() {
        return bsTree.isEmpty();
    }
}
