package xin.jerome.study.javabasic.beans;

import org.junit.Test;
import xin.jerome.study.javabasic.domain.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * Java Bean 信息相关测试
 *
 * @author JeromeSoar
 * @since 2020年06月21日 10:27
 */
public class BeanInfoTest {

    @Test
    public void testJavaBeanDescriptors() throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        // 查看 Java Bean 的属性描述
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(System.out::println);

        // 为 Java Bean 添加属性编辑器
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    // age 属性 String to Integer
                    // 获取当前属性的数据类型
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    if (propertyType.equals(Integer.class)) {
                        System.out.println(propertyName + ": String type to " + propertyType.getName());
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    }
                });
    }

    /**
     * String to Integer 类型转换器
     */
    private static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer integerVal = Integer.valueOf(text);
            super.setValue(integerVal);
        }
    }
}
