package ex05;

import java.lang.String;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 0;
    ArrayList<String> student = new ArrayList<String>();
    ArrayList<LocalDateTime> dates = new ArrayList<>();
    ArrayList<Integer> atten = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> hour = new ArrayList<>();
    ArrayList<Integer> day = new ArrayList<>();

    while (count < 10) {
      String input = sc.nextLine();
      if (input.equals(".")) {
        break;
      } else {
        student.add(input);
      }
    }
    count = 0;
    while (count < 10) {
      String input = sc.nextLine();
      if (input.equals(".")) {
        break;
      } else {
        dates.addAll(
            GetAllDaysDateBetween(ConvertFromShort(input.substring(2)),
                                  Integer.parseInt(input.substring(0, 1))));
      }
    }
    dates = SortDates(dates);
    count = 0;
    while (count < 10) {
      String input = sc.nextLine();
      if (input.equals(".")) {
        break;
      } else {
        String[] split = input.split("\\s+");
        name.add(split[0]);
        hour.add(Integer.parseInt(split[1]));
        day.add(Integer.parseInt(split[2]));
        atten.add(ConvertAtten(split[3]));
      }
    }
    sc.close();

    System.out.printf("%10c", ' ');
    for (int i = 0; i < dates.size(); i++) {
      System.out.printf("%d:00 %s %2d|", dates.get(i).getHour(),
                        ConvertToShort(dates.get(i)),
                        dates.get(i).getDayOfMonth());
    }
    System.out.printf("\n");
    for (int i = 0; i < student.size(); i++) {
      System.out.printf("%10s", student.get(i));
      for (int j = 0; j < dates.size(); j++) {
        int search = -1;
        for (int k = 0; k < atten.size(); k++) {
          if (name.get(k).equals(student.get(i)) &&
              hour.get(k) == dates.get(j).getHour() &&
              day.get(k) == dates.get(j).getDayOfMonth())
            search = k;
        }
        if (search > -1)
          System.out.printf("%10d|", atten.get(search));
        else
          System.out.printf("%11c", '|');
      }
      System.out.printf("\n");
    }
  }

  public static int ConvertAtten(String s) {
    int res = 0;
    if (s.equals("NOT_HERE"))
      res = -1;
    else if (s.equals("HERE"))
      res = 1;
    return res;
  }

  public static ArrayList<LocalDateTime> SortDates(ArrayList<LocalDateTime> d) {
    for (int i = 0; i < d.size(); i++) {
      for (int j = i + 1; j < d.size(); j++) {
        if (d.get(i).getDayOfMonth() > d.get(j).getDayOfMonth()) {
          LocalDateTime temp = d.get(i);
          d.set(i, d.get(j));
          d.set(j, temp);
        }
      }
    }
    return d;
  }

  public static ArrayList<LocalDateTime>
  GetAllDaysDateBetween(DayOfWeek dayOfWeek, int h) {
    ArrayList<LocalDateTime> daysDateList = new ArrayList<>();
    LocalDateTime start = LocalDateTime.of(2020, 9, 1, 0, 0);
    LocalDateTime end = LocalDateTime.of(2020, 10, 1, 0, 0);
    while (start.isBefore(end)) {
      if (start.getDayOfWeek() == dayOfWeek) {
        daysDateList.add(start.withHour(h));
        start = start.plusDays(7);
      } else {
        start = start.plusDays(1);
      }
    }

    return daysDateList;
  }

  static DayOfWeek ConvertFromShort(String d) {
    DayOfWeek res = DayOfWeek.MONDAY;
    if (d.equals("TU"))
      res = DayOfWeek.TUESDAY;
    else if (d.equals("WE"))
      res = DayOfWeek.WEDNESDAY;
    else if (d.equals("TH"))
      res = DayOfWeek.THURSDAY;
    else if (d.equals("FR"))
      res = DayOfWeek.FRIDAY;
    else if (d.equals("SA"))
      res = DayOfWeek.SATURDAY;
    else if (d.equals("SU"))
      res = DayOfWeek.SUNDAY;
    return res;
  }

  static String ConvertToShort(LocalDateTime d) {

    DayOfWeek t = d.getDayOfWeek();
    String res = "";
    if (t == DayOfWeek.MONDAY)
      res = "MO";
    else if (t == DayOfWeek.TUESDAY)
      res = "TU";
    else if (t == DayOfWeek.WEDNESDAY)
      res = "WE";
    else if (t == DayOfWeek.THURSDAY)
      res = "TH";
    else if (t == DayOfWeek.FRIDAY)
      res = "FR";
    else if (t == DayOfWeek.SATURDAY)
      res = "SA";
    else if (t == DayOfWeek.SUNDAY)
      res = "SU";
    return res;
  }
}