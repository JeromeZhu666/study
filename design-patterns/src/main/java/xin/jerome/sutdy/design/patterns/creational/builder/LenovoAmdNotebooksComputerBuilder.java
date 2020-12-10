package xin.jerome.sutdy.design.patterns.creational.builder;

/**
 * 联想笔记本 amd 机型
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 16:49
 */
public class LenovoAmdNotebooksComputerBuilder extends NotebooksComputerBuilder {

    @Override
    public void buildBrand() {
        notebooksComputer.setBrand("联想");
    }

    @Override
    public void buildCpuBrand() {
        notebooksComputer.setCpuBrand("AMD R5 4600H");
    }

    @Override
    public void buildGpuBrand() {
        notebooksComputer.setGpuBrand("英伟达 GeForce GTX1650");
    }

    @Override
    public void buildMemorySize() {
        notebooksComputer.setMemorySize("金士顿 16G");
    }
}
