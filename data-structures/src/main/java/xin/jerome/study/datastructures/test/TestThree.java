package xin.jerome.study.datastructures.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * “主域归属”问题
 */
public class TestThree {

    public static void main(String[] args) {
        TestThree testThree = new TestThree();
        testThree.countInput(new File("E:\\input.txt"));
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
        try {
            inputReader = new LineNumberReader(new FileReader(inputFile));
            String inputLine = null;
            while((inputLine =inputReader.readLine()) != null){
                String result = inputLine.substring(inputLine.indexOf('.'), inputLine.length());
                System.out.println("*" + result);
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
