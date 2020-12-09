package xin.jerome.sutdy.design.principle.openclose;

/**
 * 学生同时有了两个追求
 *
 * @author Jerome Zhu
 * @since 2019.08.03 09:42
 */
public class StudentAnotherPursuance extends StudentPursuance {

    /** 另一个追求 */
    private String anotherPursuance;

    public StudentAnotherPursuance(Pursuance pursuance, String anotherPursuance) {
        super(pursuance.getName(), pursuance.getAge(), pursuance.getCurrentPursuance());
        this.anotherPursuance = anotherPursuance;
    }

    /**
     * 获取学生的另一个追求
     */
    public String getAnotherPursuance() {
        return anotherPursuance;
    }

    @Override
    public String toString() {
        return String.format("姓名: %s ,年龄 : %d ,追求 : %s ,同时追求 : %s .", getName(), getAge(), getCurrentPursuance(),
            anotherPursuance);
    }
}
