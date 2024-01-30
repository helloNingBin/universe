package com.ning.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearchTool {

    public static void main(String[] args) {
        String directoryPath = "E:\\";
        String searchString = "StoreMemberConsumeInterface";

        List<File> foundFiles = searchFiles(directoryPath, searchString);

        if (foundFiles.isEmpty()) {
            System.out.println("No files found containing the specified string.");
        } else {
            System.out.println("Files containing the specified string:");

            for (File file : foundFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private static List<File> searchFiles(String directoryPath, String searchString) {
        List<File> result = new ArrayList<>();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return result;
        }

        searchFilesInDirectory(directory, searchString, result);

        return result;
    }

    private static void searchFilesInDirectory(File directory, String searchString, List<File> result) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归进入子目录
                    searchFilesInDirectory(file, searchString, result);
                } else if (file.isFile() && file.getName().endsWith(".java")) {
                    // 查找 Java 文件
                    if (containsString(file, searchString)) {
                        result.add(file);
                    }
                }
            }
        }
    }

    private static boolean containsString(File file, String searchString) {
        // 在文件中查找指定字符串
        // 这里可以根据实际需求选择不同的查找方式
        // 以下示例简单地读取文件内容并使用 contains 方法查找
        // 实际应用中可能需要考虑更复杂的情况，比如忽略大小写、正则表达式匹配等
        try {
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            return content.contains(searchString);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
