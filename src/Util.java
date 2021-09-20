import java.util.Comparator;
import java.util.Random;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class Util {

  public static boolean isSorted(Comparable[] sequence) {
    for (int i = 1; i < sequence.length; i++) {
      if (less(sequence[i], sequence[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void print(Comparable[] sequence) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sequence.length; i++) {
      sb.append(sequence[i]).append(" ");
    }
    System.out.println(sb.toString());
    System.out.println("--------------------------------");
  }

  public static boolean less(Comparable first, Comparable second) {
    return first.compareTo(second) < 0;
  }

  public static void exchange(Comparable[] sequence, int position1, int position2) {
    final Comparable temp = sequence[position1];
    sequence[position1] = sequence[position2];
    sequence[position2] = temp;
  }

  public static Integer[] randomArray() {
    final Random random = new Random();
    Integer[] array = new Integer[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(10);
//      array[i] = i + 1;
    }
    return array;
  }

  public static boolean less(Comparator c, Object v, Object w) {
    return c.compare(v, w) < 0;
  }

  public static void exchange(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
}
