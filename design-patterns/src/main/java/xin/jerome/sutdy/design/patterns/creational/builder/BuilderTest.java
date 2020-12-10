package xin.jerome.sutdy.design.patterns.creational.builder;

import org.junit.Test;

/**
 * 构建者(建造者) 模式测试
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 16:18
 */
public class BuilderTest {

    @Test
    public void testBuilder() {
        NotebooksComputerBuilder notebooksComputerBuilder = new LenovoIntelNotebooksComputerBuilder();
        notebooksComputerBuilder.builder();
        notebooksComputerBuilder.buildBrand();
        notebooksComputerBuilder.buildCpuBrand();
        notebooksComputerBuilder.buildGpuBrand();
        notebooksComputerBuilder.buildMemorySize();
        NotebooksComputer notebooksComputer = notebooksComputerBuilder.build();
        System.out.println(notebooksComputer);
    }

    @Test
    public void testUpgradeBuilder() {
        DesktopComputer desktopComputer = DesktopComputer.builder()
                .host("联想主机")
                .displays("冠捷 27 寸显示器")
                .keyboard("樱桃青轴键盘")
                .mouse("罗技静音鼠标")
                .build();
        System.out.println(desktopComputer);
    }
}
