package xin.jerome.sutdy.design.patterns.creational.prototype;

import java.util.Date;

/**
 * 大门钥匙
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 17:52
 */
public class Latchkey implements Cloneable {

    /**
     * 材质
     */
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    protected Object clone() {
        Object cloned = null;
        try {
            cloned = super.clone();
        } catch (CloneNotSupportedException e) {
            // assert false
        }
        return cloned;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "material='" + material + '\'' +
                '}';
    }

}
