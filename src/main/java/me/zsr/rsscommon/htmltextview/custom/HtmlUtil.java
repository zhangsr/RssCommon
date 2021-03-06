package me.zsr.rsscommon.htmltextview.custom;

import org.jsoup.Jsoup;

import me.zsr.rsscommon.StringUtil;

public class HtmlUtil {

    public static String getShrinkDesc(String originDesc) {
        // Shrink string to optimize render time
        String result = "";
        if (StringUtil.isNullOrEmpty(originDesc)) {
            return result;
        }
        String parsedStr = Jsoup.parse(originDesc).text();
        int showLength = parsedStr.length() < 50 ? parsedStr.length() : 50;
        if (showLength > 0) {
            result = parsedStr.substring(0, showLength - 1);
        }
        return result;
    }
}
