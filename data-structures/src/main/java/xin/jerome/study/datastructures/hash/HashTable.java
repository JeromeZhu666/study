package xin.jerome.study.datastructures.hash;

import java.util.Objects;
import java.util.TreeMap;

/**
 * 哈希表(散列表)
 *
 * 根据键(Key)而直接访问在内存存储位置的数据结构.通过计算一个关于键值的函数,将所需查询的数据映射到表中一个位置来访问记录.
 * 
 * 这个映射函数称做散列函数,存放记录的数组称做散列表.
 * 
 * @author Jerome Zhu
 * @since 2019.08.04 08:07
 */
public class HashTable<K, V> {

    public static final int UPPER_TOL = 10;
    public static final int LOWER_TOL = 2;
    public static final int INIT_CAPACITY = 7;
    private TreeMap<K, V>[] hashTable = null;
    private int M;
    private int size;

    public HashTable(int m) {
        hashTable = new TreeMap[m];
        this.M = m;
        for (int i = 0; i < m; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(INIT_CAPACITY);
    }

    /**
     * 向hash表中插入一个元素
     * 
     * @param key
     *            插入的key
     * @param value
     *            key 对应的值
     */
    public void put(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= UPPER_TOL * M) {
                resize(M << 1);
            }
        }
    }

    /**
     * 删除一个元素
     * 
     * @param key
     *            待删除元素的键值
     * @return 删除的元素对应的value
     */
    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < LOWER_TOL * M && M >> 1 > INIT_CAPACITY) {
                resize(M >> 1);
            }
        }
        return ret;
    }

    /** 对hashTable进行动态扩容缩容 */
    private void resize(int newM) {
        // 构建新的存储容器
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        // 遍历原有的元素并添加到新容器中
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashTable = newHashTable;
    }

    /**
     * 给设置一个新值
     * 
     * @param key
     *            key
     * @param value
     *            newValue
     */
    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("key is not exist.");
        }
        map.put(key, value);
    }

    /**
     * hash表中是否包含元素key
     * 
     * @param key
     *            元素的key值
     * @return true 存在, false 不存在
     */
    public boolean containsKey(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * 根据key获取对应的值
     * 
     * @param key
     *            键值
     * @return key 对应的值
     */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    /**
     * 获取key的hash值
     * 
     * @param key
     *            key的值
     * @return key对应的hash值
     */
    private int hash(K key) {
        return (Objects.hashCode(key) & 0x7fffffff) % M;
    }

    /**
     * 获取哈希表的大小
     * 
     * @return 哈希表的大小
     */
    private int size() {
        return size;
    }
}
