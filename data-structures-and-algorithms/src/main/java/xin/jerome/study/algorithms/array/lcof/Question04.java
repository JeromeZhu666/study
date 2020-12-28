package xin.jerome.study.algorithms.array.lcof;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中, 每一行都按照从左到右递增的顺序排序, 每一列都按照从上到下递增的顺序排序.
 * 请完成一个函数, 输入这样的一个二维数组和一个整数, 判断数组中是否含有该整数.
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5, 返回 true.
 * 给定 target = 20, 返回 false.
 *
 * @author JeromeSoar
 * @since 2020年05月10日 20:39
 */
public class Question04 {

    /**
     * 暴力求解: 直接遍历数据, 如果找到目标数据返回 true 否则返回 false.
     * 时间复杂度 O(m * n) 空间复杂度 O(1)  1 ms  45.5 MB
     *
     * @param matrix 二维数组
     * @param target 目标数据
     * @return 如果存在 target 返回 true, 否则返回 false.
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] intArr : matrix)
            for (int anInt : intArr)
                if (anInt == target)
                    return true;
        return false;
    }

    /**
     * 线性查找: 因为数据从左到右递增, 从上到下递增. 所以从矩阵的右上角开始向左下角查找(右上角标志数).
     * 同理也可以使用左下角标志数.
     * 时间复杂度 O(n + m) 空间复杂度 O(1)  0 ms  45.8 MB
     *
     * @param matrix 二维数组
     * @param target 目标数据
     * @return 如果存在 target 返回 true, 否则返回 false.
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        // 每行(X轴方向)数据数量最大值
        int maxX = matrix[0].length;
        // 每列(Y轴方向)数据数量最大值
        int maxY = matrix.length;

        // 左上角对应数据所在坐标
        int x = maxX - 1;
        int y = 0;
        // 当 x 或 y 达到边界时, 结束循环. 即没有 target
        while (x >= 0 && y < maxY) {
            // 如果符合直接返回数据
            if (target == matrix[y][x])
                return true;
            // 若目标数据 target 大于当前数据, 则需要向下遍历
            else if (target > matrix[y][x])
                y++;
            // 若目标数据 target 小于当前数据, 则需要向左遍历
            else
                x--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new Question04().findNumberIn2DArray1(matrix, 5));
    }
}
