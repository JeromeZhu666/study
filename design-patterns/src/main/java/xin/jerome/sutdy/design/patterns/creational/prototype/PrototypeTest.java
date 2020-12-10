package xin.jerome.sutdy.design.patterns.creational.prototype;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * 原型模式
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 17:41
 */
public class PrototypeTest {

    @Test
    public void testShallowCopy() {
        Latchkey prototypeLatchkey = new Latchkey();
        prototypeLatchkey.setMaterial("铁");

        for (int i = 0; i < 3; i++) {
            Latchkey cloneLatchkey = (Latchkey) prototypeLatchkey.clone();
            System.out.println(cloneLatchkey);
        }
        System.out.println(prototypeLatchkey);
    }

    @Test
    public void testDeepCopy() {
        Date birthday = new Date(96, Calendar.JULY, 5);
        Sheep dolly = new Sheep();
        dolly.setName("多莉");
        dolly.setBirthday(birthday);

        Sheep cloneDolly = (Sheep) dolly.clone();
        cloneDolly.setName("多莉1");

        System.out.println(dolly);
        System.out.println(cloneDolly);
        System.out.println("-------------修改时间后-------------");
        birthday.setTime(System.currentTimeMillis());
        System.out.println(dolly);
        System.out.println(cloneDolly);
    }
}
