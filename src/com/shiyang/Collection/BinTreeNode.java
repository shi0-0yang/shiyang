package com.shiyang.Collection;

public class BinTreeNode {
char data;
BinTreeNode lchild,rchild;

public BinTreeNode(char data) {
	super();
	this.data = data;
	this.lchild = null;
	this.rchild = null;
}
public BinTreeNode() {
	// TODO Auto-generated constructor stub
}
public char getData() {
	return data;
}
public void setData(char data) {
	this.data = data;
}
public BinTreeNode getLchild() {
	return lchild;
}
public void setLchild(BinTreeNode lchild) {
	this.lchild = lchild;
}
public BinTreeNode getRchild() {
	return rchild;
}
public void setRchild(BinTreeNode rchild) {
	this.rchild = rchild;
}

}
