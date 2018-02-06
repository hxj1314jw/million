package com.million.server.common.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式处理工具类
 */
public class DateUtil {
	public static final String LMSP_DATEPREFIX = "LMSP_DATE_";
	public static final String LMSP_CURRENT_DATE = "_LMSP_CURRENT_DATE";
	public static final String LMSP_CURRENT_DATETIME = "_LMSP_CURRENT_DATETIME";
	public static final String CONCISEDATETIMEFORMAT = "yyyyMMddHHmmss";
    public static final String COMMONEIGHTTIME="yyyyMMdd";
	public static final String CONCISEDATEFORMAT = "yyyyMMdd";
	public static final String DEFAULTDATEFORMAT = "MM/dd/yyyy";
	public static final String DEFAULTDATETIMEFORMAT = "MM/dd/yyyy HH:mm:ss";
	private static final String[] MONTHS = new String[] { "JAN", "FEB", "MAR",
			"APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV", "DEC" };
	private static final String[] WEEKDAYDISPLAY = new String[] { "星期日", "星期一",
			"星期二", "星期三", "星期四", "星期五", "星期六" };
	/* 天干 */
	private static final String[] TIANGAN = { "甲", "乙", "丙", "丁", "戊", "己",
			"庚", "辛", "壬", "癸" };
	/* 地支数组 */
	private static final String[] DIZHI = { "子", "丑", "寅", "卯", "辰", "巳", "午",
			"未", "申", "酉", "戌", "亥" };
	/* 十二生肖 */
	private static final String[] SHENGXIAO = { "鼠", "牛", "虎", "兔", "龙", "蛇",
			"马", "羊", "猴", "鸡", "狗", "猪" };

	public static Date convertDefaultDateOrTime(String value) {
		if (LMSP_CURRENT_DATE.equals(value)) {
			// 当前日期
			return DateUtil.parseDateString(DateUtil.formatDate(new Date()));

		} else if (LMSP_CURRENT_DATETIME.equals(value)) {
			// 当前日期时间
			return DateUtil.parseDateTimeString(DateUtil
					.formatDateTime(new Date()));

		} else if (value != null && value.indexOf(LMSP_DATEPREFIX) == 0) {
			String d = value.substring(LMSP_DATEPREFIX.length());
			int len = d.length();
			if (len == 14) {
				return DateUtil.parseString(d, CONCISEDATETIMEFORMAT);
			} else if (len == 8) {
				return DateUtil.parseString(d, CONCISEDATEFORMAT);
			}
		}
		return null;
	}

	/**
	 * 计算农历
	 * 
	 * @param year
	 *            年份
	 * @return 数组:[天干 地支，十二生肖]
	 */
	public static String[] calculateNongli(int year) {
		int tg = year % 10 - 4;
		if (tg < 0) {
			tg += 10;
		}
		String tiangan = TIANGAN[tg];
		int dz = year % 12 - 4;
		if (dz < 0) {
			dz += 10;
		}
		String dizhi = DIZHI[dz];
		String[] rv = { tiangan + dizhi, SHENGXIAO[dz] };
		return rv;

	}

	/**
	 * 获取中文星期
	 * 
	 * @param weekday
	 * @return 中文星期，如星期四
	 */
	public static String takeWeekdayDisplay(int weekday) {
		return WEEKDAYDISPLAY[weekday];
	}

	/**
	 * 获取月份英文简写，如1：JAN
	 * 
	 * @param month
	 * @return 英文简写
	 */
	public static String takeMonthDisplay(int month) {
		return MONTHS[month];
	}

