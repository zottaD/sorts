/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class KMP {
  private final String pat;
  private final int[][] dfa;
  private final int M;
  private final int R = 3;

  public KMP(String pat) {
    this.pat = pat;
    M = pat.length();
    dfa = new int[R][M];
    dfa[pat.charAt(0) - 97][0] = 1;
    for (int X = 0, j = 1; j < M; j++) {
      for (int c = 0; c < R; c++)
        dfa[c][j] = dfa[c][X];
      dfa[pat.charAt(j) - 97][j] = j + 1;
      X = dfa[pat.charAt(j) - 97][X];
    }
  }

  public int search(String txt) {
    int i, j, N = txt.length();
    for (i = 0, j = 0; i < N && j < M; i++)
      j = dfa[txt.charAt(i)][j];
    if (j == M) return i - M;
    else return N;
  }

  public static void main(String[] args) {
    final int search = new KMP("abc").search("aabc");
  }
}
