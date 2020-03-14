package com.hwua.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisitTimeUtil {
    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getNow(){
        return LocalDateTime.now().format(formatter);
    }
}
