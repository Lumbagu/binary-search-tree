package pl.lumbago;

import pl.lumbago.bst.BinarySearchTree;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(5);
    bst.insert(3);
    bst.insert(1);
    bst.insert(4);
    bst.insert(9);
    bst.insert(6);
    bst.insert(17);
    bst.insert(8);
    bst.insert(2);
    System.out.println("size: " + bst.size());
    System.out.println("depth: " + bst.maxDepth());
  }
}


