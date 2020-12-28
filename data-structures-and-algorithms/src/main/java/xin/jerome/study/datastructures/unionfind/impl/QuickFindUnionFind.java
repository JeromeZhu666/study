package xin.jerome.study.datastructures.unionfind.impl;

import xin.jerome.study.datastructures.unionfind.MyUnionFind;

/**
 * 快查的并查集 {@link MyUnionFind} 的实现 <br>
 * 查找的时间复杂度为 O(1) , 合并的时间复杂度为 O(n).
 *
 * @author Jerome Zhu
 * @since 2019.07.21 22:24
 */
public class QuickFindUnionFind implements MyUnionFind {

    private int[] ids;

    public QuickFindUnionFind(int size) {
        ids = new int[size];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        // 将所有pId集合标记为qId的集合

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) {
                ids[i] = qId;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 查找元素 e 所对应的集合编号
     * 
     * @param e
     *            待验证的元素
     * @return 元素 e 所对应的集合编号
     */
    private int find(int e) {
        if (e < 0 || e > ids.length) {
            throw new IllegalArgumentException("Element e is not exist.");
        }
        return ids[e];
    }

    @Override
    public int size() {
        return ids.length;
    }
}
