package xin.jerome.study.datastructures.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 * 文件input.txt是一个文本文件，每一行有多列（用空格分隔）。
 * keyword.conf是一个关键词配置文件，每一行是一个词。
 * 请找出文件input.txt中第一列包含keyword.conf中任意一个关键词的文本行并输出。
 */
public class TestOne {

    public static void main(String[] args) {
        TestOne testOne = new TestOne();
        testOne.SearchKeyword(new File("E:\\input.txt"), new File("E:\\keyword.conf"));
    }

    public void SearchKeyword(File inputFile, File confFile) {
        //参数校验
        if(inputFile == null || confFile ==null){
            throw new RuntimeException("the file is null.");
        }
        if(!inputFile.exists() || !confFile.exists()) {
            throw new RuntimeException("the file is not exists");
        }
        if(inputFile.isDirectory()||confFile.isDirectory()){
            throw new RuntimeException("the file is a directory,not a file");
        }
        if(!inputFile.canRead()||!confFile.canRead()) {
            throw new RuntimeException("the file can't read");
        }

        //行读取
        LineNumberReader inputReader = null;
        LineNumberReader confReader = null;
        ArrayList<String> confList = new ArrayList<>();
        try {
            confReader = new LineNumberReader(new FileReader(confFile));
            String conf = null;
            while ((conf = confReader.readLine()) != null) {
                confList.add(conf);
            }
            inputReader = new LineNumberReader(new FileReader(inputFile));
            String inputLine = null;
            while((inputLine =inputReader.readLine()) != null){
                for (String keyword : confList) {
                    if (inputLine.indexOf(keyword) != -1)
                        System.out.println(inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(confReader != null){
                try {
                    confReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    confReader = null;
                }
            }
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
