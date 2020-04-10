package javase.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar calendar=new GregorianCalendar(2999,10,9,22,10,50);
        int year=calendar.get(Calendar.YEAR);
        System.out.println(year);
        Calendar calendar1=new GregorianCalendar();
        calendar1.set(Calendar.YEAR,8012);
        System.out.println(calendar1);
        Calendar c1=new GregorianCalendar();
        c1.add(Calendar.YEAR,12);
        System.out.println(c1);
        Date d= c1.getTime();
        System.out.println(d);
    }
}
