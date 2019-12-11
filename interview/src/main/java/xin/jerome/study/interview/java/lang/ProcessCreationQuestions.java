package xin.jerome.study.interview.java.lang;

import java.io.IOException;
import org.junit.Test;

/**
 * 进程创建的相关问题
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 18:02
 */
public class ProcessCreationQuestions {

    @Test
    public void createProcess() {
        Runtime runtime = Runtime.getRuntime();
        try {
            // 打开计算器
            String openCalculator = "calc";
            // 打开网页
            String openWebSite = "cmd /k start http://www.baidu.com";
            Process process = runtime.exec(openWebSite);
            process.exitValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
