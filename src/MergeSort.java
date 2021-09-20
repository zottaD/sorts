/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class MergeSort {


  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] sequence) {
    final Comparable[] aux = new Comparable[sequence.length];
    sort(sequence, aux, 0, sequence.length - 1);
  }

  private static void sort(Comparable[] sequence, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(sequence, aux, lo, mid);
    sort(sequence, aux, mid + 1, hi);
    merge(sequence, aux, lo, mid, hi);
  }

  private static void merge(Comparable[] sequence, Comparable[] aux, int lo, int mid, int hi) {
    System.arraycopy(sequence, lo, aux, lo,hi - lo + 1);
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        sequence[k] = aux[j++];
      } else if (j > hi) {
        sequence[k] = aux[i++];
      } else if (Util.less(aux[j], aux[i])) {
        sequence[k] = aux[j++];
      } else {
        sequence[k] = aux[i++];
      }
    }
    Util.print(sequence);
  }

}
