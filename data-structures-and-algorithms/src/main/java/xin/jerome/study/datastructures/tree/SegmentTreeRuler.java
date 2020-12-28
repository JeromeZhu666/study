package xin.jerome.study.datastructures.tree;

/**
 * 定义线段树中存储元素的规则接口
 *
 * @author Jerome Zhu
 * @since 2019.07.13 14:35
 */
public interface SegmentTreeRuler<E> {
    /**
     * 线段树中对节点值的存储规则,比如求和、最大值、最小值等.
     * 
     * @param left
     *            左孩子的值
     * @param right
     *            右孩子的值
     * @return 符合规则的值
     */
    E rule(E left, E right);
}
