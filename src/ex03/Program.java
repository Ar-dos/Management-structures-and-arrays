package ex03;

import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    int weeks = 0;
    Scanner sc = new Scanner(System.in);
    long res = 0;
    while (weeks < 18) {
      String input = sc.nextLine();
      if (input.equals("42"))
        break;
      if (input.substring(0, 5).equals("Week ")) {
        weeks++;
        int num_week = 0;
        try {
          num_week = Integer.parseInt(input.substring(5));
        } catch (NumberFormatException e) {
          System.out.print("Illegal Argument");
          System.exit(-1);
        }
        String grades = sc.nextLine();
        res = res + SaveToInt(num_week - 1, CheckGrades(grades));
      }
    }
    sc.close();
    long digit = 10;
    for (int i = 0; i < 18; i++) {
      if ((res % digit) / (digit / 10) != 0) {
        System.out.printf("Week %d ", i + 1);
        for (int j = 0; j < (res % digit) / (digit / 10); j++)
          System.out.printf("=");
        System.out.printf(">\n");
      }
      digit = digit * 10;
    }
  }

  static int CheckGrades(String line) {
    int[] arr = new int[5];
    if (line.length() == 9) {
      for (int i = 0, j = 0; i < line.length(); i = i + 2, j++) {
        int grade = 0;
        try {
          grade = Integer.parseInt(line.substring(i, i + 1));
        } catch (NumberFormatException e) {
          System.out.print("Illegal Argument");
          System.exit(-1);
        }
        if (grade > 0 && grade < 10) {
          arr[j] = grade;
        } else {
          System.out.print("Illegal Argument");
          System.exit(-1);
        }
      }
    }
    return Arrays.stream(arr).min().getAsInt();
  }

  static long SaveToInt(int week, int grade) {
    long digit = 1;
    for (int i = 0; i < week && i < 18; i++)
      digit = digit * 10;
    return grade * digit;
  }
}