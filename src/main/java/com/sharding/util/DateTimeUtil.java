package com.sharding.util;


import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author
 * @Date 2021/10/13 14:06
 * @Version 1.0
 */
public class DateTimeUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_SHORT = "yyMMdd";
    public static final String LONG_FORMAT = "yyyyMMddHHmmss";
    public static final String DAY_FORMAT_LONG_MS = "yyMMddHHmmssSSS";

    public static Date getCurrDateTime() {
        return new Date();
    }

    public static Date getCurrDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date getDateEndDay(Date curDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static Date getDateStartDay(Date curDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getFormatDate(Date currDate) {
        return getFormatDate(currDate, "yyyy-MM-dd");
    }

    public static Date getFormatDateToDate(Date currDate) throws ParseException {
        return getFormatDate(getFormatDate(currDate));
    }

    public static String getFormatDate_CN(Date currDate) {
        return getFormatDate(currDate, "yyyy年MM月dd日");
    }

    public static Date getFormatDateToDate_CN(Date currDate) throws ParseException {
        return getFormatDate_CN(getFormatDate_CN(currDate));
    }

    public static Date getFormatDate(String currDate) throws ParseException {
        return getFormatDate(currDate, "yyyy-MM-dd");

    }

    public static Date getFormatDate_CN(String currDate) throws ParseException {
        return getFormatDate(currDate, "yyyy年MM月dd日");
    }

    public static String getFormatDate(Date currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        if (currDate == null) {
            return null;
        }
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception var4) {
            dtFormatdB = new SimpleDateFormat("yyyy-MM-dd");
            return dtFormatdB.format(currDate);
        }
    }

    public static String getFormatDateTime(Date currDate) {
        return getFormatDateTime(currDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getFormatDateTimeToTime(Date currDate) throws ParseException {
        return getFormatDateTime(getFormatDateTime(currDate));
    }

    public static Date getFormatDateTime(String currDate) throws ParseException {
        return getFormatDateTime(currDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getFormatDateTime_CN(Date currDate) {
        return getFormatDateTime(currDate, "yyyy年MM月dd日 HH:mm:ss");
    }

    public static Date getFormatDateTimeToTime_CN(Date currDate) throws ParseException {
        return getFormatDateTime_CN(getFormatDateTime_CN(currDate));
    }

    public static Date getFormatDateTime_CN(String currDate) throws ParseException {
        return getFormatDateTime(currDate, "yyyy年MM月dd日 HH:mm:ss");
    }

    public static String getFormatDateTime(Date currDate, String format) {
        SimpleDateFormat dtFormatdB = null;

        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception var4) {
            dtFormatdB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dtFormatdB.format(currDate);
        }
    }

    public static Date getFormatDate(String currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception var4) {
            throw new IllegalArgumentException("日期格式化异常");
        }
    }

    public static Date getFormatDateTime(String currDate, String format) throws ParseException {
        SimpleDateFormat dtFormatdB = null;

        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception var4) {
            dtFormatdB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dtFormatdB.parse(currDate);
        }
    }

    public static String getDateBeforeMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(2, -1);
        return getFormatDate(cal.getTime(), "yyyy-MM-dd");
    }

    public static String getDateBeforeDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(6, -1);
        return getFormatDate(cal.getTime(), "yyyy-MM-dd");
    }

    public static String getCurrDateStr() {
        return getFormatDate(getCurrDateTime());
    }

    public static String getCurrDateTimeStr() {
        return getFormatDateTime(getCurrDateTime());
    }

    public static String getCurrDateStr_CN() {
        return getFormatDate(getCurrDateTime(), "yyyy年MM月dd日");
    }

    public static String getCurrDateTimeStr_CN() {
        return getFormatDateTime(getCurrDateTime(), "yyyy年MM月dd日 HH:mm:ss");
    }

    public static Date getDateBeforeOrAfter(int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(5, iDate);
        return cal.getTime();
    }

    public static Date getDateBeforeOrAfterMonth(int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(2, iDate);
        return cal.getTime();
    }

    public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(5, iDate);
        return cal.getTime();
    }

    public static String getFormatMonth(Date currDate) {
        return getFormatDate(currDate, "yyyy-MM");
    }

    public static String getFormatDay(Date currDate) {
        return getFormatDate(currDate, "yyyyMMdd");
    }

    public static String getFormatDayShort(Date currDate) {
        return getFormatDate(currDate, "yyMMdd");
    }

    public static Date getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int firstDay = cal.getMinimum(5);
        cal.set(5, firstDay);
        return cal.getTime();
    }

    public static String getFormatFirstDayOfMonth() {
        return getFormatDate(getFirstDayOfMonth(), "yyyy-MM-dd");
    }

    public static Date getFirstDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(2, 1);
        int firstDay = cal.getMinimum(5);
        cal.set(5, firstDay);
        return cal.getTime();
    }

    public static String getFormartFirstDayOfNextMonth() {
        return getFormatDate(getFirstDayOfNextMonth(), "yyyy-MM-dd");
    }

    public static String getFormatFirstDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(5);
        cal.set(5, firstDay);
        return getFormatDate(cal.getTime(), "yyyy-MM-dd");
    }

    public static String getFormatLastDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(5);
        cal.set(5, firstDay);
        return getFormatDate(cal.getTime(), "yyyy-MM-dd");
    }

    public static Date getFirstDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(5);
        cal.set(5, firstDay);
        return cal.getTime();
    }

    public static Date getLastDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(11, iHour);
        return cal.getTime();
    }

    public static Date getDateBeforeOrAfterMinute(Date curDate, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(12, minutes);
        return cal.getTime();
    }

    public static boolean isSameWeek(Date curDate, Date compareDate) throws ParseException {
        if (curDate != null && compareDate != null) {
            Calendar calSun = Calendar.getInstance();
            calSun.setTime(getFormatDateToDate(curDate));
            calSun.set(7, 1);
            Calendar calNext = Calendar.getInstance();
            calNext.setTime(calSun.getTime());
            calNext.add(5, 7);
            Calendar calComp = Calendar.getInstance();
            calComp.setTime(compareDate);
            return calComp.after(calSun) && calComp.before(calNext);
        } else {
            return false;
        }
    }

    //String日期后面添加" 23:59:59"
    public static String addDateEndfix(String datestring) {
        return datestring != null && !datestring.equals("") ? datestring + " 23:59:59" : null;
    }

    //String日期后面添加"235959"
    public static String addDateEndfix1(String datestring) {
        return datestring != null && !datestring.equals("") ? datestring + "235959" : null;
    }

    //String日期后面添加"2359599999999999"
    public static String addDateEndfix2(String datestring) {
        return datestring != null && !datestring.equals("") ? datestring + "2359599999999999" : null;
    }

    public static Date formatEndTime(String datePre) throws ParseException {
        if (datePre == null) {
            return null;
        } else {
            String dateStr = addDateEndfix(datePre);
            return getFormatDateTime(dateStr);
        }
    }

    public static Boolean compareDay(Date date1, int compday) {
        if (date1 == null) {
            return Boolean.valueOf(false);
        } else {
            Date dateComp = getDateBeforeOrAfter(date1, compday);
            Date nowdate = new Date();
            return dateComp.after(nowdate) ? Boolean.valueOf(true) : Boolean.valueOf(false);
        }
    }

    public static String convertBinaryTime2Hex(String timespan) {
        if (timespan != null && !timespan.equals("")) {
            String ret = "";
            String tmp = "";

            for (int i = 0; i < timespan.length(); ++i) {
                tmp = tmp + timespan.charAt(i);
                tmp = tmp + timespan.charAt(i);
                if ((i + 1) % 16 == 0) {
                    if (!ret.equals("")) {
                        ret = ret + ",";
                    }

                    Long t = Long.valueOf(Long.parseLong(tmp, 2));
                    String hexStr = Long.toHexString(t.longValue());
                    if (hexStr.length() < 8) {
                        int length = hexStr.length();

                        for (int n = 0; n < 8 - length; ++n) {
                            hexStr = "0" + hexStr;
                        }
                    }

                    ret = ret + hexStr;
                    tmp = "";
                }
            }

            return ret;
        } else {
            return "";
        }
    }

    public static String convertHexTime2Binary(String timespan) {
        if (timespan != null && !timespan.equals("")) {
            String tmp = "";
            String ret = "";
            String[] strArr = timespan.split(",");

            int i;
            for (i = 0; i < strArr.length; ++i) {
                String binStr = Long.toBinaryString(Long.parseLong(strArr[i], 16));
                if (binStr.length() < 32) {
                    int length = binStr.length();

                    for (int n = 0; n < 32 - length; ++n) {
                        binStr = "0" + binStr;
                    }
                }

                tmp = tmp + binStr;
            }

            for (i = 0; i < 48; ++i) {
                ret = ret + tmp.charAt(i * 2);
            }

            return ret;
        } else {
            return "";
        }
    }

    public static String convertDecTime2Binary(String timespan) {
        if (timespan != null && !timespan.equals("")) {
            String tmp = "";
            String ret = "";
            String[] strArr = timespan.split(",");

            int i;
            for (i = 0; i < strArr.length; ++i) {
                String binStr = Long.toBinaryString(Long.parseLong(strArr[i], 10));
                if (binStr.length() < 32) {
                    int length = binStr.length();

                    for (int n = 0; n < 32 - length; ++n) {
                        binStr = "0" + binStr;
                    }
                }

                tmp = tmp + binStr;
            }

            for (i = 0; i < 48; ++i) {
                ret = ret + tmp.charAt(i * 2);
            }

            return ret;
        } else {
            return "";
        }
    }

    public static String convertBinaryTime2Dec(String timespan) {
        if (timespan != null && !timespan.equals("")) {
            String ret = "";
            String tmp = "";

            for (int i = 0; i < timespan.length(); ++i) {
                tmp = tmp + timespan.charAt(i);
                tmp = tmp + timespan.charAt(i);
                if ((i + 1) % 16 == 0) {
                    if (!ret.equals("")) {
                        ret = ret + ",";
                    }

                    Long t = Long.valueOf(Long.parseLong(tmp, 2));
                    String decStr = Long.toString(t.longValue());
                    if (decStr.length() < 10) {
                        int length = decStr.length();

                        for (int n = 0; n < 10 - length; ++n) {
                            decStr = "0" + decStr;
                        }
                    }

                    ret = ret + decStr;
                    tmp = "";
                }
            }

            return ret;
        } else {
            return "";
        }
    }

    //获取两个日期间隔天数
    public static int compareDay(Date one, Date two) {
        long num1 = one.getTime();
        long num2 = two.getTime();
        return (int) ((num2 - num1) / 86400000L);
    }

    public static int compareDay(String one, String two) throws ParseException {
        Date oneDate = getFormatDate(one);
        Date twoDate = getFormatDate(two);
        return compareDay(oneDate, twoDate);
    }

    public static boolean compareDate_lt(String one, String two) {
        try {
            return compareDay(one, two) < 0;
        } catch (ParseException var3) {
            return false;
        }
    }

    public static int compareHour(Date one, Date two) {
        long num1 = one.getTime();
        long num2 = two.getTime();
        return (int) ((num2 - num1) / 3600000L);
    }

    public static int compareMinuter(Date one, Date two) {
        long num1 = one.getTime();
        long num2 = two.getTime();
        return (int) ((num2 - num1) / 60000L);
    }

    public static int compareSeconds(Date one, Date two) {
        long num1 = one.getTime();
        long num2 = two.getTime();
        return (int) ((num2 - num1) / 1000L);
    }

    public static Date parseDateLongFormat(String sDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = null;
        if (sDate != null && sDate.length() == "yyyyMMddHHmmss".length()) {
            d = dateFormat.parse(sDate);
        }

        return d;
    }

    @SneakyThrows
    public static Date parseDateFormat(String sDate, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date d = null;
        if (sDate != null && sDate.length() == format.length()) {
            d = dateFormat.parse(sDate);
        }

        return d;
    }

    public static String getLongDateString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return getDateString(date, dateFormat);
    }

    public static boolean isValidLongDateFormat(String strDate) {
        if (strDate.length() != "yyyyMMddHHmmss".length()) {
            return false;
        } else {
            try {
                Long.parseLong(strDate);
            } catch (Exception var4) {
                return false;
            }

            DateFormat df = getNewDateFormat("yyyyMMddHHmmss");

            try {
                df.parse(strDate);
                return true;
            } catch (ParseException var3) {
                return false;
            }
        }
    }

    public static boolean isValidLongDateFormat(String strDate, String delimiter) {
        String temp = strDate.replaceAll(delimiter, "");
        return isValidLongDateFormat(temp);
    }

    public static String getDateString(Date date, DateFormat dateFormat) {
        return date != null && dateFormat != null ? dateFormat.format(date) : null;
    }

    public static DateFormat getNewDateFormat(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        return df;
    }

    public static final Date add(Date date, int field, int howMany) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, howMany);
        return calendar.getTime();
    }

    public static String timestampToString(Timestamp timestamp) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long times = Long.valueOf(timestamp.getTime());
        String date = df.format(times);
        return date;
    }

    public static String getFormatStartTime(String currDate) {
        try {
            currDate = getFormatDate(getFormatDate(currDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(currDate);
        builder.append(" ");
        builder.append("00:00:00");
        return builder.toString();
    }

    public static String getFormatEndTime(String currDate) {
        try {
            currDate = getFormatDate(getFormatDate(currDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(currDate);
        builder.append(" ");
        builder.append("23:59:59");
        return builder.toString();
    }

    /**
     * 获取当前时间到第二天凌晨所剩余的秒数
     *
     * @return
     */
    public static Integer getSurplusMillionsToEndDay() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        final long diff = cal.getTimeInMillis() - System.currentTimeMillis();
        return (int) (diff / 1000);
    }

    /**
     * 判断是否当天日期
     *
     * @param str
     * @param formatStr
     * @return
     * @throws Exception
     */
    public static boolean isToday(String str, String formatStr) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        if (year1 == year2 && month1 == month2 && day1 == day2) {
            return true;
        }
        return false;
    }


    /**
     * 获得当前日期的前天
     *
     * @return
     */
    public static String beforeYesterday() {
        String time = "";
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -2);
            time = sf.format(c.getTime());
        } catch (Exception e) {
            throw new IllegalArgumentException("获得当前前两天的日期错误");
        }
        return time;
    }

    /**
     * 获得昨日
     *
     * @return
     */
    public static String getYesterday() {
        String time = "";
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -1);
            time = sf.format(c.getTime());
        } catch (Exception e) {
            throw new IllegalArgumentException("获得昨日的日期错误");
        }
        return time;
    }

    /**
     * 获得明日
     *
     * @return
     */
    public static Date getTomorrowDate() {
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, 1);
            return c.getTime();
        } catch (Exception e) {
            throw new IllegalArgumentException("获得昨日的日期错误");
        }
    }

    /**
     * description:获取上个月日期
     * Author:Evelyn
     * Date:2017/9/23 11:49
     */
    public static String getLastMonth() {
        String time = "";
        try {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -1);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            time = format.format(c.getTime());
        } catch (Exception e) {
            throw new IllegalArgumentException("获得当前前两天的日期错误");
        }
        return time;
    }

    /**
     * 获取一段时间内的日期
     *
     * @param dBegin
     * @param dEnd
     * @return 、调用前后的处理方法
     * Calendar cal = Calendar.getInstance();
     * String start = "2012-09-01";
     * String end = "2012-10-21";
     * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     * Date dBegin = sdf.parse(start);
     * Date dEnd = sdf.parse(end);
     * List<Date> lDate = findDates(dBegin, dEnd);
     * for (Date date : lDate)
     * {
     * System.out.println(sdf.format(date));
     * }
     */
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }


    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }


    /**
     * 获取指定日期中月份的第一天时间 字符串格式
     *
     * @param pattern
     * @return
     * @throws ParseException
     */
    @SneakyThrows
    public static String getMonthFirstDayStr(Date date,String pattern){
        Calendar cale = Calendar.getInstance();//获取当前日期
        cale.setTime(date);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.MINUTE,0);
        cale.set(Calendar.SECOND,0);
        cale.set(Calendar.MILLISECOND,0);
        return getSimpleDateFormat(pattern).format(cale.getTime());
    }

    /**
     * 获取指定日期中月份的最后一天时间 字符串格式
     *
     * @param pattern
     * @return
     * @throws ParseException
     */
    @SneakyThrows
    public static String getMonthLastDayStr(Date date,String pattern){
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.set(Calendar.HOUR_OF_DAY,23);
        cale.set(Calendar.MINUTE,59);
        cale.set(Calendar.SECOND,59);
        cale.set(Calendar.MILLISECOND,999);
        return getSimpleDateFormat(pattern).format(cale.getTime());
    }

    /**
     * 获取指定日期中月份的第一天时间 Date格式
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getMonthFirstDay(Date date) throws ParseException {
        Calendar cale = Calendar.getInstance();//获取当前日期
        cale.setTime(date);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.MINUTE,0);
        cale.set(Calendar.SECOND,0);
        cale.set(Calendar.MILLISECOND,0);
        return cale.getTime();
    }

    /**
     * 获取指定日期中月份的最后一天时间 Date格式
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getMonthLastDay(Date date) throws ParseException {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.set(Calendar.HOUR_OF_DAY,23);
        cale.set(Calendar.MINUTE,59);
        cale.set(Calendar.SECOND,59);
        cale.set(Calendar.MILLISECOND,999);
        return cale.getTime();
    }

    /**
     * 获取上个月 yyyyMM格式
     */
    public static String getLastMonth(String pattern) {
        Date dateTime = new Date();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        calendar.add(Calendar.MONTH, -1);
        return formatDate(calendar.getTime(), "yyyyMM");
    }

    public static String formatDate(Date date, String pattern) {
        String riqi = null;
        if (date != null && StringUtils.isNotEmpty(pattern)) {
            SimpleDateFormat dateFormat = getSimpleDateFormat(pattern);
            riqi = dateFormat.format(date);
        }
        return riqi;
    }

    /**
     * 字符串转日期
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date formatDate(String date,String pattern) throws ParseException{
        Date rq = null;
        if(StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(pattern)){
            SimpleDateFormat dateFormat = getSimpleDateFormat(pattern);
            try {
                rq = dateFormat.parse(date);
            } catch (ParseException e) {
                throw e;
            }
        }
        return rq;
    }

    /**
     * 获取当前时间
     *
     * @param pattern : 格式化
     * @return
     */
    public static String getTime(String pattern) {
        return getSimpleDateFormat(pattern).format(new Date());
    }

    private static Map<String, ThreadLocal<SimpleDateFormat>> mapThreadLocal = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
    private static final Object lockObj = new Object();

    public static SimpleDateFormat getSimpleDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> df = mapThreadLocal.get(pattern);
        if (df == null) {
            synchronized (lockObj) {
                df = mapThreadLocal.get(pattern);
                if (df == null) {
                    df = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    mapThreadLocal.put(pattern, df);
                }
            }
        }
        return df.get();
    }

    /**
     * 时间相减返回天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {

        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate;
        Date endDate;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 获取某一日期距当前时间的天数
     * */
    public static long calcHours(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        LocalDate startDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate endDate = LocalDate.now();
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
        int preDay;
        if (currentDay == 1) {
            preDay = -6;
        } else {
            preDay = 2 - currentDay;
        }
        String endTime = DateTimeUtil.getFormatDateTime(calendar.getTime(), DateTimeUtil.DATE_FORMAT);
        calendar.add(Calendar.DATE, preDay);
        String startTime = DateTimeUtil.getFormatDateTime(calendar.getTime(), DateTimeUtil.DATE_FORMAT);
        System.out.println(endTime);
        System.out.println(startTime);

        calendar.setTime(new Date());
        System.out.println(DateTimeUtil.getFormatDateTime(calendar.getTime(), DateTimeUtil.DATE_FORMAT));
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(DateTimeUtil.getFormatDateTime(calendar.getTime(), DateTimeUtil.DATE_FORMAT));

        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(DateTimeUtil.getFormatDateTime(calendar.getTime(), DateTimeUtil.DATE_FORMAT));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(DateTimeUtil.getFormatDateTime(calendar.getTime(), DateTimeUtil.DATE_FORMAT));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2021-12-08");
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate startDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate endDate = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(startDate, endDate));
    }
}
