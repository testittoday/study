package qiao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author liqiao
 * 
 */
public class CountingSundays {

	public static int getSundayCount(Date start, Date end) {
		// get the day of the start day
		// calculate how many days between start and end
		// get the modular value of the difference against 7
		// return the day matches with the modular value
		return 0;
	}

	private static int getDaysBetween(Date start, Date end) {
		return 0;
	}

	private static Day get(Date date) {
		// 1. calculate how many days between the date and Jan 1st, 1900
		// 1.1 get days for each month starting from Jan 1900
		// 1.2 get days from month start to date
		int totalDays = 0;
		for (int y = 1900; y <= date.year; y++) {
			for (int m = 1; m <= 12; m++) {
				if (y < date.year || (y == date.year && m < date.month)) {
					totalDays += getDaysInMonth(m, y);
				} else {
					totalDays += date.day;
				}

			}
		}
		// 2. get the modular value of the difference against 7
		int day = totalDays % 7;
		// 3. return the day matches with the modular value
		return Day.valueOf(day);
	}

	private static int getDaysUntilMonthEnd(int m, int d, int y) {
		return getDaysInMonth(m, y) - d;
	}

	private static int getDaysInMonth(int m, int y) {
		switch (m) {
		case 2:
			boolean isLeapYear = false;
			if (y % 4 == 0) {
				isLeapYear = true;
				if (y % 100 == 0 && y % 400 != 0) {
					isLeapYear = false;
				}
			}
			if (isLeapYear) {
				return 29;
			} else {
				return 28;
			}
		case 9:
		case 4:
		case 6:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	private enum Day {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
		private static final Map<Integer, Day> m_valueMap = new HashMap<Integer, Day>();
		static {
			m_valueMap.put(0, Monday);
			m_valueMap.put(1, Tuesday);
			m_valueMap.put(2, Wednesday);
			m_valueMap.put(3, Thursday);
			m_valueMap.put(4, Friday);
			m_valueMap.put(5, Saturday);
			m_valueMap.put(6, Sunday);
		}

		public static Day valueOf(int value) {
			return m_valueMap.get(value);
		}
	}

	private class Date {
		int month;
		int day;
		int year;
	}

}
