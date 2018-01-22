package com.intergraph.ziputil;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class ListFile {
    private static ArrayList<String> filelist = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        long startTime=System.currentTimeMillis();
        ListFileFileter(new File("E:\\Test"));
        long endTime=System.currentTimeMillis();
        System.out.println("解压完毕，共耗时：" + (endTime-startTime) + "ms");
    }

    public static void ListFileFileter(File dir) throws Exception {
        if(dir.exists()){
            //匿名内部类，把FileFilter接口对象作为参数
            File[] files = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.isDirectory()){
                        return true;
                    }
                    String name = pathname.getName();//获取文件的名称E:\复件 demodir\Learn\sgim_piccell.v1.bin.bak
//                    System.out.println("****************"+pathname);
                    return name.toLowerCase().endsWith(".zip");//过滤文件类型为.bak或者.BAK文件，而不包含.BAK或者.bak的文件
                }
            });

            for (File file :
                    files) {
                if (file.isFile()) {
                    System.out.println("正在解压 " + file.getName() + " ......");
                    DeCompressUtil.unzip(file.getPath(), file.getParent());
                    file.delete();
                } else {
                    ListFileFileter(file);
                }
            }



        }else{
            throw new RuntimeException("操作的文件或者目录不存在！");
        }
    }
}
