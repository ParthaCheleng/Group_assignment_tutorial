package com.gl.groupAssignment.questionTwo;
import java.util.*;
import java.io.*;

class Node{
	int value;
	Node left, right;
	
	Node(int item){
		value=item;
		left=right=null;
	}
}

public class SkewedTree {
	public static Node node;
	static Node prevNode=null;
	static Node headNode=null;
	
	// function to convert the binary search tree into a skewed tree in either increasing or decreasing order
	public static void BinaryTreeToSkewed(Node root, int order) {
		if(root==null) {
			return;
		}
		
		// checking order for traversal, if increasing or decreasing
		if(order>0) {
			BinaryTreeToSkewed(root.right, order);
		}else {
			BinaryTreeToSkewed(root.left, order);
		}
		
		Node rightNode=root.right;
		Node leftNode=root.left;
		
		// condition to check if root node is not defined
		if(headNode==null) {
			headNode=root;
			root.left=null;
			prevNode=root;
		}else {
			prevNode.right=root;
			root.left=null;
			prevNode=root;
		}
		
		// recursing on the subtree on the basis of the order
		if(order>0) {
			BinaryTreeToSkewed(leftNode, order);
		}else {
			BinaryTreeToSkewed(rightNode, order);
		}
	}


	// function to print the tree 
public static void traverseRightSkewed(Node root) {
	if(root==null) {
		return;
	}
	
	System.out.print(root.value+" ");
	traverseRightSkewed(root.right);
}

public static void main(String[] args) {
 	SkewedTree tree = new SkewedTree();
 	tree.node = new Node(50);
    tree.node.left = new Node(30);
    tree.node.right = new Node(60);
    tree.node.left.left = new Node(10);
    tree.node.right.left= new Node(55);

 	// order to print the tree in asc or desc
 	
 	BinaryTreeToSkewed(node, 0);
 	traverseRightSkewed(headNode);
}
}