package test;

import java.util.Arrays;

import com.shiyang.Collection.BinTreeNode;
import com.shiyang.Collection.MyBinTree;

public class TestTree {
public static void main(String[] args) {
	char[] ch="abcdefg########".toCharArray();
	System.out.println(Arrays.toString(ch));
	int flag=0;
	BinTreeNode root=new BinTreeNode();
	for (char c : ch) {
		BinTreeNode node=new BinTreeNode(c);
		if(flag==0)  
			MyBinTree.insertLeft(root, node);
		else {
			MyBinTree.insertRight(root,node);
		}
		flag=flag^1;
			
	}
	MyBinTree rTree=new MyBinTree(root);
	rTree.preOrder(root);
}
}
