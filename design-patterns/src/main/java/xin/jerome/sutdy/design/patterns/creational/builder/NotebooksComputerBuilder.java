package xin.jerome.sutdy.design.patterns.creational.builder;

/**
 * 笔记本的构建者
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 16:23
 */
public abstract class NotebooksComputerBuilder {

    protected NotebooksComputer notebooksComputer;

    public void builder() {
        notebooksComputer = new NotebooksComputer();
    }
    public NotebooksComputer build() {
        return notebooksComputer;
    }
    /** 构建品牌 */
    public abstract void buildBrand();
    /** 构建处理器 */
    public abstract void buildCpuBrand();
    /** 构建显卡 */
    public abstract void buildGpuBrand();
    /** 构建内存 */
    public abstract void buildMemorySize();
}
