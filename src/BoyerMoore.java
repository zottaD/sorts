/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class BoyerMoore {

  private static final int R = 256;
  private final int[] badMatchTable;
  private String pat;

  public BoyerMoore(String pat) {
    this.pat = pat;
    badMatchTable = new int[R];
    for (int c = 0; c < R; c++)
      badMatchTable[c] = -1;
    for (int j = 0; j < pat.length(); j++)
      badMatchTable[pat.charAt(j)] = j;
  }

  public int search(String txt)
  {
    int N = txt.length();
    int M = pat.length();
    int skip;
    for (int i = 0; i <= N-M; i += skip)
    {
      skip = 0;
      for (int j = M-1; j >= 0; j--)
      {
        if (pat.charAt(j) != txt.charAt(i+j))
        {
          skip = Math.max(1, j - badMatchTable[txt.charAt(i+j)]);
          break;
        }
      }
      if (skip == 0) return i;
    }
    return N;
  }

  public static void main(String[] args) {
    final String pat = "ABC";
    final String text = "ABAAABCD";
    System.out.println(new BoyerMoore(pat).search(text));
  }

}
