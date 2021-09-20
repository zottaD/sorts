import java.util.Arrays;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class QuickSelect {

  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    System.out.println(select(randomArray, 4));
    QuickSort.sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));

  }

  public static Comparable select(Comparable[] a, int k) {
    Shuffle.shuffle(a);
    int lo = 0, hi = a.length - 1;
    while (hi > lo)
    {
      int j = partition(a, lo, hi);
      if (j < k) lo = j + 1;
      else if (j > k) hi = j - 1;
      else return a[k];
    }
    return a[k];
  }


  private static int partition(Comparable[] sequence, int lo, int hi) {
    int i = lo, j = hi + 1;
    while (true) {
      while (Util.less(sequence[++i], sequence[lo])) {
        if (i == hi) {
          break;
        }
      }
      while (Util.less(sequence[lo], sequence[--j])) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      Util.exchange(sequence, i, j);
    }
    Util.exchange(sequence, lo, j);
    return j;
  }
}
