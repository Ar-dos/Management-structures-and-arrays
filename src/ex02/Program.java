package ex02;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    int res = 0;
    Scanner sc = new Scanner(System.in);
    while (true) {
      int input = sc.nextInt();
      if (input > 1) {
        if (input == 42)
          break;
        if (IsPrime(DigitSum(input)))
          res++;
      }
    }
    sc.close();
    System.out.println("Count of coffee-request – " + res);
  }

  static boolean IsPrime(int num) {
    boolean flag = true;
    if (num < 3) {
      flag = false;
    } else {
      for (int i = 2; i * i <= num; i++) {
        if ((num % i) == 0) {
          flag = false;
          break;
        }
      }
    }
    return flag;
  }

  static int DigitSum(int num) {
    int digit = 0;
    int res = 0;
    while (num != 0) {
      digit = num % 10;
      res = res + digit;
      num = num / 10;
    }
    return res;
  }
}
