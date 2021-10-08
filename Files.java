package com.example.system;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Files {

    static long whiteLine = 0;
    static long comentLine = 0;
    static long sormaLine = 0;

    public static void main(String[] args) {
        File f = new File("D:\\OneDrive\\OneDrive Folder\\Study\\Job\\Java\\code\\IdeaProjects\\cmb_StudentManage");
        File[] codeFiles = f.listFiles();
        for (File child : codeFiles) {
            //System.out.println(child);
            preas(child);
        }
        System.out.println("空行：" + whiteLine);
        System.out.println("注释行：" + comentLine);
        System.out.println("有效行：" + sormaLine);
    }

    private static void preas(File f) {
        BufferedReader br = null;
        Boolean comPd = false;
        try {
            br = new BufferedReader(new FileReader(f));
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                readLine = readLine.trim();
                if (readLine.matches("^[\\s&&[^\\n]]*$")) {
                    whiteLine++;
                } else if (readLine.startsWith("/*") && !readLine.endsWith("*/")) {
                    comentLine++;
                    comPd = true;
                } else if (readLine.startsWith("/*") && !readLine.endsWith("*/")) {
                    comentLine++;
                } else if (comPd) {
                    comentLine++;
                    if (readLine.endsWith("*/")) {
                        comPd = false;
                    }
                } else if (readLine.startsWith("//")) {
                    comentLine++;
                } else {
                    sormaLine++;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}