package xin.jerome.study.interview.java.lang;

import java.io.IOException;
import org.junit.Test;

/**
 * 创建进程的方式
 *
 * @author zhu shaojie
 * @since 2019年12月10日 18:02
 */
public class CreateProcessMethods {

    @Test
    public void createProcess() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("calc");
            process.exitValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
