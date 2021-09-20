/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class MyQuickSort3Way {


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
    int i = lo, lt = lo, gt = hi;
    Comparable part = sequence[lo];
    while (i <= gt) {
      final int compare = sequence[i].compareTo(part);
      if (compare < 0) {
        Util.exchange(sequence, lt++, i++);
      } else if (compare > 0) {
        Util.exchange(sequence, i, gt--);
      } else {
        i++;
      }
    }
    sort(sequence, lo, lt - 1);
    sort(sequence, gt + 1, hi);
  }

}
