package xin.jerome.sutdy.design.patterns.creational.builder;

/**
 * 联想笔记本 intel 机型
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 16:49
 */
public class LenovoIntelNotebooksComputerBuilder extends NotebooksComputerBuilder {

    @Override
    public void buildBrand() {
        notebooksComputer.setBrand("联想");
    }

    @Override
    public void buildCpuBrand() {
        notebooksComputer.setCpuBrand("英特尔 酷睿 i7-10875H");
    }

    @Override
    public void buildGpuBrand() {
        notebooksComputer.setGpuBrand("英伟达 GeForce RTX2060");
    }

    @Override
    public void buildMemorySize() {
        notebooksComputer.setMemorySize("海盗船 16G");
    }
}
