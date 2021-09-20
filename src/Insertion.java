import java.util.Comparator;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class Insertion {

  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] sequence) {
    final int length = sequence.length;
    for (int i = 0; i < length; i++) {
      for (int j = i; j > 0; j--) {
        if (Util.less(sequence[j], sequence[j - 1])) {
          Util.exchange(sequence, j, j - 1);
          System.out.println("i = " + i);
          Util.print(sequence);
        } else {
          break;
        }
      }
    }
  }

  public static void sort(Object[] a, Comparator comparator)
  {
    int N = a.length;
    for (int i = 0; i < N; i++)
      for (int j = i; j > 0 && Util.less(comparator, a[j], a[j-1]); j--)
        Util.exchange(a, j, j-1);
  }
}
