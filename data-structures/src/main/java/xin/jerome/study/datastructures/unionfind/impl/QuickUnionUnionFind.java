package xin.jerome.study.datastructures.unionfind.impl;

import xin.jerome.study.datastructures.unionfind.MyUnionFind;

/**
 * 快速合并的并查集 {@link MyUnionFind} 的实现
 *
 * @author Jerome Zhu
 * @since 2019.07.22 08:13
 */
public class QuickUnionUnionFind implements MyUnionFind {

    private int[] parents;

    public QuickUnionUnionFind(int size) {
        parents = new int[size];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) {
            return;
        }

        parents[qRoot] = pRoot;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    /**
     * 查询元素 p 的根节点 时间复杂度为 O(h) , h为树的高度
     * 
     * @param p
     *            查询的元素
     * @return 元素 p 的根节点
     */
    private int findRoot(int p) {
        if (p < 0 || p > parents.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }

    @Override
    public int size() {
        return parents.length;
    }
}
