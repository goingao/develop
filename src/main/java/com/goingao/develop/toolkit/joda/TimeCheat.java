package com.goingao.develop.toolkit.joda;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Interval;

import java.util.Locale;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-03-29
 */
public class TimeCheat {

    public static void main(String[] args) {

        DateTime d = new DateTime();
        System.out.println(d.dayOfMonth().withMinimumValue().toString("yyyy-MM-dd"));
        DateTime d2 = new DateTime(2019, 3, 29, 15, 28, 1);
        System.out.println(d2.toString("yyyy-MM-dd HH:mm:ss"));
        d2.withYear(1991);

        // DateTime是不可变类，with开头的方法用来设置时间，原对象不会变更，会返回设置后的副本
        System.out.println(d2.toString("yyyy-MM-dd HH:mm:ss"));
        DateTime d3 = d2.withYear(1998);
        System.out.println(d3.toString("yyyy-MM-dd HH:mm:ss"));

        // plus/minus开头的方法，用来增加或减少一段时间
        DateTime d4 = d2.plusYears(1);
        System.out.println(d4.toString("yyyy-MM-dd HH:mm:ss"));
        DateTime d5 = d2.minusYears(1);
        System.out.println(d5.toString("yyyy-MM-dd HH:mm:ss"));

        // Property get、round。。。开头的方法，详见 https://www.joda.org/joda-time/apidocs/index.html
        DateTime now = new DateTime(2019, 3, 4, 15, 28, 50, 123);
        now.monthOfYear().getAsText();
        now.monthOfYear().getAsText(Locale.KOREAN);
        now.dayOfWeek().getAsShortText();
        now.dayOfWeek().getAsShortText(Locale.CHINESE);

        DateTime now2 = new DateTime();
        DateTime now3 = now.dayOfWeek().roundCeilingCopy();
        System.out.println(now3.toString("yyyy-MM-dd HH:mm:ss SSS"));
        DateTime now4 = now.dayOfWeek().roundFloorCopy();
        System.out.println(now4.toString("yyyy-MM-dd HH:mm:ss SSS"));
        DateTime now5 = now.minuteOfDay().roundFloorCopy();
        System.out.println(now5.toString("yyyy-MM-dd HH:mm:ss SSS"));
        DateTime now6 = now.secondOfMinute().roundCeilingCopy();
        System.out.println(now6.toString("yyyy-MM-dd HH:mm:ss SSS"));
        DateTime now7 = now.secondOfMinute().roundFloorCopy();
        System.out.println(now7.toString("yyyy-MM-dd HH:mm:ss SSS"));

        // Interval
        DateTime start = new DateTime(2004, 1, 1, 0, 0, 0, 0);
        DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
        Interval interval = new Interval(start, end);

        DateTime start2 = interval.getStart();
        DateTime end2 = interval.getEnd();
        DateTime testDate = new DateTime(2004, 2, 1, 0, 0, 0, 0);
        boolean contains = interval.contains(testDate);

        // Duration 表示的目前的时刻再持续多久时间，与之前的Interval时间区间该概念类似，不过单位是毫秒。
        DateTime startDuration = new DateTime(1975, 5, 26, 0, 0, 0);
        Duration oneThousandMillis = new Duration(1000);
        DateTime endDuration = start.plus(oneThousandMillis);

        // Period
        DateTime startPeriod = new DateTime(1975, 5, 26, 0, 0, 0);
        DateTime endPeriod = new DateTime(1975, 5, 28, 0, 0, 0);
        Days days = Days.daysBetween(startPeriod, endPeriod);
        System.out.println(days.getDays());

    }
}
