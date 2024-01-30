import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateRegexExample {
    public static void main(String[] args) {
        String text = "旧车置换户产过 京Q·58A77 camooecum";

        // 分割字符串
        String[] parts = text.split("\\s");

        for (String part : parts) {
            // 检查第三位是否为数字或字母
            if (part.length() >= 3 && Character.isLetterOrDigit(part.charAt(2))) {
                // 如果第三位是数字或字母，则直接输出
                System.out.println("Found License Plate: " + part);
            } else {
                // 如果第三位不是数字或字母，则将第三位变为数字或字母后再输出
                String processedPart = processPart(part);
                System.out.println("Found License Plate: " + processedPart);
            }
        }
    }

    // 处理字符串，将第三位变为数字或字母
    private static String processPart(String part) {
        if (part.length() >= 3) {
            char thirdChar = part.charAt(2);
            if (!Character.isLetterOrDigit(thirdChar)) {
                // 如果第三位不是数字或字母，则将其替换为一个字母（这里假设是'A'）
                part = part.substring(0, 2) + 'A' + part.substring(3);
            }
        }
        return part;
    }
}
