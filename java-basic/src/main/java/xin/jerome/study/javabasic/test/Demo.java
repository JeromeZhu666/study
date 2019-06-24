package xin.jerome.study.javabasic.test;

/**
 * 米拓世纪初试邀请
 */
public class Demo{

    public static void main(String[] args) {
        System.out.println("============test1=============");
        int[] arr = {0,14,2,0,-3,0,5};
        int[] arr2 = test1(arr);
        System.out.print("原数组：{0,14,2,0,-3,0,5}, 处理后结果：{");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
            if (i != arr2.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
        System.out.println("============test1=============");

        System.out.println("============test2=============");
        int num = 1521;
        int[] e = test2(num);
        if(e == null) {
            System.out.println(String.format("给定%d,它的下一个不存在.", num));
        } else {
            System.out.print(String.format("给定%d,它的下一个是", num));
            for (int q = 0; q < e.length; q++) {
                System.out.print(e[q]);
            }
            System.out.println(".");
        }
        System.out.println("============test2=============");
    }



    /**
     * 第一个问题
     *      给定一个由正数,负数和0组成的整数数组,将所有为0的元素,挪到数组末尾。要求时间复杂度O(n)
     * @param arr 给定的数组
     * @return 结果数组
     */
    public static int[] test1(int[] arr) {
        // 数组长度
        int len = arr.length;
        // 遍历数组
        for (int i = 0; i < len; i++) {
            // 判断元素是否为0
            if(arr[i] == 0) {
                // 移动位置
                for (int j = i; j < len-1; j++) {
                    arr[j] = arr[j+1];
                }
                // 末位补0
                arr[len-1] = 0;
            }
        }
        return arr;
    }

    /**
     * 下一个比它大的自然数
     * @param num 源自然数
     * @return  int[] 目标自然数（数组形式）
     *          null 没找到
     */
    public static int[] test2(int num) {
        // 获取位数
        String s = String.valueOf(num);
        int[] e = new int[s.length()];
        // 分解数字
        for (int j = e.length - 1; j >= 0; j--) {
            e[j] = num % 10;
            num = num / 10;
        }
        // 获取下一个数字
        for (int j = e.length - 2; j >= 0; j--) {
            for (int i = e.length - j - 1; i > 0; i--) {
                if (e[j] < e[j + i]) {
                    int temp = e[j];
                    e[j] = e[j + i];
                    e[j + i] = temp;
                    return e;
                }
            }
        }
        return null;
    }

}
