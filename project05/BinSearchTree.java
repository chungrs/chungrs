 /************************************************************
 * Programming Project 5 - Binary Search Tree Implementation
 * ---------------------------------------------------------
 * This is a custom binary search tree that implements the
 * BinTreeInterface from the Bridges project. The main
 * method sends the data to the Bridges website for
 * visualization.
 * ---------------------------------------------------------
 * Roy Chung
 * 20200331
 * CMSC 256 Section 902
 ************************************************************/

package cmsc256.project05;

import bridges.base.BinTreeElement;
import bridges.connect.Bridges;

public class BinSearchTree<E extends Comparable<? super E>> implements BinTreeInterface<E> {
    private int size = 0;
    private BinTreeElement<E> root = null;

    @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }

    public boolean add(E element) {
        //declare reference nodes
        BinTreeElement<E> parent = null;
        BinTreeElement<E> current = root;

        //if the tree is empty, then set the root to the new node
        if (root == null) {
            root = new BinTreeElement<E>(element);
        } else { //otherwise, look for the appropriate position to add the node
            while(current != null){
                //if the new node is equal to an existing node, do not add
                if (element.compareTo(current.getValue()) == 0) {
                    return false;
                  //if the new node is less than the current node, go to the left child
                } else if(element.compareTo(current.getValue()) < 0) {
                    //current node becomes the new parent, and the left child becomes the new current node
                    parent = current;
                    current = current.getLeft();
                    //if the node is greater than the current node, go to the right child
                } else {
                    //current node becomes the new parent, and the left child becomes the new current node
                    parent = current;
                    current = current.getRight();
                }
            }
            //once the parent of the new node is found, the new node is added as either the left or right child depending on how it compares to the parent
            if (element.compareTo(parent.getValue()) < 0) {
                parent.setLeft(new BinTreeElement<E>(element));
            } else {
                parent.setRight(new BinTreeElement<E>(element));
            }
        }

        //increment the size of the BST and return true
        size++;
        return true;
    }

    public boolean remove(E element) {
        //nothing to remove if the tree is empty
        if (root == null) {
            return false;
        }

        if (root.getValue().compareTo(element) == 0) {
            //if the left child is null, make the right right child the root
            if (root.getLeft() == null) {
                root = root.getRight();
            //if the right child is null, then make the left right child the root
            } else if (root.getRight() == null) {
                root = root.getRight();
            } else { //if neither left nor right children are null, then set the left node to the root and add the right node to the left node
                BinTreeElement<E> formerRight = root.getRight();
                root = root.getLeft();
                //addToParent finds the most appropriate location on the tree to place a node
                addToParent(root, formerRight);
            }
            size--;
            return true;
        }
        //if the node to remove is not the root, then removeSubNode will find the appropriate node to delete
        return removeSubNode(root, element);
    }

    @Override
    public int size() {
        //return the size of the BST
        return size;
    }

    public boolean isEmpty() {
        //no root = no tree
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        //deletes the tree and resets the size to 0
        root = null;
        size = 0;
    }

    public boolean search(E target) {
        //null can't be compared to anything, so do not search
        if(target == null)
            return false;

        //current variable used for navigating the tree
        BinTreeElement<E> current = root;

        while(current != null) {
            //if the target is less than the current node, go to the left child
            if (target.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
              //if the target is greater than the current node, go to the right child
            } else if(target.compareTo(current.getValue()) > 0) {
                current = current.getRight();
            } else { //if the target is equal to the current node, then there is a math
                return true;
            }
        }
        //if no match is found, then return false
        return false;
    }

    public String inorder() {
        return inorder(root);
    }

    public String inorder(BinTreeElement<E> root) {
        String inorder = "";
        if (root == null) {
            return inorder;
        }

        //inorder means left child, followed by parent and right child, respectively
        inorder += inorder(root.getLeft());
        inorder += root.getValue() + "  ";
        inorder += inorder(root.getRight());

        return inorder;
    }

    public String postorder() {
        return postorder(root);
    }

    public String postorder(BinTreeElement<E> root) {
        String postorder = "";

        //base case
        if (root == null) {
            return postorder;
        }

        //Postorder means left child, followed by its right sibling, followed by their parent
        postorder += postorder(root.getLeft());
        postorder += postorder(root.getRight());
        postorder += root.getValue() + "  ";

        return postorder;
    }

    public String preorder() {
        return preorder(root);
    }

    public String preorder(BinTreeElement<E> root) {
        String preorder = "";
        //base case
        if (root == null) {
            return preorder;
        }

        //Preorder means root first, followed by the left and right children, respectively
        preorder += root.getValue() + "  ";
        preorder += preorder(root.getLeft());
        preorder += preorder(root.getRight());

        return preorder;
    }

    public int height() {
       return height(root);
    }

    public int height(BinTreeElement<E> root) {
        //a BST with only one node has a height of 0. Zero nodes means height of -1
        if (root == null)
            return -1;

        //find the maximum height via recursion
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public boolean isFullBST() {
        return isFullBST(root);
    }

    public boolean isFullBST(BinTreeElement<E> root) {
        if (root == null)
            return false;
        //if root has no children, return true
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
         //if root has two children, recursively test both
        } else if (root.getLeft() != null && root.getRight() != null) {
            return isFullBST(root.getLeft()) && isFullBST(root.getRight());
        } else { //if any node in the BST has only one child, then the BST is not full
            return false;
        }
    }

    public int getNumberOfLeaves() {
        return getNumberOfLeaves(root);
    }

    public int getNumberOfLeaves(BinTreeElement<E> root) {
        //base case
        if (root == null) {
            return 0;
        }
        //if there are no children, then it is a leaf
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else { //run method recursively so it tests each node
            return getNumberOfLeaves(root.getLeft()) + getNumberOfLeaves(root.getRight());
        }
    }

    public int getNumberOfNonLeaves() {
        //every node that is not a leaf must be a non-leaf.
        return size - getNumberOfLeaves();
    }

    //Recursive method used to remove a non-root node and also search through branches of a tree to remove appropriate nodes
    private boolean removeSubNode(BinTreeElement<E> parent, E removeValue) {
        //variable used to compare the parent node's value with the value to be removed
        int compareParent = parent.getValue().compareTo(removeValue);

        //determine whether to remove left or right node
        BinTreeElement<E> subTree = null;
        if (compareParent > 0) {
            subTree = parent.getLeft();
        } else {
            subTree = parent.getRight();
        }

        //if that branch is null, then the value doesn't exist in the tree
        if (subTree == null) {
            return false;
        }

        //if the value is equal to the value in the current branch, then the selected node can be deleted
        if (subTree.getValue().compareTo(removeValue) == 0) {
            BinTreeElement<E> replacement;
            if (subTree.getLeft() == null) {
                replacement = subTree.getRight();
            } else if (subTree.getRight() == null) {
                replacement = subTree.getLeft();
            } else {
                BinTreeElement<E> formerRight = subTree.getRight();
                replacement = subTree.getLeft();
                addToParent(replacement, formerRight);
            }

            //add node to parent
            if(compareParent > 0) {
                parent.setLeft(replacement);
            } else {
                parent.setRight(replacement);
            }

            size--;
            return true;
        }

        //invoke method recursively to check other branches in the tree
        return removeSubNode(subTree, removeValue);
    }

    private boolean addToParent (BinTreeElement<E> parentNode, BinTreeElement<E> addNode) {
        //compare is used to compare the parent and child nodes' values.
        int compare = parentNode.getValue().compareTo(addNode.getValue());
        boolean wasAdded = false;

        //If the parent is greater than the child, then child will be added to the left node if left node is empty.
        if(compare > 0) {
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(addNode);
                wasAdded = true;
            } else { //Method is invoked recursively if the left node is not empty
                wasAdded = addToParent(parentNode.getLeft(), addNode);
            }
        //If the parent is less than the child, then child will be added to the right if the right node is empty.
        } else if(compare < 0) {
            if (parentNode.getRight() == null) {
                parentNode.setRight(addNode);
                wasAdded = true;
            } else { //Method is recursively invoked if the right node is not empty
                wasAdded = addToParent(parentNode.getRight(), addNode);
            }
        }

        return wasAdded;
    }

    public static void main(String[] args) {
        //Create Bridges Object
        Bridges bridges = new Bridges(2, "chungrs", "1313147220589");
        bridges.setTitle("Binary Search Tree Implementation");

        //Instantiate BinSearchTree object and add elements
        BinSearchTree<String> names = new BinSearchTree<>();
        names.add("Frodo");
        names.add("Dori");
        names.add("Bilbo");
        names.add("Kili");
        names.add("Gandalf");
        names.add("Fili");
        names.add("Thorin");
        names.add("Nori");

        //Send top node to bridges for visualization (sending a node will send all of the subsequent nodes)
        bridges.setDataStructure(names.root);
        try {
            bridges.visualize();
        } catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}