/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class MergeBUSort {


  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] sequence) {
    int N = sequence.length;
    Comparable[] aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz+sz)
      for (int lo = 0; lo < N-sz; lo += sz+sz)
        merge(sequence, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
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
