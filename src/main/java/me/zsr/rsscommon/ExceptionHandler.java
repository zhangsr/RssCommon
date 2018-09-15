package me.zsr.rsscommon;

public class ExceptionHandler {

    public static void silentHandle(Exception e) {
        if (BuildConfig.DEBUG) {
            e.printStackTrace();
        }
    }
}
