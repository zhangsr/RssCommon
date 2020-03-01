package me.zsr.rsscommon;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    private static Handler mMainThreadHandler;

    private static Handler mBackgroundHandler;
    private static ExecutorService mExecutorService;

    public static void init() {
        mMainThreadHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                mBackgroundHandler = new Handler();
                Looper.loop();
            }
        }).start();

        mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
    }

    public static void post(Runnable runnable) {
        mMainThreadHandler.post(runnable);
    }

    public static void postDelay(Runnable runnable, long delay) {
        mMainThreadHandler.postDelayed(runnable, delay);
    }

    /**
     * for simple, thread unsafe runnable
     */
    public static void postInBackground(Runnable runnable) {
        mBackgroundHandler.post(runnable);
    }

    public static void execute(Runnable runnable) {
        mExecutorService.execute(runnable);
    }
}
