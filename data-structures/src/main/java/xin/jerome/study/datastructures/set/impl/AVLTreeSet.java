package xin.jerome.study.datastructures.set.impl;

import xin.jerome.study.datastructures.set.MySet;
import xin.jerome.study.datastructures.tree.AVLTree;

/**
 * 集合 {@link MySet} 的AVL树 {@link AVLTree} 实现
 *
 * @author Jerome Zhu
 * @since 2019.07.31 22:01
 */
public class AVLTreeSet<E extends Comparable<E>> implements MySet<E> {

    private AVLTree<E, Object> avlTree;

    public static final Object PRESENT = new Object();

    public AVLTreeSet() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e, PRESENT);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.size();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
