/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class ShellSort {

  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    mySort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
  }

  public static void sort(Comparable[] sequence) {
    final int length = sequence.length;
    int h = 1;
    while (h < length / 3) h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < length; i++) {
        for (int j = i; j >= h; j -= h) {
          if (Util.less(sequence[j], sequence[j - h])) {
            Util.exchange(sequence, j, j - h);
          }
          System.out.println("h= " + h);
          Util.print(sequence);
        }
      }
      h = h / 3;
    }
  }


  public static void mySort(Comparable[] sequence) {
    final int length = sequence.length;
    int h = 1;
    while (h < length / 3) {
      h = h * 3 + 1;
    }
    while (h >= 1) {
      for (int i = h; i < length; i++) {
        for (int j = i; j >= h; j -= h) {
          if (Util.less(sequence[j], sequence[j - h])) {
            Util.exchange(sequence, j, j - h);
            System.out.println("h= " + h);
            System.out.println("i= " + i);
            System.out.println("j= " + j);
            Util.print(sequence);
          }
        }
      }
      h = h/3;
    }
  }
}
