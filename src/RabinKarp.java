/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class RabinKarp {
  private long patHash; // pattern hash value
  private int M; // pattern length
  private long Q; // modulus
  private int R; // radix
  private long RM; // R^(M-1) % Q

  public RabinKarp(String pat) {
    M = pat.length();
    R = 256;
    Q = 101;
    RM = 1;
    for (int i = 1; i <= M - 1; i++)
      RM = (R * RM) % Q;
    patHash = hash(pat, M);
  }

  // Compute hash for M-digit key
  private long hash(String key, int M) {
    long h = 0;
    for (int j = 0; j < M; j++)
      h = (R * h + key.charAt(j)) % Q;
    return h;
  }

  public int search(String txt) {
    int N = txt.length();
    long txtHash = hash(txt, M);
    if (patHash == txtHash) return 0;
    for (int i = M; i < N; i++) {
      txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
      txtHash = (txtHash * R + txt.charAt(i)) % Q;
      if (patHash == txtHash) return i - M + 1;
    }
    return N;
  }

  public static void main(String[] args) {
    final String pat = "ABC";
    final String text = "ABAAABCD";
    System.out.println(new RabinKarp(pat).search(text));
  }
}
