package xin.jerome.study.datastructures.unionfind.impl;

import xin.jerome.study.datastructures.unionfind.MyUnionFind;

/**
 * 快速合并的并查集 {@link QuickUnionUnionFind} , 基于 {@link QuickUnionOptimizeByRank} 深度优化,同时对集合深度进行压缩.
 *
 * @author Jerome Zhu
 * @since 2019.07.23 08:52
 */
public class QuickUnionOptimizeByPathCompression implements MyUnionFind {
    private int[] parents;
    /**
     * 用于存储集合树的排名,ranks[i]表示元素 i 所在集合树的排名,主要用于合并操作的一个参考. 由于添加了路径压缩,这里的ranks就不代表集合的深度.
     */
    private int[] ranks;

    public QuickUnionOptimizeByPathCompression(int size) {
        parents = new int[size];
        ranks = new int[size];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) {
            return;
        }

        if (ranks[pRoot] < ranks[qRoot]) {
            // 如果集合 p 中的深度比集合 q 中的深度小,就将集合 p 合并到集合 q 中,不用维护集合 q 的深度.
            parents[pRoot] = qRoot;
        } else if (ranks[pRoot] > ranks[qRoot]) {
            // 如果集合 p 中的深度比集合 q 中的深度大,就将集合 q 合并到集合 p 中,不用维护集合 p 的深度.
            parents[qRoot] = pRoot;
        } else {
            // 如果集合 p 中的深度和集合 q 中的深度相等,合并谁都一样,只是需要维护一下ranks.
            parents[qRoot] = pRoot;
            ranks[pRoot] += 1;
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
            // 将当前的节点的父节点,重置为父节点的父节点(向根节点靠拢).
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    @Override
    public int size() {
        return parents.length;
    }
}
