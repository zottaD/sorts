/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class MyKMP {

  public int search(String text, String pat) {
    final int pLength = pat.length();
    final int tLength = text.length();

    int[] lps = new int[pLength];

    computeLPS(lps, pat, pLength);

    int i = 0, j = 0;

    while (i < tLength) {
      if (text.charAt(i) == pat.charAt(j)) {
        i++;
        j++;
      } else if (j == 0) {
        i++;
      } else {
        j = lps[j - 1];
      }
      if (j == pLength) return i - j;
    }

    return 0;
  }

  private void computeLPS(int[] lps, String pat, int pLength) {
    int i = 1;
    lps[0] = 0;
    int length = 0;

    while (i < pLength) {
      if (pat.charAt(i) == pat.charAt(length)) {
        length++;
        lps[i] = length;
        i++;
      } else {
        if (length == 0) {
          lps[i] = 0;
          i++;
        } else {
          length = lps[length - 1];
        }
      }
    }
  }


  public static void main(String[] args) {
    String txt = "ABABDABACDABABCABAB";
    String pat = "ABABCABAB";
    System.out.println(new MyKMP().search(txt, pat));
  }
}
