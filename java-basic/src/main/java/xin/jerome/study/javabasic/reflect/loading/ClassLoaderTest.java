package xin.jerome.study.javabasic.reflect.loading;

/**
 * 测试Java类的热加载
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();
	}
}
