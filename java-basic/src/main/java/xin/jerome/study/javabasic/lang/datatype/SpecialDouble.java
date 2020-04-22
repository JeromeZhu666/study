package xin.jerome.study.javabasic.lang.datatype;

import org.junit.Test;

/**
 * {@link Double} 相关冷知识, 对应基本数据类型 double.
 *
 * @author JeromeSoar
 * @since 2020年04月22日 15:33
 */
public class SpecialDouble {

    /**
     * 代码说明一些 double 不常用的点
     * 如果需要浮点运算值准确, 建议使用 StrictMath
     * @see StrictMath
     */
    @Test
    public void testSpecialDouble() {
        // 正无穷大
        System.out.println(Double.POSITIVE_INFINITY);
        // 负无穷大
        System.out.println(Double.NEGATIVE_INFINITY);
        // 不是一个数字(Not a number)
        System.out.println(Double.NaN);

        // 判断一个变量是不是数字 number
        System.out.println(Double.isNaN(0.0d / 0.0));

        // java 7 之后, 数字字面量可以加 "_" ,
        Double val = 1_222.333_4d;
        System.out.println(val);
    }
}
