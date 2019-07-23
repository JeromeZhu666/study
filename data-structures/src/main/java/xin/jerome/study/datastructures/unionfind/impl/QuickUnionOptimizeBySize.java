package xin.jerome.study.datastructures.unionfind.impl;

import xin.jerome.study.datastructures.unionfind.MyUnionFind;

/**
 * 快速合并的并查集 {@link QuickUnionUnionFind} , 基于集合中的size的优化.
 *
 * @author Jerome Zhu
 * @since 2019.07.23 07:46
 */
public class QuickUnionOptimizeBySize implements MyUnionFind {

    private int[] parents;
    /**
     * 用于存储集合中元素的个数
     */
    private int[] sizes;

    public QuickUnionOptimizeBySize(int size) {
        parents = new int[size];
        sizes = new int[size];
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

        if (sizes[pRoot] < sizes[qRoot]) {
            // 如果集合 p 中的元素比集合 q 中的元素少,就将集合 p 合并到集合 q 中.
            parents[pRoot] = qRoot;
            // 维护 sizes[qRoot] , 集合 q 中的元素增多了.
            sizes[qRoot] += sizes[pRoot];
        } else {
            parents[qRoot] = pRoot;
            sizes[pRoot] += sizes[qRoot];
        }
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
