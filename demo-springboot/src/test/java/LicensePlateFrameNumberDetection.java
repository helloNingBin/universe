import com.ning.orc.LicensePlate;
import com.ning.orc.VinCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateFrameNumberDetection {
    public static void main(String[] args) {
        String inputString = "旧车置换户产过 京11Q·58A77 camooecum 京A12345 LFV2A21K6A3092399";

        System.out.println(LicensePlate.findLicensePlate(inputString));
        System.out.println(VinCode.findVinCode(inputString));
    }

    // 判断是否为车牌号或车架号
    private static String detectLicensePlateOrFrameNumber(String part) {
        // 车牌号正则表达式
        String licensePlateRegex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]([A-HJ-NP-Z0-9]{1}[A-HJ-NP-Z0-9·.。]{1}[DF])|([A-HJ-NP-Z0-9]{2}[A-HJ-NP-Z0-9挂学警港澳]{1})|([A-HJ-NP-Z0-9]{2}[A-HJ-NP-Z0-9]{2}使))[\\s·•\\p{Zs}]?[A-HJ-NP-Z0-9]{1}[A-HJ-NP-Z0-9挂学警港澳]{1}[A-HJ-NP-Z0-9·\u00B7。]{4}";
        // 车架号正则表达式
        String frameNumberRegex = "[A-HJ-NP-Z0-9]{17}";

        Pattern licensePlatePattern = Pattern.compile(licensePlateRegex);
        Pattern frameNumberPattern = Pattern.compile(frameNumberRegex);

        Matcher licensePlateMatcher = licensePlatePattern.matcher(part);
        Matcher frameNumberMatcher = frameNumberPattern.matcher(part);

        if (licensePlateMatcher.matches()) {
            return "License Plate: " + part;
        } else if (frameNumberMatcher.matches()) {
            return "Frame Number: " + part;
        } else {
            return "Not a License Plate or Frame Number";
        }
    }
}