	/**
	 * 字符串 转换为时间。
	 * 
	 * @param s
	 *            待转字符串
	 * @param format
	 *            时间格式
	 * @return Date类型
	 * @throws ParseException
	 */
	public static Date parseString(final String s, final String format) {
		if (s != null && s.length() > 0 && format != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try {
				return sdf.parse(s);
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 字符串以("MM/dd/yyyy")格式 转换为时间。
	 *
	 * @param s
	 *            待转字符串
	 * @return Date类型
	 * @throws ParseException
	 */
	public static Date parseDateString(final String s) {
		return parseString(s, DEFAULTDATEFORMAT);
	}

	/**
	 * 将字符串以(MM/dd/yyyy HH:mm:ss)格式转换为时间。
	 *
	 * @param s
	 *            日期字符串
	 * @return 转换后的日期
	 * @throws ParseException
	 */
	public static Date parseDateTimeString(final String s) {
		return parseString(s, DEFAULTDATETIMEFORMAT);
	}

	/**
	 * 将时间类型 转换为字符串。
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式字符串 如："MM/dd/yyyy HH:mm:ss"
	 * @return 日期
	 */
	public static String format(final Date date, final String format) {
		if (date != null && format != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return null;
	}

	/**
	 * 将时间类型 以转换为("MM/dd/yyyy")形式的字符串。
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return 格式化后的日期字符串
	 */
	public static String formatDate(final Date date) {
		return format(date, DEFAULTDATEFORMAT);
	}

	/**
	 * 将时间类型 以转换为("MM/dd/yyyy HH:mm:ss")形式的字符串。
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return 格式化后的日期字符串
	 */
	public static String formatDateTime(final Date date) {
		return format(date, DEFAULTDATETIMEFORMAT);
	}

    public static int getDays(final Date date1, final Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.clear();

        Calendar c2 = Calendar.getInstance();
        c2.clear();

        // Set the date for both of the calendar instance
        c1.setTime(date1);
        c2.setTime(date2);

        // Print out the dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Get the represented date in milliseconds
        long time1 = c1.getTimeInMillis();
        long time2 = c2.getTimeInMillis();

        // Calculate difference in milliseconds
        long diff = time1>time2?time1-time2:time2-time1;

        // Difference in days
        Long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays.intValue();
    }

	/**
	 * 获取两个日期相差几个月
	 * 
	 * @param date1
	 *            月份1
	 * @param date2
	 *            月份2
	 * @return 相差月数
	 */
	public static int getMonths(final Date date1, final Date date2) {
		int iMonth = 0;
		int flag = 0;
		Calendar objCalendarDate1 = Calendar.getInstance();
		objCalendarDate1.setTime(date1);

		Calendar objCalendarDate2 = Calendar.getInstance();
		objCalendarDate2.setTime(date2);
		if (objCalendarDate2.equals(objCalendarDate1))
			return 0;
		if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
				.get(Calendar.DAY_OF_MONTH))
			flag = 1;
		if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
				.get(Calendar.YEAR))
			iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
					.get(Calendar.YEAR))
					* 12
					+ objCalendarDate2.get(Calendar.MONTH) - flag)
					- objCalendarDate1.get(Calendar.MONTH);
		else
			iMonth = objCalendarDate2.get(Calendar.MONTH)
					- objCalendarDate1.get(Calendar.MONTH) - flag;
		return iMonth;
	}

	/**
	 * 清除日期的MilliSeconds
	 * 
	 * @param date
	 *            待处理的日期
	 * @return 日期Date
	 */
	public static Date clearMilliSeconds(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.clear(Calendar.MILLISECOND);
		return c.getTime();
	}

