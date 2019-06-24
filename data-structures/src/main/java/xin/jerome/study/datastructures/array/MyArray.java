package xin.jerome.study.datastructures.array;

/**
 * 自定义数组
 *      增加和删除：时间复杂度(n)、操作最后位置 时间复杂度O(1)
 *      修改和查询：时间复杂度(n)、已知索引 时间复杂度O(1)
 *
 * @author Jerome Zhu
 * @since 2018.09.12 21:23
 */
public class MyArray {

    private int[] data;
    private int size;

    /**
     * 无参构造函数，默认初始化容量为10
     */
    public MyArray() {
        this(10);
    }

    /**
     * 构造函数，传入容量构造数组
     *
     * @param capacity 数组的容量
     */
    public MyArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return 布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定位置添加元素
     *
     * @param index 插入的位置
     * @param e 添加的数组中的元素
     */
    public void addToIndex(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("插入的位置必须在 [0,size] 之间");
        }
        if (size == getCapacity()) {
            resize(2 * getCapacity());
        }

        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 向数组的末尾添加一个元素
     *
     * @param e 添加到数组中的数
     */
    public void addToLast(int e) {
        addToIndex(size, e);
    }
    /**
     * 向数组的头部添加一个元素
     *
     * @param e 添加到数组中的数
     */
    public void addToFirst(int e) {
        addToIndex(0, e);
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 指定元素的位置
     * @return 索引对应的元素
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引必须在 [0,size] 之间");
        }
        return data[index];
    }

    /**
     * 修改指定位置的元素
     *
     * @param index 要修改的位置
     * @param e 修改的值
     */
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引必须在 [0,size] 之间");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含该元素
     *
     * @param e 需要检查的元素
     * @return 布尔值
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    /**
     * 找到元素所在的索引
     *
     * @param e 需要检查的元素
     * @return 元素所在的位置，如果不存在返回 -1
     */
    public int findIndex(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 删除的位置
     * @return 删除的元素
     */
    public int delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引必须在 [0,size] 之间");
        }
        int delValue = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if(size < getCapacity()/4 && getCapacity()/2 != 0)
            resize(getCapacity()/2);
        return delValue;
    }

    /**
     * 删除数组中的第一个元素
     *
     * @return 删除的元素值
     */
    public int deleteFirst() {
        return delete(0);
    }

    /**
     * 删除数组中的最后一个元素
     *
     * @return 删除的元素值
     */
    public int deleteLast() {
        return delete(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e 需要删除的元素
     * @return 布尔值
     */
    public boolean deleteElement(int e) {
        int index = findIndex(e);
        if (index != -1) {
            delete(index);
            return true;
        }
        return false;
    }

    /**
     * 改变数组的容量
     *
     * @param newCapacity 新的数组容量
     */
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyArray(" + getCapacity() + ") = {");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size -1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
