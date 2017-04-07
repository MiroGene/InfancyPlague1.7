package per.gene;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

/**
 * Created by Administrator on 2017/1/18.
 */
public class A {

    public static void main(String[] args) throws Exception {
        String start = "2014-01-03";
        String end = "2014-03-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(start);
        Date dEnd = sdf.parse(end);
        List<Date> listDate = getDatesBetweenTwoDate(dBegin, dEnd);
        for(int i=0;i<listDate.size();i++){
            System.out.println(sdf.format(listDate.get(i)));
        }
    }

    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }
}





