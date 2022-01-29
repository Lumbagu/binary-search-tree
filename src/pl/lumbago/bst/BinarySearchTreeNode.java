package pl.lumbago.bst;

public class BinarySearchTreeNode {
  private  BinarySearchTreeNode leftNode;
  private  BinarySearchTreeNode rightNode;
  private final int value;


  public BinarySearchTreeNode(int value) {
    leftNode = null;
    rightNode = null;
    this.value = value;
  }


  public void setLeftNode(BinarySearchTreeNode leftNode) {
    this.leftNode = leftNode;
  }

  public void setRightNode(BinarySearchTreeNode rightNode) {
    this.rightNode = rightNode;
  }

  public BinarySearchTreeNode getLeftNode() {
    return leftNode;
  }

  public BinarySearchTreeNode getRightNode() {
    return rightNode;
  }

  public int getValue() {
    return value;
  }
}
