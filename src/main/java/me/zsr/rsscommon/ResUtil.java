package me.zsr.rsscommon;

import android.content.Context;
import android.content.res.Resources;

public class ResUtil {
    private static Resources mResource;

    public static void init(Context context) {
        mResource = context.getResources();
    }

    public static int dp2px(final float dpValue) {
        final float scale = mResource.getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
