/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class BST<Key extends Comparable<Key>, Value> {
  public static void main(String[] args) {
    final BST<Integer, String> bst = new BST<>();
    bst.put(7, "aa");
    bst.put(5, "aa");
    bst.put(6, "aa");
    bst.put(3, "aa");
    bst.put(1, "aa");
    bst.put(0, "aa");
    bst.put(2, "aa");
    bst.put(8, "aa");
    bst.get(6);
    bst.delete(5);
  }

  private Node root;

  private class Node {
    private Key key;
    private Value val;
    private Node left, right;
    private int count;

    public Node(Key key, Value val) {
      this.key = key;
      this.val = val;
    }
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val);
    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      x.left = put(x.left, key, val);
    else if (cmp > 0)
      x.right = put(x.right, key, val);
    else if (cmp == 0)
      x.val = val;
    return x;
  }

  public Value get(Key key) {
    Node x = root;
    while (x != null) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) x = x.left;
      else if (cmp > 0) x = x.right;
      else if (cmp == 0) return x.val;
    }
    return null;
  }

  public void delete(Key key) {
    root = delete(root, key);
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node x) {
    if (x.left == null) return x.right;
    x.left = deleteMin(x.left);
    x.count = 1 + size(x.left) + size(x.right);
    return x;
  }

  private Node delete(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) x.left = delete(x.left, key);
    else if (cmp > 0) x.right = delete(x.right, key);
    else {
      if (x.right == null) return x.left;
      if (x.left == null) return x.right;
      Node t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.count = size(x.left) + size(x.right) + 1;
    return x;
  }

  private Node min(Node node) {
    if (node.left == null) return node;
    return min(node.left);
  }

  public int rank(Key key) {
    return rank(key, root);
  }

  private int rank(Key key, Node x) {
    if (x == null) return 0;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) return rank(key, x.left);
    else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
    else return size(x.left);
  }

  public int size() {
    return size(root);
  }

  private int size(Node x) {
    if (x == null) return 0;
    return x.count;
  }

  public Iterable<Key> iterator() { /* see next slides */
    return null;
  }
}
