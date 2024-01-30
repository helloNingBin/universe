import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Base64Extractor {
    public static void main(String[] args) {
        String input = "data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAA";
        String base64Value = extractBase64Value(input);

        System.out.println(base64Value);
    }

    private static String extractBase64Value(String input) {
        // 正则表达式，匹配以"data:image/jpeg;base64,"开头的Base64编码部分
        String regex = "data:image\\/\\w+;base64,([^\\s]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // 提取匹配的部分
            return matcher.group(1);
        } else {
            // 没有匹配项
            return null;
        }
    }
}
