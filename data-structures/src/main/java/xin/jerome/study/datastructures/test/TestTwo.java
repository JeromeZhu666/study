package xin.jerome.study.datastructures.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;

/**
 * input.txt中有10万个随机整数，每行一个，
 * 范围从0-99999，需要分别统计[0-99]、[100-199]、[200-299]、[300-399]  …… [99900, 99999]，
 * 出现的次数。输出为每个范围及其中数字出现的次数，范围和数字间空格分隔，每行一个。
 */
public class TestTwo {

    public static void main(String[] args) {
        TestTwo testTwo = new TestTwo();
        testTwo.countInput(new File("E:\\input.txt"));
    }

    public void countInput(File inputFile) {
        //参数校验
        if(inputFile == null){
            throw new RuntimeException("the file is null.");
        }
        if(!inputFile.exists()) {
            throw new RuntimeException("the file is not exists");
        }
        if(inputFile.isDirectory()){
            throw new RuntimeException("the file is a directory,not a file");
        }
        if(!inputFile.canRead()) {
            throw new RuntimeException("the file can't read");
        }

        //行读取
        LineNumberReader inputReader = null;
        HashMap<Integer,Integer> map = new HashMap<>();
        try {
            inputReader = new LineNumberReader(new FileReader(inputFile));
            String inputLine = null;
            while((inputLine =inputReader.readLine()) != null){
                int result = Integer.valueOf(inputLine) / 100;
                if (map.containsKey(result)) {
                    map.put(result, map.get(result) + 1);
                } else {
                    map.put(result, 1);
                }
            }
            for (int i = 0; i < 1000; i++) {
                System.out.println(String.format("%d-%d %d",(i * 100),(i * 100 + 99),map.get(i) == null ? 0 : map.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputReader != null){
                try {
                    inputReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    inputReader = null;
                }
            }
        }
    }
}
