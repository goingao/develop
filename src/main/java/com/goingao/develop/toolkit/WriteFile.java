package com.goingao.develop.toolkit;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author goingao
 */
public class WriteFile {

    public static void writeFileContext(List<String> strings, String path) throws Exception {
        File file = new File(path);
        // 如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"));
        for (String l : strings) {
            writer.write(l + "\r\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String test = MessageFormat.format("update tm_customer set province = ''{0}'', city = ''{1}'', area = ''{2}'' where pk_id = {3};",
                "哈哈哈", "2", "3", "4");
        System.out.printf(test);

        File file = new File("/Users/goingao/Desktop/gy.sql");
        // 如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/goingao/Desktop/gy.txt"));
        List<String> strings = new ArrayList<>();
        strings.add("update tm_customer set province = '北京市', city = '北京市市辖区', area = '朝阳区' where pk_id = 24201883434383013;");
        strings.add("update tm_customer set province = '天津市', city = '', area = '' where pk_id = 24351585207405225;");
        strings.add("update tm_customer set province = '上海市', city = '上海市市辖区', area = '奉贤区' where pk_id = 24351585207427784;");
        strings.add("update tm_customer set province = '上海市', city = '上海市市辖区', area = '嘉定区' where pk_id = 24351585207985174;");
        strings.add("update tm_customer set province = '重庆市', city = '', area = '' where pk_id = 24351585208078861;");
        strings.add(test);
        for (String l : strings) {
            writer.write(l + "\r\n");
        }
        writer.close();
    }
}
