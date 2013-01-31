package algs.rbtree;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class RedBlackTree<U extends Comparable<? super U>> {
  private RedBlackNode<U> root;
  
  public RedBlackTree() {
    super();
  }
  
  public int subTreeSize(RedBlackNode<U> node) {
    if(node == null) {
      return 0;
    }
    return node.sizeOfSubTree();
  }
  
  public int treeSize() {
    return root.sizeOfSubTree();
  }  
  
  public boolean isTreeEmpty() {
    return root == null;
  }
  
  public boolean isRed(RedBlackNode<U> node) {
    if(node == null) {
      return false;
    }
    return node.isRed();
  }
  
  public U get(String key) {
     return get(root, key);
  }

  
  public boolean contains(String key) {
    return get(root, key) != null;
  }
  
  public boolean contains(RedBlackNode<U> node, String key) {
    return get(node, key) != null;
  }
  
  public void put(String key, U value) {
    //checkArgument(expression, errorMessage)
    root = put(root, key, value);
    root.parentLinkColor = RedBlackNode.BLACK;
    //checkState(expression, errorMessage)
  }
  
  public String select(int rank) {
    if(rank < 0 || rank >= treeSize()) {
      return null;
    }
    RedBlackNode<U> node = select(root, rank);
    return node.key;
  }
  
  private RedBlackNode<U> select(RedBlackNode<U> node, int rank) {
    checkNotNull(node, "node arg to select is null");
    checkArgument(rank >= 0 && rank < subTreeSize(node), "rank arg to select not in tree size");
    int temp = subTreeSize(node.left);
    if(temp > rank) {
      return select(node.left, rank);
    } else if (temp < rank) {
      return select(node.right, rank - temp - 1);
    } else return node;
  }
  
  private U get(RedBlackNode<U> node, String key) {
    while (node != null) {
      int compResult = key.compareTo(node.key);
      if (compResult < 0) {
        node = node.left;
      } else if (compResult > 0) {
        node = node.right;
      } else {
        return node.value;
      }
    }
    return null;
  }
  
  private RedBlackNode<U> put(RedBlackNode<U> node, String key, U value) {
    if(node == null) {
      return new RedBlackNode<U>(key, value, RedBlackNode.RED, 1);
    }
    int compResult = key.compareTo(node.key);
    if (compResult < 0) {
      node.left = put(node.left, key, value);
    } else if (compResult > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    
    if(isRed(node.right) && !isRed(node.left)) {
      node = rotateLeft(node);
    }
    if(isRed(node.left) && isRed(node.left.left)) {
      node = rotateRight(node);
    }
    if(isRed(node.left) && isRed(node.right)) {
      toggleColors(node);
    }
    node.subtreeCount = subTreeSize(node.left) + subTreeSize(node.right) + 1;
    return node;
  }
  
  private RedBlackNode<U> rotateRight(RedBlackNode<U> node) {
    checkNotNull(node, "node arg to rotateRight is null");
    checkArgument(isRed(node.left), "node.left arg to rotateRight is not RED");
    RedBlackNode<U> leftChild = node.left;
    node.left = leftChild.right;
    leftChild.right = node;
    leftChild.parentLinkColor = leftChild.right.parentLinkColor;
    leftChild.right.parentLinkColor = RedBlackNode.RED;
    leftChild.subtreeCount = node.subtreeCount;
    node.subtreeCount = subTreeSize(node.left) + subTreeSize(node.right) + 1;
    return leftChild;
  }
  
  private RedBlackNode<U> rotateLeft(RedBlackNode<U> node) {
    checkNotNull(node, "node arg to rotateLeft is null");
    checkArgument(node.right.isRed(), "node.right arg to rotateLeft is not RED");
    RedBlackNode<U> rightChild = node.right;
    node.right = rightChild.left;
    rightChild.left = node;
    rightChild.parentLinkColor = rightChild.left.parentLinkColor;
    rightChild.left.parentLinkColor = RedBlackNode.RED;
    rightChild.subtreeCount = node.subtreeCount;
    node.subtreeCount = subTreeSize(node.left) + subTreeSize(node.right) + 1;
    return rightChild;
  }
  
  private void toggleColors(RedBlackNode<U> node) {
    checkNotNull(node, "node arg to toggleColors is null");
    checkNotNull(node.left, "node left arg to toggleColors is null");
    checkNotNull(node.right, "node right arg to toggleColors is null");
    checkArgument((!isRed(node) && isRed(node.left) && isRed(node.right)) ||
        (isRed(node) && !isRed(node.left) && !isRed(node.right)), 
        "1. node must have opposite color of its left and right node" +
        "2. node must have opposite color of its left and right node");
    node.parentLinkColor = !node.parentLinkColor;
    node.left.parentLinkColor = !node.left.parentLinkColor;
    node.right.parentLinkColor = !node.right.parentLinkColor;
  }
}
