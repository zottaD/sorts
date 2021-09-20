import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class BreadthFirstPaths {

  private boolean[] marked;
  private int[] edgeTo;
  private int s;

  private BreadthFirstPaths(Graph G, int s) {
    this.s = s;
    marked = new boolean[G.V];
    edgeTo = new int[G.V];
    bfs(G, s);
  }

  private void bfs(Graph G, int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    marked[s] = true;
    while (!q.isEmpty()) {
      int v = q.poll();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          q.add(w);
          marked[w] = true;
          edgeTo[w] = v;
        }
      }
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

  public static void main(String[] args) {
    final Graph graph = new Graph(6);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(3, 5);
    graph.addEdge(4, 5);
    graph.addEdge(0, 5);
    final BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
    System.out.println(breadthFirstPaths.pathTo(4));
  }
}
