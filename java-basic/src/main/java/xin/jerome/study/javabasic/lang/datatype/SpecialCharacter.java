package xin.jerome.study.javabasic.lang.datatype;

import org.junit.Test;

/**
 * {@link Character} 相关冷知识, 对应基本数据类型 char
 *
 * @author JeromeSoar
 * @since 2020年04月22日 16:10
 */
public class SpecialCharacter {

    /**
     * 代码说明一些 char 不常用的点
     * Unicode转义序列会在解析代码之前得到处理, 无论Unicode转义序列在什么位置.
     * 例如: 注释中;方法参数变量中;变量命名中 等等.
     */
    @Test
    public void testSpecialCharacter() {
        // 等价于 ""+""
        String val = "\u0022+\u0022";
        System.out.println(val);

        // 是否属于Java中的 "字母"
        System.out.println(Character.isJavaIdentifierStart('\u0022'));
        System.out.println(Character.isJavaIdentifierPart('A'));
    }
}
