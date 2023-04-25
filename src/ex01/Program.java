package ex01;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    if (input < 2) {
      System.out.print("Illegal Argument");
      System.exit(-1);
    } else {
      int count = 1;
      boolean flag = true;
      for (int i = 2; i * i <= input; i++) {
        if ((input % i) == 0) {
          flag = false;
          break;
        }
        count++;
      }
      System.out.printf("%b %d", flag, count);
    }
    sc.close();
  }
}