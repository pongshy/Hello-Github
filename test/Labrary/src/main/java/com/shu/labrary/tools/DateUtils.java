package com.shu.labrary.tools;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtils {
    public static Date CalToDate(Calendar data) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return date;
    }
    public static Calendar DateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        return cal;
    }
    /**
     * @Description: 获取具体时间中的日期
     * @Param: [Date]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-3
     */
    public static String getDate(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = format.format(date);
        String str = datestr.substring(0,datestr.indexOf(" "));

        return str;
    }
    /**
     * @Description: 获取具体时间中的时分秒
     * @Param: [Date]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-3
     */
    public static String getTime(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = simpleDateFormat.format(date);
        String str = datestr.substring(datestr.indexOf(" ") + 1);

        return str;
    }


    public static Date strToDate(String strDate)
    {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos=new ParsePosition(0);
        Date strtodate=format.parse(strDate,pos);
        return strtodate;
    }

    public static String DatetoStr(Date date)
    {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr=format.format(date);
        return datestr;
    }


    public static int getDayDiffer(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long startDateTime = dateFormat.parse(dateFormat.format(startDate)).getTime();
        long endDateTime = dateFormat.parse(dateFormat.format(endDate)).getTime();
        return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
    }
}
