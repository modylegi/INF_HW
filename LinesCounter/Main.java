package INF_HW.LinesCounter;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        String pathName = "C:\\Users\\user\\Desktop\\JavaProjects\\src\\INF_HW\\StreamAPI";
        File folder = new File(pathName);
        File[] listOfFiles = folder.listFiles();
        int lines = 0;

        for (File file : listOfFiles) {

            if (file.isFile()) {
                String fileName = file.getName();
                int index = fileName.lastIndexOf('.');
                String extension = fileName.substring(index + 1, index + 5);
                boolean isJava = extension.equals("java");


                if( isJava == true ){
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(pathName+"\\"+fileName));
                        while (reader.readLine() != null) {
                            lines++;
                        }
                        reader.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        System.out.println("Number of lines: "+lines);
    }
}

