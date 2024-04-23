package kr.or.ddit.util;

public class MaskingUtil {
    public static String maskId(String id) {
        return id.replaceAll(".(?<=.{5})", "*");
    }
}