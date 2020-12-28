package xin.jerome.study.algorithms.math.leetcode;

/**
 * Pow(x, n)
 * 实现 pow(x, n), 即计算 x 的 n 次幂函数.
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1 / 2^2 = 1/4 = 0.25
 *
 * @author JeromeSoar
 * @since 2020年05月11日 19:25
 */
public class LeetCode0050 {

    /**
     * 按照数学语义实现
     * 时间复杂度 O(n) 空间复杂度 O(1)  超出时间限制  N/A  N/A
     * @param x 底数值
     * @param n 幂值
     * @return x 的 n 次幂计算后的值
     */
    public double myPow(double x, int n) {
        double result = 1.0d;
        // 如果正次幂直接连乘
        if(n > 0) {
            result = x;
            for (int i = 1; i < n; i++) {
                result *= x;
            }
        }
        // 如果负次幂连乘后取倒数
        else if (n < 0) {
            result = x;
            for (int i = 1; i < -n; i++) {
                result *= x;
            }
            result = 1.0d / result;
        }
        return result;
    }

    /**
     * 分治思想: x^n <==> x^(n/2) * x^(n/2)
     * 时间复杂度 O(logN) 空间复杂度 O(logN)  1 ms  36.8 MB
     * @param x 底数值
     * @param n 幂值
     * @return x 的 n 次幂计算后的值
     */
    public double myPow1(double x, int n) {
        // 一个数的负次幂相当于该数值正次幂的倒数
        return n >= 0 ? subPow(x, n) : 1.0d / subPow(x, -n);
    }
    private double subPow(double x, long n) {
        // 将 n 强转 long 类型防止 int 数据溢出
        // 处理特殊情况, 任何数的 0 次幂都等于 1
        if (n == 0)
            return 1.00d;

        // 分治思想记录子计算结果
        double subValue = subPow(x, n / 2);
        // 如果幂值刚好整除就是子结果的平方, 如果有余数则需要在乘一个 x .
        return n % 2 == 0 ? subValue * subValue : subValue * subValue * x;
    }

    /**
     * todo 分治思想(将递归调用转换为迭代):
     * 时间复杂度 O(logN) 空间复杂度 O(1)
     * @param x 底数值
     * @param n 幂值
     * @return x 的 n 次幂计算后的值
     */
    public double myPow2(double x, int n) {
        // 一个数的负次幂相当于该数值正次幂的倒数
        return n >= 0 ? subPow1(x, n) : 1.0d / subPow1(x, -n);
    }
    private double subPow1(double x, long n) {
        return 0.00d;
    }

    public static void main(String[] args) {
        double x = 2.00d;
        int n = 10;
        System.out.println(new LeetCode0050().myPow1(x, n));
        n = -2;
        System.out.println(new LeetCode0050().myPow1(x, n));
    }
}
