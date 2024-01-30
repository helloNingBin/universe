package com.ning.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 如果你只想打印第一层的结构，可以在 preVisitDirectory 方法中判断当前深度是否为 1。
 如果是第一层，就打印，然后返回 FileVisitResult.SKIP_SUBTREE，以阻止进一步的深度遍历。以下是相应的更改：
 */

public class FileTreeOnePrinter {

    public static void main(String[] args) throws IOException {
        Path rootPath = Paths.get("E:\\temp\\vue\\hello");
        printDirectoryTree(rootPath, 2);
    }

    private static void printDirectoryTree(Path path, int maxDepth) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            int indentLevel = 0;

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                printIndent();
                System.out.println(dir.getFileName());
                indentLevel++;

                // 判断深度是否超过最大深度
                if (indentLevel >= maxDepth) {
                    return FileVisitResult.SKIP_SUBTREE;
                }

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
}
