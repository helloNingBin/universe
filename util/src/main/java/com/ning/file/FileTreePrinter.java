package com.ning.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTreePrinter {

    public static void main(String[] args) throws IOException {
        Path rootPath = Paths.get("E:\\temp\\vue\\hello");
        printDirectoryTree(rootPath);
    }

    private static void printDirectoryTree(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            int indentLevel = 0;

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                printIndent();
                System.out.println(dir.getFileName());
                indentLevel++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                printIndent();
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                indentLevel--;
                return FileVisitResult.CONTINUE;
            }

            private void printIndent() {
                for (int i = 0; i < indentLevel; i++) {
                    System.out.print("   ");
                }
            }
        });
    }
    //无参数、无返回的函数
    public void t1(){
        //do sth
    }
    //无参数，有返回值的函数
    public String t2(){
        return "xx";
    }
    //有参数、有返回值的函数
    public String t3(String s1,int i){
        return s1+i;
    }
    //用...表示多个参数的函数,里面使用匿名函数和lambda
    public void t4(String... args){
        for(String s : args){
            Runnable r = new Runnable() {
                @Override
                public void run() {

                }
            };
            Runnable r2 = ()->{

            };
        }
    }
}
