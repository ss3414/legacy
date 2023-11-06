package javautil.common;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class File {

    /* 解析文件，返回路径/文件名/后缀 */
    public static Map<String, String> parse(String file) {
        int pathPosition = 0;
        if (file.lastIndexOf("/") != -1) {
            pathPosition = file.lastIndexOf("/") + 1;
        } else if (file.lastIndexOf("\\") != -1) {
            pathPosition = file.lastIndexOf("\\") + 1;
        }
        int suffixPosition = file.lastIndexOf(".");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("path", file.substring(0, pathPosition));
        map.put("fileName", file.substring(pathPosition, suffixPosition));
        map.put("suffix", file.substring(suffixPosition));
        return map;
    }

    public static Map<String, String> parse(java.io.File file) {
        return parse(file.getAbsolutePath());
    }

    @SneakyThrows
    public static byte[] file2Bytes(java.io.File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        int size = Math.toIntExact(file.length());
        byte[] bytes = new byte[size];
        fileInputStream.read(bytes);
        return bytes;
    }

}
