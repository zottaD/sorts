import java.util.Stack;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private int s;

  public DepthFirstPaths(Graph G, int s) {
// this.s = s;
// marked = new boolean[G.]
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v))
      if (!marked[w]) {
        dfs(G, w);
        edgeTo[w] = v;
      }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x])
      path.push(x);
    path.push(s);
    return path;
  }
}
