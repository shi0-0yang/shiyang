package com.shiyang.arithmetic;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class MyGreedy {
	/*
	 * 0-1背包问题：
	 * 有一容积有限的背包（容积为V）现在有n个物品，每个物品都有自己的价值和体积；如何知道一个较优的策略，使得能够放进背包里价值之和最大的的物品？
	 * 贪心规律：
	 * 优先存放价值密度大的
	 */
	public static Pair<Integer,Integer>[] backpack(int[]value,int[]volume) {
		int[] va=value;
		int[] vo=volume;
		ArrayList<Pair<Integer, Integer>> list=new ArrayList<>();
		for (int i = 0; i < value.length; i++) {
			int dp=va[i]/vo[i];
			Pair<Integer, Integer> temp=new Pair<Integer, Integer>(i, dp);
			list.add(temp);
		}
		return null;
		
	}
	/*
	 * 区间调度问题：
	 * 有n项工作，每项工作分别在Si开始，Ti结束。例如S={1,2,4,6,8}，T={3,5,7,8,10}。对每项工作，你都可以选择与否，若选择参加，则必须至始至终参加全程参与，且参与工作的时间段不能有重叠。
	 * 贪心规律：在可选工作中，每次都选取结束时间最早的
	 */
	public static int  intervalDIspatch() {
		int[]S= {1,2,4,6,8};
		int[]T= {3,5,7,8,10};
		int flag=0;
		int temp=0;
		ArrayList<Pair<Integer, Integer>> list=new ArrayList<>();
		for (int i = 0; i < T.length-1; i++) {  //排序，开始时间早的放前面
			temp=S[i];
			flag=i;
			for (int j = i; j < T.length; j++) {
				if(temp>S[j]) {
					flag=j;temp=S[j];
				}
				int t=S[i];
				S[i]=temp;
				S[flag]=t;
				t=T[i];
				T[i]=T[flag];
				T[flag]=t;
			}
		}
		for (int i = 0; i < 5; i++) {   //添加到数组中
			Pair<Integer, Integer> pair=new Pair<Integer, Integer>(S[i], T[i]);
			list.add(pair);
		}
		flag=0;
		while(S[flag]<=S[4]) {
			temp=T[flag];
			for(;flag<5;flag++) {
				list.get(flag).getValue();
			}
		}
		return 0;
	}
	/*
	 * 分糖果：已知一些孩子和一些糖果，每个孩子有需求因子g，每个糖果有大小s，当某个糖果的大小s>=某个孩子的需求因子g时，代表该糖果可以满足该孩子，求使用这些糖果， 最多能满足多少孩子（注意，每个孩子最多只能用1个糖果满足）
	 * 贪心规律：
	 * 某个糖果如果不能满足某个孩子，则该糖果也一定不能满足需求因子更大的孩子
	 * 某个孩子可以用更小的糖果满足，则没必要用更大糖果满足，因为可以保留更大的糖果满足需求因子更大的孩子
	 * 孩子的需求因子更小则其更容易被满足，故优先从需求因子小的孩子尝试，可以得到正确的结果(因为我们追求更多的孩子被满足，所以用一个糖果满足需求因子较小或较大的孩子都是一样的)。
	 * 算法设计：
	 * 对需求因子数组g和糖果大小数组s进行从小到大的排序
	 * 按照从小到大的顺序使用各糖果尝试是否可满足某个孩子，每个糖果只尝试1次，只有尝试成功时，换下一个孩子尝试，直到发现没更多的孩子或者没有更多的糖果，循环结束。
	 */
	public int divideCandy(int[] child,int[] candy) {
		Arrays.sort(child);
		Arrays.sort(candy);
		int result=0;
		for (int i = 0; i < candy.length; i++) {
			for (int j = 0; j < child.length; j++) {
				 if(candy[i]>=child[j]) {
					 i++;
					 result++;
					 break;
				 }
			}
		}
		return result;
	}
	/*
	 * 货币选择问题：分别有1,5,10,50,100元，分别有5,2,2,3,5张纸币。问若要支付k元，则至少需要多少张纸币？
	 * 贪心规律：
	 * 优先选面额大的
	 */
	public static int  currencySelect(int money) {
		int num=0;
		int[] Money= {5,2,2,3,5};
		int [] Value= {1,5,10,50,100};
		for(int i=4;i>0;i--) {
			int c=Math.min(money/Value[i], Money[i]);
			money=money-Value[i]*c;
			num+=c;
		}
		return num;
		
	}
}
