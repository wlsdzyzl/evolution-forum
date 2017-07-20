package register;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.*;
import java.util.ArrayList;

public class picture {

        /**
         * 读取某个文件夹下的所有文件
         */
        public static void readfile(String filepath ,ArrayList<String> result) throws FileNotFoundException, IOException {
                try {
         
                        File file = new File(filepath);
                        if (!file.isDirectory()) {
                        	String path = file.getAbsolutePath();
                        	path = path.substring(path.indexOf("/picture"));
                        		result.add(path);

                        } else if (file.isDirectory()) {
                                //System.out.println("文件夹");
                                String[] filelist = file.list();
                                for (int i = 0; i < filelist.length; i++) {
                                        File readfile = new File(filepath + "\\" + filelist[i]);
                                        if (!readfile.isDirectory()) {
                                        	String path = readfile.getAbsolutePath();
                                        	path = path.substring(path.indexOf("\\picture"));
                                        	//System.out.println(path);
                                        	
                                        		result.add("http://120.25.247.220:8080/my_evolution/"+path.replace("\\", "/"));

                                        } else if (readfile.isDirectory()) {
                                                readfile(filepath + "\\" + filelist[i],result);
                                        }
                                }

                        }

                } catch (FileNotFoundException e) {
                        System.out.println("readfile()   Exception:" + e.getMessage());
                }
        }
        public static void main(String []args) throws FileNotFoundException, IOException
        {
        File i = new File("");
        System.out.println(i.getAbsolutePath());

        }
}