	/**
	 * 清除日期的时间
	 * 
	 * @param date
	 *            待处理的日期
	 * @return 日期Date
	 */
	public static Date getOnlyDate(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.clear(Calendar.MILLISECOND);
		c.clear(Calendar.HOUR);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.SECOND);
		return c.getTime();
	}


    /**
     * 取小贷的期望到账日期 废弃 TODO 要改为调接口取下一个交易日
     *
     * * @param int
     *            T+1 or T+2
     * @return 日期Date
     */
    public static int getExpectBeginDate(int useDay, int days) {
        Date useDate = parseString(Integer.toString(useDay), CONCISEDATEFORMAT);
        Calendar c = Calendar.getInstance();
        c.setTime(useDate);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
        return Integer.valueOf(DateUtil.format(c.getTime(), CONCISEDATEFORMAT));
    }

    /**
     * 取小贷的期望购回日期 废弃
     *
     * * @param int
     *            T+1 or T+2
     * @return 日期Date
     */
    public static int getExpectEndDate(int beginDate, int period) {
        Date useDate = parseString(Integer.toString(beginDate), CONCISEDATEFORMAT);
        Calendar c = Calendar.getInstance();
        c.setTime(useDate);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + period);
        return Integer.valueOf(DateUtil.format(c.getTime(), CONCISEDATEFORMAT));
    }

    /**
     * 取小贷的期望到账日期
     *
     * @return 日期Date
     */
    public static int getUseDate() {
        return Integer.valueOf(DateUtil.format(DateUtil.getUseCal().getTime(), CONCISEDATEFORMAT));
    }

    /**
     * 取小贷的期望到账日期
     *
     * @return 日期Date
     */
    public static Calendar getUseCal() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        if (hour > 14 || (hour == 14 && min >= 50)) {
            c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
        }
        return c;
    }

    /**
     * 取小贷的期望到账日期
     *
     * @return 日期Date
     */
    public static boolean beNextDay() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        if (hour > 14 || (hour == 14 && min >= 50)) {
            return true;
        }
        return false;
    }

    /**
     * 把八位数字字符串格式化
     * xielb
     * @param dateNum
     * @param format
     * @return
     */
    public static String formatEightNum(int dateNum,String format){
        String result="";
        String date = String.valueOf(dateNum);
        if((date!=null&&!"".equals(date))||date.length()!=8){
            return   result;
        }
        for(int i=0;i<date.length();i++){
            result+=date.charAt(i);
            if(i==3||i==5){
                result+=format;
            }
        }
        return result;
    }

    /**
     * otc订单时间共通函数
     * jin
     * @param flag 0：全部时间	 1:最近三月 2:今年以内 3:2014年 4:2013年 5:2012年 6:2011年 7:2010年 8:2010年以前 9:其他
     * @param startEnd 0:开始日期 1：结束日期
     * @return
     */
    public static int startEndDate(String flag,int startEnd){
        // 当前时间
        Date nowTime = new Date();
        // 返回格式 yyyyMMdd
        SimpleDateFormat sdf = new SimpleDateFormat(COMMONEIGHTTIME);
        // 得到日历
        Calendar calendar = Calendar.getInstance();
        // 当前年份
        int nowYear = calendar.get(Calendar.YEAR);
        // 把当前时间赋给日历
        calendar.setTime(nowTime);
        // 中间日期转换变量
        String dateTemp = null;
        // 开始日期
        if (startEnd == 0){
            switch(Integer.parseInt(flag))
            {
                case 0:
                    // 全部时间	-- 0
                    return 19000101;
                case 1:
                    // 设置为前3月
                    calendar.add(calendar.MONTH, -3);
                    dateTemp = sdf.format(calendar.getTime());
                    // 最近三月	-- 1
                    return Integer.parseInt(dateTemp);
                case 2:
                    dateTemp = nowYear + "0101";
                    // 今年以内	-- 2
                    return Integer.parseInt(dateTemp);
                case 3:
                    // 2014年  	-- 3
                    return 20140101;
                case 4:
                    // 2013年  	-- 4
                    return 20130101;
                case 5:
                    // 2012年  	-- 5
                    return 20120101;
                case 6:
                    // 2011年  	-- 6
                    return 20110101;
                case 7:
                    // 2010年  	-- 7
                    return 20100101;
                case 8:
                    // 2010年以前 -- 8
                    return 19000101;
                case 9:
                    return Integer.parseInt(sdf.format(nowTime));
                default:
                    return 19000101;
            }
        // 结束日期
        }else{
            switch(Integer.parseInt(flag))
            {
                case 0:
                    dateTemp = sdf.format(nowTime);
                    // 全部时间	-- 0
                    return Integer.parseInt(dateTemp);
                case 1:
                    dateTemp = sdf.format(nowTime);
                    // 最近三月	-- 1
                    return Integer.parseInt(dateTemp);
                case 2:
                    dateTemp = nowYear + "1231";
                    // 今年以内	-- 2
                    return Integer.parseInt(dateTemp);
                case 3:
                    // 2014年  	-- 3
                    return 20141231;
                case 4:
                    // 2013年  	-- 4
                    return 20131231;
                case 5:
                    // 2012年  	-- 5
                    return 20121231;
                case 6:
                    // 2011年  	-- 6
                    return 20111231;
                case 7:
                    // 2010年  	-- 7
                    return 20101231;
                case 8:
                    // 2010年以前 -- 8
                    return 20091231;
                case 9:
                    // 当天
                    return Integer.parseInt(sdf.format(nowTime));
                default:
                    dateTemp = nowYear + "1231";
                    return Integer.parseInt(dateTemp);
            }
        }
    }
}
