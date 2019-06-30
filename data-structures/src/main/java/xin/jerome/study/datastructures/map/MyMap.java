package xin.jerome.study.datastructures.map;

/**
 * 自定义Map
 *
 * @author Jerome Zhu
 * @since 2019.06.30 17:47
 */
public interface MyMap<K, V> {

    /**
     * 向Map中添加元素
     *
     * @param key   key值
     * @param value value值
     */
    void put(K key, V value);

    /**
     * 删除指定key的元素
     *
     * @param key key值
     * @return 删除的key对应的value
     */
    V remove(K key);

    /**
     * 判断Map中是否包含Key
     *
     * @param key key值
     * @return 布尔值
     */
    boolean contains(K key);

    /**
     * 获取指定key所对应的value值
     *
     * @param key key值
     * @return key值所对应的value
     */
    V get(K key);

    /**
     * 更新指定key的value值
     *
     * @param key   key值
     * @param value 新的value值
     */
    void set(K key, V value);

    /**
     * 获取当前Map中元素的个数
     *
     * @return 元素个数
     */
    int size();

    /**
     * 判断当前Map是否为空
     *
     * @return 如果为空返回true
     */
    boolean isEmpty();

}
