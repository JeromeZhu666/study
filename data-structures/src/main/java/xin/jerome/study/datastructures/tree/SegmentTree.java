package xin.jerome.study.datastructures.tree;

import java.util.Arrays;

/**
 * 自定义线段树
 *
 * @author Jerome Zhu
 * @since 2019.07.11 21:22
 */
public class SegmentTree<E> {

    /**
     * 用于存放树结构相关的信息
     */
    private E[] tree;
    /**
     * 用于存放数据相关的信息
     */
    private E[] data;
    /**
     * 线段树中存储元素的规则
     */
    private SegmentTreeRuler<E> ruler;

    public SegmentTree() {}

    public SegmentTree(E[] arr, SegmentTreeRuler<E> ruler) {
        this.ruler = ruler;
        data = arr;
        tree = (E[])new Object[arr.length * 4];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * 构建线段树,区间[left,right]的值
     * 
     * @param rootIndex
     *            根节点所在索引
     * @param left
     *            区间的左端点
     * @param right
     *            区间的右端点
     */
    private void buildSegmentTree(int rootIndex, int left, int right) {
        // 区间的大小为1,即left = right
        if (left == right) {
            tree[rootIndex] = data[left];
            return;
        }

        // 获取左右子树和中间索引的值
        int leftChild = leftChild(rootIndex);
        int rightChild = rightChild(rootIndex);
        int midIndex = left + (right - left) / 2;
        // 构建左右子树
        buildSegmentTree(leftChild, left, midIndex);
        buildSegmentTree(rightChild, midIndex + 1, right);
        // 存储rootIndex位置,符合存储规则的应有的值
        tree[rootIndex] = ruler.rule(tree[leftChild], tree[rightChild]);
    }

    /**
     * 查询[queryLeft,queryRight]区间的结果
     *
     * @param queryLeft
     *            查询区间左端点
     * @param queryRight
     *            查询区间右端点
     * @return 区间[queryLeft,queryRight]的结果
     */
    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= data.length || queryRight < 0 || queryRight >= data.length
            || queryLeft > queryRight) {
            throw new IllegalArgumentException("index is illegal.");
        }
        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    /**
     * 查询[left,right]区间中,符合条件的[queryLeft,queryRight]区间的结果 O(log n)
     * 
     * @param treeIndex
     *            当前区间在分段树中的索引
     * @param left
     *            区间左端点
     * @param right
     *            区间右端点
     * @param queryLeft
     *            查询区间左端点
     * @param queryRight
     *            查询区间右端点
     * @return 区间[queryLeft,queryRight]的结果
     */
    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        // 区间刚好命中,直接返回当前节点的值
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }

        // 递归条件
        int mid = left + (right - left) / 2;
        // 待查区间在左子区间中
        if (queryRight < mid + 1) {
            return query(leftChild(treeIndex), left, mid, queryLeft, queryRight);
        }
        // 待查区间在右子区间中
        if (queryLeft > mid) {
            return query(rightChild(treeIndex), mid + 1, right, queryLeft, queryRight);
        }
        // 待查区间两个自区间都有涉及
        E leftResult = query(leftChild(treeIndex), left, mid, queryLeft, mid);
        E rightResult = query(rightChild(treeIndex), mid + 1, right, mid + 1, queryRight);
        return ruler.rule(leftResult, rightResult);
    }

    /**
     * 更新index位置的元素
     * 
     * @param index
     *            元素位置
     * @param val
     *            元素值
     */
    public void set(int index, E val) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal.");
        }
        // 更新数组中元素值
        data[index] = val;
        // 更新线段树中的元素值
        set(0, 0, data.length - 1, index, val);
    }

    /**
     * 更新区间[left,right]中,index位置的元素值 O(log n)
     * 
     * @param treeIndex
     *            当前区间的在线段树中的索引位置
     * @param left
     *            区间上限
     * @param right
     *            区间下限
     * @param index
     *            指定位置
     * @param val
     *            更新的新值
     */
    private void set(int treeIndex, int left, int right, int index, E val) {
        // 基础问题,正好命中该节点
        if (left == right) {
            tree[treeIndex] = val;
            return;
        }

        // 中间索引
        int mid = left + (right - left) / 2;
        // 命中左区间
        if (index < mid + 1) {
            set(leftChild(treeIndex), left, mid, index, val);
        }
        // 命中右区间
        if (index > mid) {
            set(rightChild(treeIndex), mid + 1, right, index, val);
        }
        // 重新按照规则,对本节点进行赋值
        tree[treeIndex] = ruler.rule(tree[leftChild(treeIndex)], tree[rightChild(treeIndex)]);
    }

    /**
     * 获取线段树大小,即存放元素个数
     */
    public int size() {
        return data.length;
    }

    /**
     * 获取 index 位置所在的元素
     *
     * @param index
     *            指定位置
     * @return index 位置的值
     */
    public E getIndex(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取指定节点左孩子的索引
     *
     * @param parent
     *            父节点的索引
     * @return 左孩子节点的值
     */
    public int leftChild(int parent) {
        return parent * 2 + 1;
    }

    /**
     * 获取指定节点左孩子的索引
     *
     * @param parent
     *            父节点的索引
     * @return 左孩子节点的值
     */
    public int rightChild(int parent) {
        return parent * 2 + 2;
    }

    @Override
    public String toString() {
        return "SegmentTree{" + Arrays.toString(tree) + '}';
    }
}
