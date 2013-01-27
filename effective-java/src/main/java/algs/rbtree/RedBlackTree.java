package algs.rbtree;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class RedBlackTree {
  private RedBlackNode root;
  
  public int treeSize() {
    return root.sizeOfSubTree();
  }
  
  public boolean isTreeEmpty() {
    return root == null;
  }
  
  public String get(String key) {
     return get(root, key);
  }
  
  private String get(RedBlackNode node, String key) {
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
  
  public boolean contains(String key) {
    return get(root, key) != null;
  }
  
  public boolean contains(RedBlackNode node, String key) {
    return get(node, key) != null;
  }
  
  public void put(String key, String value) {
    //checkArgument(expression, errorMessage)
    root = null; // put(root, key, value);
    root.parentLinkColor = RedBlackNode.BLACK;
    //checkState(expression, errorMessage)
  }
  
  private RedBlackNode put(RedBlackNode node, String key, String value) {
    if(node == null) {
      return new RedBlackNode(key, value, RedBlackNode.RED, 1);
    }
    int compResult = key.compareTo(node.key);
    if (compResult < 0) {
      node.left = put(node.left, key, value);
    } else if (compResult > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    
    if(node.right.isRed() && !node.left.isRed()) {
      node = rotateLeft(node);
    }
    if(node.left.isRed() && node.left.left.isRed()) {
      node = rotateRight(node);
    }
    if(node.left.isRed() && node.right.isRed()) {
      toggleColors(node);
    }
    node.subtreeCount = node.left.subtreeCount + node.right.subtreeCount + 1;
    return node;
  }
  
  private RedBlackNode rotateRight(RedBlackNode node) {
    checkNotNull(node, "node arg to rotateRight is null");
    checkArgument(node.left.isRed(), "node.left arg to rotateRight is not RED");
    RedBlackNode leftChild = node.left;
    node.left = leftChild.right;
    leftChild.right = node;
    leftChild.parentLinkColor = leftChild.right.parentLinkColor;
    leftChild.right.parentLinkColor = RedBlackNode.RED;
    leftChild.subtreeCount = node.subtreeCount;
    node.subtreeCount = node.left.subtreeCount + node.right.subtreeCount + 1;
    return leftChild;
  }
  
  private RedBlackNode rotateLeft(RedBlackNode node) {
    checkNotNull(node, "node arg to rotateLeft is null");
    checkArgument(node.right.isRed(), "node.right arg to rotateLeft is not RED");
    RedBlackNode rightChild = node.right;
    node.right = rightChild.left;
    rightChild.left = node;
    rightChild.parentLinkColor = rightChild.left.parentLinkColor;
    rightChild.left.parentLinkColor = RedBlackNode.RED;
    rightChild.subtreeCount = node.subtreeCount;
    node.subtreeCount = node.left.subtreeCount + node.right.subtreeCount + 1;
    return rightChild;
  }
  
  private void toggleColors(RedBlackNode node) {
    checkNotNull(node, "node arg to toggleColors is null");
    checkNotNull(node.left, "node left arg to toggleColors is null");
    checkNotNull(node.right, "node right arg to toggleColors is null");
    checkArgument((!node.isRed() && node.left.isRed() && node.right.isRed()), 
        "1. node must have opposite color of its left and right node");
    checkArgument((node.isRed() && !node.left.isRed() && !node.right.isRed()), 
        "2. node must have opposite color of its left and right node");
    node.parentLinkColor = !node.parentLinkColor;
    node.left.parentLinkColor = !node.left.parentLinkColor;
    node.right.parentLinkColor = !node.right.parentLinkColor;
  }
}
