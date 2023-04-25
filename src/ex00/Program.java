package ex00;

public class Program {
  public static void main(String[] args) {
    int num = 479598;
    int digit = 0;
    int res = 0;
    while (num != 0) {
      digit = num % 10;
      res = res + digit;
      num = num / 10;
    }
    System.out.println(res);
  }
}