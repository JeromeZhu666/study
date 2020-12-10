package xin.jerome.sutdy.design.patterns.creational.prototype;

import java.util.Date;

/**
 * 羊
 *
 * @author JeromeSoar
 * @since 2020年 12月 10日 09:04
 */
public class Sheep implements Cloneable {

    /** 姓名 */
    private String name;
    /** 生日 */
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() {
        try {
            Sheep clone = (Sheep) super.clone();
            clone.birthday = (Date) this.birthday.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            // assert false
        }
        return null;
    }

    @Override
    public String toString() {
        return  super.toString() + "{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
