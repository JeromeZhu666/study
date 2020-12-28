package xin.jerome.study.datastructures.array;

import xin.jerome.study.domain.entity.Student;

public class TestMyArray {

    public static void main(String[] args) {
        testMyArray();
//        testMyGenericArray();

    }

    private static void testMyGenericArray() {
        MyGenericArray<Integer> genericArray = new MyGenericArray<>();
        for (int i = 0; i < 10; i++) {
            genericArray.addToLast(i);
        }
        System.out.println(genericArray);
        genericArray.delete(4);
        System.out.println(genericArray);
        genericArray.addToIndex(3, 3);
        System.out.println(genericArray);

        // 测试自定义类型
        MyGenericArray<Student> studentGenericArr = new MyGenericArray<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setName(String.format("张三%d",i));
            student.setAge(20 + i);
            studentGenericArr.addToLast(student);
        }
        System.out.println(studentGenericArr);
    }

    private static void testMyArray() {
        MyArray array = new MyArray(1);
        for (int i = 0; i < 10; i++) {
            array.addToLast(i);
        }
        System.out.println(array);
        array.delete(4);
        System.out.println(array);
        array.addToIndex(3, 3);
        System.out.println(array);
        for (int i = 0; i < 8; i++) {
            array.deleteFirst();
            System.out.println(array);
        }
    }
}
