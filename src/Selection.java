/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class Selection {

  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    sort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] sequence) {
    for (int i = 0; i < sequence.length; i++) {
      int min = i;
      for (int j = i + 1; j < sequence.length; j++) {
        if (Util.less(sequence[j], sequence[min])) {
          min = j;
        }
      }
      Util.exchange(sequence, i, min);
      Util.print(sequence);
    }
  }
}
