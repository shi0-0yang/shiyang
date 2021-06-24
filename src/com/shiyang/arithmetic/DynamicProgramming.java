package com.shiyang.arithmetic;

public class DynamicProgramming {
    /**
     * 01背包问题
     * @param nums
     * @return
     */
    public int backpack01(int[] nums){
        return 0;
    }

    /**
     *
     * @param map
     * @param n
     * @param m
     * @return
     */
    public int getMin(int[][] map, int n, int m) {  
        // write code here  
       int[][] dp = new int[n][m];  
        for(int i=0;i<n;i++){  
            for(int j=0;j<=i;j++){  
             dp[i][0]+=map[j][0];      
            }  
        }  
        for(int i=0;i<m;i++){  
            for(int j=0;j<=i;j++){  
             dp[0][i]+=map[0][j];      
            }  
        }  
        for(int i=1;i<n;i++){  
            for(int j=1;j<m;j++){  
             dp[i][j] = Math.min(dp[i][j-1]+map[i][j],dp[i-1][j]+map[i][j]);     
            }  
        }  
        return dp[n-1][m-1];  
    }  
	/*
	 * 找零钱问题
	 */ 
	    public int countWays(int[] penny, int n, int aim) {  
	        // write code here  
	        if(n==0||penny==null||aim<0){  
	         return 0;     
	        }  
	        int[][] pd = new int[n][aim+1];  
	        for(int i=0;i<n;i++){  
	         pd[i][0] = 1;     
	        }  
	        for(int i=1;penny[0]*i<=aim;i++){  
	         pd[0][penny[0]*i] = 1;     
	        }  
	        for(int i=1;i<n;i++){  
	            for(int j=0;j<=aim;j++){  
	                if(j>=penny[i]){  
	                    pd[i][j] = pd[i-1][j]+pd[i][j-penny[i]];  
	                }else{  
	                    pd[i][j] = pd[i-1][j];  
	                }  
	            }  
	        }  
	        return pd[n-1][aim];  
	    }   
	/*
	 * 计算二项式系数
	 */
	public static int Binomial(int n, int k) {
		int[][] result = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					result[i][j] = 1;
				} else {
					result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
				}
			}
		}
		return result[n][k];
	}
	/*
	 * 机器负荷问题
	 */

}
