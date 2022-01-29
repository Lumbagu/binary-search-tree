package pl.lumbago.bst;

import java.util.ArrayList;

public class BinarySearchTree {
  private BinarySearchTreeNode treeRoot;


  public BinarySearchTree(int value) {
    treeRoot = new BinarySearchTreeNode(value);
  }

  public BinarySearchTree() {
    treeRoot = null;
  }


  public void insert(int value) {
    if (treeRoot == null) {
      // the main tree is empty, adding new node as tree root
      treeRoot = new BinarySearchTreeNode(value);
      return; // node added, can exit
    }

    // starting from the top of the tree, from tree root
    BinarySearchTreeNode subRoot = treeRoot;

    // iterating until a new node with target value can be added
    while (true) {
      if (value <= subRoot.getValue()) {
        // left node subtree
        if (subRoot.getLeftNode() == null) {
          // end of subtree
          subRoot.setLeftNode(new BinarySearchTreeNode(value));
          break; // node added, can exit
        }
        // traversing down the tree
        subRoot = subRoot.getLeftNode();

      } else {
        // right node subtree
        if (subRoot.getRightNode() == null) {
          // end of subtree
          subRoot.setRightNode(new BinarySearchTreeNode(value));
          break; // node added, can exit
        }
        // traversing down the tree
        subRoot = subRoot.getRightNode();
      }
    }
  }

  public boolean lookup(int value) {
    if (treeRoot == null) {
      // the main tree is empty
      return false;
    }

    // starting from the top of the tree
    BinarySearchTreeNode subRoot = treeRoot;

    // iterating until the value is found or an end of the tree is reached
    while (true) {
      if (value < subRoot.getValue()) {
        // left subtree
        if (subRoot.getLeftNode() == null) {
          // end of subtree, value not found
          return false;
        }
        // traversing down the tree
        subRoot = subRoot.getLeftNode();

      } else if (value > subRoot.getValue()) {
        // right subtree
        if (subRoot.getRightNode() == null) {
          // end of subtree, value not found
          return false;
        }
        // traversing down the tree
        subRoot = subRoot.getRightNode();

      } else {
        // value found (value == subRoot.getValue()), can exit
        return true;
      }
    }
  }

  public BinarySearchTreeNode getTreeRoot() {
    return treeRoot;
  }

  private int sizeHelper(BinarySearchTreeNode subTreeRoot, int size) {

    BinarySearchTreeNode leftNode = subTreeRoot.getLeftNode();
    BinarySearchTreeNode rightNode = subTreeRoot.getRightNode();

    if (leftNode != null) size++;
    if (rightNode != null) size++;

    if (leftNode != null) size = sizeHelper(leftNode, size);
    if (rightNode != null) size = sizeHelper(rightNode, size);

    return size;
  }

  public int size(BinarySearchTreeNode subTreeRoot) {
    if (subTreeRoot == null) {
      // subtree empty
      return 0;
    }

    // at least one node is present at this point - the root
    int initialSize = 1;

    return sizeHelper(subTreeRoot, initialSize);
  }

  public int size() {
    return size(treeRoot);
  }

  private int maxDepthHelper(BinarySearchTreeNode subTreeRoot, int depth) {
    boolean leftNodePresent = subTreeRoot.getLeftNode() != null;
    boolean rightNodePresent = subTreeRoot.getRightNode() != null;

    if (leftNodePresent || rightNodePresent) {
      // current root node has at least one child
      // so a new depth level is added
      depth++;

      // traversing down the tree if a node is present
      int leftDepth = leftNodePresent ? maxDepthHelper(subTreeRoot.getLeftNode(), 0) : 0;
      int rightDepth = rightNodePresent ? maxDepthHelper(subTreeRoot.getRightNode(), 0) : 0;
      depth += Math.max(leftDepth, rightDepth);
    }

    return depth;
  }

  public int maxDepth(BinarySearchTreeNode subTreeRoot) {
    if (subTreeRoot == null) {
      // subtree empty
      return 0;
    }

    // at least one node is present at this point - the root
    int initialDepth = 1;

    return maxDepthHelper(subTreeRoot, initialDepth);
  }

  public int maxDepth() {
    return maxDepth(treeRoot);
  }

  public void printTree() {
    // todo
  }
}

