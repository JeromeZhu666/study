package xin.jerome.study.datastructures.unionfind;

import java.util.Random;

import org.junit.Test;

import xin.jerome.study.datastructures.unionfind.impl.QuickFindUnionFind;
import xin.jerome.study.datastructures.unionfind.impl.QuickUnionUnionFind;

/**
 * 测试 {@link MyUnionFind} 的功能
 *
 * @author Jerome Zhu
 * @since 2019.07.22 08:32
 */
public class MyUnionFindTest {

    @Test
    public void testMyUnionFind() {
        int size = 100000;
        int m = 10000;
        QuickFindUnionFind quickFindUnionFind = new QuickFindUnionFind(size);
        System.out.println("QuickFind: " + test(quickFindUnionFind, m) + " s.");
        QuickUnionUnionFind quickUnionUnionFind = new QuickUnionUnionFind(size);
        System.out.println("QuickFind: " + test(quickUnionUnionFind, m) + " s.");
    }

    /**
     * 测试 MyUnionFind 进行 m 次操作花费的时间
     * 
     * @param unionFind
     *            测试类
     * @param m
     *            操作执行的次数
     * @return 花费的时间
     */
    private double test(MyUnionFind unionFind, int m) {
        int size = unionFind.size();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            unionFind.unionElements(random.nextInt(size), random.nextInt(size));
        }
        for (int i = 0; i < m; i++) {
            unionFind.isConnected(random.nextInt(size), random.nextInt(size));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
