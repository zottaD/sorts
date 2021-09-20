/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class MyBoyerMoore {
  public static void main(String[] args) {
    final String pat = "ABC";
    final String text = "ABAAABCD";
    System.out.println(new MyBoyerMoore().search(text, pat));
  }

  private int search(String text, String pat) {
    final int tLength = text.length();
    final int pLength = pat.length();
    final int[] shiftTable = new int[256];
    buildShiftTable(shiftTable, pat);
    int shift;
    for (int i = 0; i < tLength - pLength; i = i + shift) {
      shift = 0;
      int j =0;
      for (j = pLength - 1; j >= 0; j--) {
        if (pat.charAt(j) != text.charAt(i + j)) {
          shift = Math.max(1, j - shiftTable[text.charAt(i + j)]);
          break;
        }
      }
      if (shift == 0) {
        return i;
      }
    }
    return 0;
  }

  private void buildShiftTable(int[] shiftTable, String pat) {
    for (int i = 0; i < 256; i++) {
      shiftTable[i] = -1;
    }

    for (int i = 0; i < pat.length(); i++) {
      shiftTable[pat.charAt(i)] = i;
    }
  }
}
