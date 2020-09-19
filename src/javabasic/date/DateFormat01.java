package javabasic.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat01 {
    public static void main(String[] args) throws ParseException {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s=df.format(new Date());
        System.out.println(s);
        DateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=df2.parse("1212-10-05 12:23:11");
        System.out.println(date);


    }
}
