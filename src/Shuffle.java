import java.util.Random;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class Shuffle {
  public static void main(String[] args) {
    final Integer[] randomArray = Util.randomArray();
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    ShellSort.mySort(randomArray);
    Util.print(randomArray);
    System.out.println(Util.isSorted(randomArray));
    shuffle(randomArray);
    Util.print(randomArray);
  }

  public static void shuffle(Comparable[] sequence) {
    final int length = sequence.length;
    final String s = new String();
    final Random random = new Random();
    for (int i = 0; i < length; i++) {
      final int r = random.nextInt(i + 1);
      Util.exchange(sequence, i, r);
//      Util.print(sequence);
    }
  }
}
