package xin.jerome.sutdy.design.principle.openclose;

/**
 * 一个学生的追求
 *
 * @author Jerome Zhu
 * @since 2019.08.03 09:18
 */
public class StudentPursuance implements Pursuance {
    /** 年龄 */
    private String name;
    /** 名字 */
    private Integer age;
    /** 当下的追求 */
    private String curPursuance;

    public StudentPursuance(String name, Integer age, String curPursuance) {
        this.name = name;
        this.age = age;
        this.curPursuance = curPursuance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public String getCurrentPursuance() {
        return curPursuance;
    }

    @Override
    public String toString() {
        return String.format("姓名: %s ,年龄 : %d ,追求 : %s .", name, age, curPursuance);
    }
}
