import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class KeyIndexedSort {

  private static final int R = 6;

  public static void main(String[] args) {

    final List<String> list = Arrays.asList("aaab", "abb", "aabb", "aaaa");
    Collections.sort(list);
    final char[] chars = new char[6];
    chars[0] = 'b';
    chars[1] = '1';
    chars[2] = 'a';
    chars[3] = 'c';
    chars[4] = 'f';
    chars[5] = 'e';
    System.out.println(chars);
    sort(chars);
    System.out.println(chars);
  }

  public static void sort(char[] a) {
    int N = a.length;
    int[] count = new int[R+1];

    for (int i = 0; i < N; i++)
      count[(a[i] - 'a')+1]++;

    for (int r = 0; r < R; r++)
      count[r+1] += count[r];

    final char[] aux = new char[N];
    for (int i = 0; i < N; i++)
      aux[count[(a[i] - 'a')]++] = a[i];

    for (int i = 0; i < N; i++)
      a[i] = aux[i];
  }
}
