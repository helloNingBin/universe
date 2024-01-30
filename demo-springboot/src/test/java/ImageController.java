import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageController {
    public static void main(String[] args) {
        ImageController i = new ImageController();
        StringBuilder sb = new StringBuilder("data:image/png;base64,iVBORw0KGg");
        i.uploadImage(sb.toString());
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("base64Image") String base64Image) {
        try {
            // 解码 base64 字符串为字节数组
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // 将字节数组写入文件
            File imageFile = saveImage(imageBytes, "uploaded_image");

            System.out.println("====>" + imageFile.getAbsolutePath());
            return new ResponseEntity<>("Image saved successfully: " + imageFile.getAbsolutePath(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private File saveImage(byte[] content, String filenamePrefix) throws IOException {
        String fileType = determineFileType(content);
        File imageFile = File.createTempFile(filenamePrefix, "." + fileType);
        FileUtils.writeByteArrayToFile(imageFile, content);
        return imageFile;
    }

    private String determineFileType(byte[] content) {
        // 判断文件类型（这里简单演示，实际应该使用更复杂的逻辑）
        // 常见图片格式的文件头信息：https://en.wikipedia.org/wiki/List_of_file_signatures
        if (startsWith(content, "FFD8FF")) {
            return "jpg";
        } else if (startsWith(content, "89504E47")) {
            return "png";
        } else if (startsWith(content, "47494638")) {
            return "gif";
        } else {
            return "unknown";
        }
    }

    private boolean startsWith(byte[] content, String prefix) {
        String contentHex = bytesToHex(content, prefix.length());
        return contentHex.toUpperCase().startsWith(prefix);
    }

    private String bytesToHex(byte[] bytes, int length) {
        StringBuilder hexStringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            hexStringBuilder.append(String.format("%02X", bytes[i]));
        }
        return hexStringBuilder.toString();
    }
}
