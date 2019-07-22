package xin.jerome.study.datastructures.unionfind;

/**
 * 并查集接口
 * <p>
 * 并查集是一种树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。 <br>
 * 有一个联合-查找算法（union-find algorithm）定义了两个用于此数据结构的操作：
 *
 * Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。 <br>
 * Union：将两个子集合并成同一个集合。
 *
 * @author Jerome Zhu
 * @since 2019.07.21 21:53
 */
public interface MyUnionFind {

    /**
     * 将两个元素合并
     * 
     * @param p
     *            元素节点
     * @param q
     *            另一个元素节点
     */
    void unionElements(int p, int q);

    /**
     * 检查两个元素是否所属同一个集合
     * 
     * @param p
     *            元素节点
     * @param q
     *            另一个元素节点
     * @return 如果两个元素所属同一个集合,返回true;否则,返回false.
     */
    boolean isConnected(int p, int q);

    /**
     * 获取节点中元素的个数
     * 
     * @return 返回元素的数量
     */
    int size();
}
