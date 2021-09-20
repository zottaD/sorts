/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class QuickSort {


  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] sequence) {
    Shuffle.shuffle(sequence);
    sort(sequence, 0, sequence.length - 1);
  }

  private static void sort(Comparable[] sequence, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int j = partition(sequence, lo, hi);
    sort(sequence, lo, j - 1);
    sort(sequence, j + 1, hi);
  }

  private static int partition(Comparable[] sequence, int lo, int hi) {
    int i = lo, j = hi + 1;
    while (true) {
      while (Util.less(sequence[++i], sequence[lo]))
        if (i == hi) break;
      while (Util.less(sequence[lo], sequence[--j]))
        if (j == lo) break;

      if (i >= j) break;
      Util.exchange(sequence, i, j);
    }
    Util.exchange(sequence, lo, j);
    return j;
  }

}
