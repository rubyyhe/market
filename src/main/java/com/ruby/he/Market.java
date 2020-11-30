package com.ruby.he;

import java.util.Date;
import java.util.Calendar;

public class Market {

    /**
     * The markets are closed on the following days
     *     Weekends
     *     New Year's Day
     *     Martin Luther King Day
     *     President's Day
     *     Good Friday
     *     Memorial Day
     *     Independence Day
     *     Labor Day
     *     Thanksgiving
     *     Christmas
     *
     * If one of the holidays falls on a Saturday it is observed on the preceeding  Friday
     * If it falls on a Sunday it is observed on the following Monday
     * @param date
     * @return isMarketOpen boolean
     */
    public static boolean isMarketOpen(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int dayOfWeekInMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        // Weekend
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
            return false;
        }
        // New Year's Day
        if (month == Calendar.JANUARY && dayOfMonth == 2) {
            return false;
        }
        // Martin Luther King Day
        if (month == Calendar.JANUARY && dayOfWeekInMonth == 3 && dayOfWeek ==  Calendar.MONDAY) {
            return false;
        }
        // President's Day
        if (month == Calendar.FEBRUARY && dayOfWeekInMonth == 3 && dayOfWeek ==  Calendar.MONDAY) {
            return false;
        }
        // Good Friday (uses lunar calendar calculations)
        if (isGoodFriday(date))
            return false;
        // Independence Day
        if (month == Calendar.JULY && dayOfMonth == 4) {
            return false;
        }
        // Labor Day
        if (month == Calendar.SEPTEMBER && dayOfWeekInMonth == 1 && dayOfWeek ==  Calendar.MONDAY) {
            return false;
        }
        // Thanksgiving
        if (month == Calendar.NOVEMBER && dayOfWeekInMonth == 4 && dayOfWeek ==  Calendar.THURSDAY) {
            return false;
        }
        // Christmas
        if (month == Calendar.DECEMBER && dayOfMonth == 25) {
            return false;
        }
        // Otherwise the market is open
        return true;
    }

    private static boolean isGoodFriday(Date date) {
        // Dummy func, no impl
        return false;
    }

}
