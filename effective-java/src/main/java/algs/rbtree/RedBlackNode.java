package algs.rbtree;

/**
 * This node could be an inner class of the tree
 * For now it is stand alone with package private fields
 * @author garystruthers
 *
 */
public class RedBlackNode<U extends Comparable<? super U>> {
  static final boolean RED = true;
  static final boolean BLACK = false;
  
  String key;
  U value;
  RedBlackNode<U> left;
  RedBlackNode<U> right;
  boolean parentLinkColor;
  int subtreeCount;
  
  public RedBlackNode(String key, U value, boolean color, int subTreeCount) {
    this.key = key;
    this.value = value;
    this.parentLinkColor = color;
    this.subtreeCount = subTreeCount;
  }
  
  boolean isRed() {
    return (parentLinkColor == RED);
  }

  int sizeOfSubTree() {
    return subtreeCount;
  }
}
