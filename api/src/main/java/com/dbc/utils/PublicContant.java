package com.dbc.utils;

import java.io.File;
import java.util.Random;

public class PublicContant {
    public static final String baseUrl = "http://localhost:8081";

    public static void createDir(String dir) {
        File file = new File(dir);
        if (!file.exists()) file.mkdir();
    }

    public static int random() {
        Random random = new Random(1000);
        return random.nextInt();
    }
}
