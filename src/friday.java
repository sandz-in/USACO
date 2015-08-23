/*
ID: sandyri1
LANG: JAVA
TASK: friday
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class friday {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new File("friday.out"));
        int years = sc.nextInt();

        int frequency[] = new int[7];
        Arrays.fill(frequency, 0);

        int calendarDay = 0;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int end = 1900 + years;
        for (int year = 1900; year < end; year++) {
            for (int month = 0; month < 12; month++) {
                int day = (calendarDay + 12) % 7;
                frequency[day]++;
                calendarDay += isLeapYear(year) ? leapDays[month] : days[month];
            }
        }

        out.print(frequency[5]);
        out.print(' ');
        out.print(frequency[6]);
        out.print(' ');
        out.print(frequency[0]);
        out.print(' ');
        out.print(frequency[1]);
        out.print(' ');
        out.print(frequency[2]);
        out.print(' ');
        out.print(frequency[3]);
        out.print(' ');
        out.println(frequency[4]);

        out.close();
    }

    public static boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}