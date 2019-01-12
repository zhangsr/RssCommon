package me.zsr.rsscommon;

import android.content.Context;
import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
    /**
     * @see <a href="http://www.ietf.org/rfc/rfc0822.txt">RFC 822</a>
     */
    private static final SimpleDateFormat RFC822 = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
    private static final SimpleDateFormat ISO8610 = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);

    /**
     * Parses string as an RFC 822 date/time.
     */
    public static Date parseRfc822(String date) {
        try {
            return RFC822.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            return ISO8610.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public static boolean isSameYear(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

    public static CharSequence formatDate(Context context, Long time) {
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        Date yestoday = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        Date beforeYestoday = calendar.getTime();
        if (isSameDay(date, today)) {
            return "今天";
        } else if (isSameDay(date, yestoday)) {
            return "昨天";
        } else if (isSameDay(date, beforeYestoday)) {
            return "前天";
        } else {
            return DateFormat.format("yyyy年MM月dd日", date);
        }
    }

    public static CharSequence formatTime(Long time) {
        return TIME_FORMAT.format(new Date(time));
    }
}
