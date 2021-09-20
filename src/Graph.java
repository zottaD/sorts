import java.util.LinkedList;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class Graph {
  public final int V;
  private LinkedList<Integer>[] adj;

  public Graph(int V) {
    this.V = V;
    adj = new LinkedList[V];
    for (int v = 0; v < V; v++)
      adj[v] = new LinkedList<>();
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public static void main(String[] args) {
    final Graph graph = new Graph(5);
    System.out.println(graph.adj(0));
    graph.addEdge(0, 1);
    System.out.println(graph.adj(0));
  }
}
