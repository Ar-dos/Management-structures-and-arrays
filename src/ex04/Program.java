package ex04;

import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();

    char[] ch = input.toCharArray();
    ArrayList<Character> dist_ch = new ArrayList<Character>();
    ArrayList<Integer> freq = new ArrayList<Integer>();
    for (int i = 0; i < input.length(); i++) {
      if (!dist_ch.contains(ch[i])) {
        dist_ch.add(ch[i]);
        freq.add(1);
      } else {
        int index = dist_ch.indexOf(ch[i]);
        freq.set(index, freq.get(index) + 1);
      }
    }

    sc.close();

    for (int i = 0; i < freq.size(); i++) {
      for (int j = i + 1; j < freq.size(); j++) {
        if (freq.get(i) < freq.get(j)) {
          int temp = freq.get(i);
          freq.set(i, freq.get(j));
          freq.set(j, temp);
          char t = dist_ch.get(i);
          dist_ch.set(i, dist_ch.get(j));
          dist_ch.set(j, t);
        }
      }
    }

    for (int i = 0; i < freq.size() - 1; i++) {
      if (freq.get(i) == freq.get(i + 1) &&
          dist_ch.get(i) > dist_ch.get(i + 1)) {
        int temp = freq.get(i + 1);
        freq.set(i + 1, freq.get(i));
        freq.set(i, temp);
        char t = dist_ch.get(i + 1);
        dist_ch.set(i + 1, dist_ch.get(i));
        dist_ch.set(i, t);
      }
    }
    double height = (double)freq.get(0) / 10.0;
    boolean graph[] = new boolean[freq.size()];
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < freq.size() && j < 10; j++) {
        if (freq.get(j) >= (10 - i) * height) {
          if (graph[j] == true) {
            System.out.printf("  # ");
          } else {
            System.out.printf("%3d ", freq.get(j));
            graph[j] = true;
          }
        } else if (freq.get(j) < (10 - i) * height)
          System.out.printf(" ");
      }
      System.out.printf("\n");
    }
    for (int i = 0; i < dist_ch.size() && i < 10; i++)
      System.out.printf("  %c ", dist_ch.get(i));
  }
}
