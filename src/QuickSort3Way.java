/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class QuickSort3Way {


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

  private static void sort(Comparable[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int lt = lo, gt = hi;
    Comparable v = a[lo];
    int i = lo;
    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        Util.exchange(a, lt++, i++);
      } else if (cmp > 0) {
        Util.exchange(a, i, gt--);
      } else {
        i++;
      }
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);

  }

}
