package xin.jerome.study.datastructures.map.impl;

import xin.jerome.study.datastructures.map.MyMap;
import xin.jerome.study.datastructures.tree.AVLTree;

/**
 * 映射 {@link MyMap} 的AVL树的实现
 *
 * @author Jerome Zhu
 * @since 2019.07.25 08:22
 */
public class AVLTreeMap<K extends Comparable<K>, V> implements MyMap<K, V> {

    private AVLTree<K, V> avlTree;

    public AVLTreeMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void put(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key, value);
    }

    @Override
    public int size() {
        return avlTree.size();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    /**
     * 判断当前AVL树是否是二分搜索树
     */
    public boolean isBST() {
        return avlTree.isBST();
    }

    /** 判断AVL树是否是平衡的 */
    public boolean isBalance() {
        return avlTree.isBalance();
    }
}
