/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class HeapSort {


  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int k = N / 2 - 1; k >= 0; k--)
      sink(a, k, N - 1);
    while (N - 1 > 0) {
      exch(a, 0, N - 1);
      sink(a, 0, --N - 1);
    }
  }


  private static void sink(Comparable[] a, int k, int N) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(a, j - 1, j)) j++;
      if (!less(a, k - 1, j - 1)) break;
      exch(a, k - 1, j - 1);
      k = j;
    }
  }

  private static boolean less(Comparable[] a, int i, int j) {
    return a[i].compareTo(a[j]) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
