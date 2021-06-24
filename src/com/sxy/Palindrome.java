package com.sxy;

import java.util.Scanner;

//					回文数
public class Palindrome {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int x=scanner.nextInt();
	if(isPalindrome(x)) {
		System.out.println("YES!");
	}else {
		System.out.println("NO!");
	}
	scanner.close();
}
static boolean isPalindrome(int num) {
	int t=0;
	int x=num;
	while(x>0) {
		t=t*10+x%10;
		x=x/10;
	}
	if(t==num)  return true;
	return false;
}
}
