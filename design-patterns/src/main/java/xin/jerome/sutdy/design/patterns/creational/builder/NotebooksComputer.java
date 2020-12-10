package xin.jerome.sutdy.design.patterns.creational.builder;

/**
 * 笔记本
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 16:39
 */
public class NotebooksComputer {

    /** 品牌 */
    private String brand;
    /** cpu 品牌 */
    private String cpuBrand;
    /** gpu 品牌 */
    private String gpuBrand;
    /** 内存大小 */
    private String memorySize;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCpuBrand(String cpuBrand) {
        this.cpuBrand = cpuBrand;
    }

    public void setGpuBrand(String gpuBrand) {
        this.gpuBrand = gpuBrand;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "NotebooksComputer{" +
                "brand='" + brand + '\'' +
                ", cpuBrand='" + cpuBrand + '\'' +
                ", gpuBrand='" + gpuBrand + '\'' +
                ", memorySize='" + memorySize + '\'' +
                '}';
    }
}
