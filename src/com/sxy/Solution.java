package com.sxy;

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.bcel.internal.generic.IFNULL;

import java.util.*;

public class Solution {
    private int number = 0;
    private List<List<Integer>> lists = new ArrayList<>();


    public static void main(String[] args) {
        //二维数组直接赋值
        int[][] rooms = new int[][]{{2, 2}, {1, 2}, {3, 2}};
        int[][] queries = new int[][]{{3, 1}, {3, 3}, {5, 2}};


        String s = "aab", p = "c*a*b";
        System.out.println(isMatch(s, p));


//
//        int[] result = new int[3];
//        result = closestRoom(rooms, queries);
//        System.out.println(Arrays.toString(result));
    }

    /**
     * 盈利计划
     * 动态规划：dp[i]表示前i种工作能完成盈利计划的数量。
     *
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */


    /**
     * 最后一块石头的重量
     * 动态规划；
     * 可优化为一维dp
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }

    /**
     * 分割等和子集
     * 动态规划：从
     * @param nums
     * @return
     */;
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n<2){
            return false;
        }
        int sum=0,maxNum=0;
        for (int num: nums) {
            sum+=num;
            maxNum=Math.max(num,maxNum);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n-1][target];

    }

    /**
     * 目标和
     * 动态规划：1.-号元素之和为neg,neg=(sum-target)/2。2.dp[i][j]表示数组nums的前i个数中选取元素，使得这些元素之和等于j的方案数，最终答案为dp[n][neg]
     * 3.状态转移方程：若j<num,dp[i][j]=dp[i-1][j];若j≥num,dp[i][j]=dp[i-1][j]+dp[i-1][j-num];空间复杂度O(n*neg)
     * 优化后的动态规划：由于dp的每一行的计算只和上一行有关，因此可以使用滚动数组方式，去掉dp的第一个维度，将空间复杂度优化到O(neg);
     *  内层循环使用倒序遍历的方式，来确保转移的是dp[i-1][]的元素值。时间复杂度O(n*(sum-target))
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg+ 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }

    /**
     * 能吃到第i种糖果的情况：1最少情况：每天吃一颗能吃到；2最多情况：每天吃最多能吃到
     * 吃最少糖：queries[i][1]+1  ；吃最多糖：queries[i][1]*queries[i][2]
     * * 要吃的糖：sum=candiesCount[0]+...+candiesCount[queries[i][0]-1]
     * 取值范围：吃最少糖能吃到sum+1≤queries[i][1]，吃最多糖sum<queries[i][1]*queries[i][2]
     *
     * @param candiesCount
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        //前缀和
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];  //最爱吃的糖类型
            long x1 = queries[i][1] + 1;  //最少吃糖
            long y1 = (queries[i][1] + 1) * queries[i][2];  //吃最多糖
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1; //最小
            long y2 = sum[favoriteType];   //最多拥有的糖
            answer[i] = !(x1 > y2 || y1 < x2);
        }
        return answer;
    }

    /**
     * 汉明距离总和
     * 不能直接减法算二进制1的个数，考虑情况：1000,0100
     * 思路：逐位统计：数组nums中某个数val，其二进制第i位为1，只需统计nums中有多少元素第i位为0,即计算出val与其他元素在第i位上的汉明距离之和
     * 做法：若长度为n的数组nums的所有元素二进制的第i共有c个1，n-c个0，则这些元素在二进制第i位上的汉明距离之和为c*(n-c)
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                str1 += s1.charAt(i);
                str2 = s2.charAt(i) + str2;
                if (str2.length() > 2) {
                    return false;
                }
            }
        }
        return (str2.length() == 2) && (str1.equals(str2));
    }

    /**
     *使所有区间的异或结果为0
     * @param nums
     * @param k
     * @return
     */
//    // x 的范围为 [0, 2^10)
//    static final int MAXX = 1 << 10;
//    // 极大值，为了防止整数溢出选择 INT_MAX / 2
//    static final int INFTY = Integer.MAX_VALUE / 2;
//
//    public int minChanges(int[] nums, int k) {
//        int n = nums.length;
//        int[] f = new int[MAXX];
//        Arrays.fill(f, INFTY);
//        // 边界条件 f(-1,0)=0
//        f[0] = 0;
//
//        for (int i = 0; i < k; ++i) {
//            // 第 i 个组的哈希映射
//            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
//            int size = 0;
//            for (int j = i; j < n; j += k) {
//                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
//                ++size;
//            }
//
//            // 求出 t2
//            int t2min = Arrays.stream(f).min().getAsInt();
//
//            int[] g = new int[MAXX];
//            Arrays.fill(g, t2min);
//            for (int mask = 0; mask < MAXX; ++mask) {
//                // t1 则需要枚举 x 才能求出
//                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
//                    int x = entry.getKey(), countx = entry.getValue();
//                    g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
//                }
//            }
//
//            // 别忘了加上 size
//            for (int j = 0; j < MAXX; ++j) {
//                g[j] += size;
//            }
//            f = g;
//        }
//
//        return f[0];
//    }

    /**
     * 前k个高频单词
     * 使用hashmap存储单词-频次；利用集合类的sort()方法排序，通过比较器设置排序规则
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return cnt.get(01) == cnt.get(o2) ? o1.compareTo(o2) : cnt.get(01) - cnt.get(o2);
            }
        });
        return rec.subList(0, k);
    }

    /**
     * 找出第k大的异或坐标值
     * pre(i,j)=pre(i)
     *
     * @param matrix
     * @param k
     * @return
     */
    //坐标值temp(a,b)=(m[0,0]^m[0,1]^...^m[0,b])^。。。(m[a,0]^m[a,1]^...^m[a,b])
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j - 1] ^ pre[i][j - 1] ^ pre[i - 1][j] ^ matrix[i][j];
                results.add(pre[i][j]);
            }
        }
        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return results.get(k - 1);
    }

    /**
     * 正则表达式匹配:动态规划
     * 辅助数组dp[i][j]表示s的前i个字符与p的前j个字符是否能够匹配
     * 每次从字符串p中取出一个字符或者是字符+‘*’组合，并在s中匹配.
     * 转换公式：dp[i][j]=dp[i-1][j-1] ,if(s[i]=p[j]) ;false,if(s[i]≠p[j])
     * dp[i][j]=dp ,if()
     * 空串匹配：下界：dp[0][0]=true
     * 如果p[j]='.',一定能够匹配s中的任意一个字符
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();  //匹配字符串长度
        int n = p.length();  //

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * 思路：动态规划
     * 辅助数组dp[i][j]表示i次操作后，指针位于下标j的方案数。0≤i≤steps，0≤j≤min(arrlen-1,steps)
     * 操作0次后位置为0的方案数为1,即:下界dp[0][0]=1;当操作0次位置在j的方案数为0;dp[0][j]=0;j>0
     * 每步操作可为左移，右移，原地不动；则dp[i][j]可由上一步转换得到，
     * 转换公式：dp[i][j]=dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1]  注意指针越界：j-1≥0,j+1≤min(arrlen-1,steps)
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int limit = Math.min(steps, arrLen - 1);
        int[] dp = new int[limit + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dpNext = new int[limit + 1];
            for (int j = 0; j <= limit; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MODULO;
                }
                if (j + 1 <= limit) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MODULO;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }

    public static boolean canMake(int[] bloomDay, int days, int m, int k) {
        int buoquets = 0;
        int flowers = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n && buoquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    buoquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return buoquets >= m;
    }

    public static int[] closestRoom(int[][] rooms, int[][] queries) {
        int length1 = rooms.length;
        int length2 = queries.length;
        // 将房间按照房间大小升序排序
        rooms = mergeSort(rooms);
        // 待返回的答案数据组
        int[] result = new int[length2];
        // 记录下标位置
        int index;
        // 标志目前最小的差值（id与preferredj绝对值）
        int flag;
        // 临时变量，用于存储计算结果，避免反复计算，消耗性能
        int temp;
        for (int i = 0; i < length2; i++) {
            // 通过二分法找出符合要求的房间的起始下标（房间的size不小于minSize，即大于等于）
            index = findIndex(rooms, queries[i][1]);
            // 不存在符合大小要求的房间，则答案为-1
            if (index == -1) {
                result[i] = -1;
                // 存在至少一个符合大小要求的房间
            } else {
                flag = Math.abs(queries[i][0] - rooms[index][0]);
                result[i] = rooms[index][0];
                index++;
                // 因为此时房间数组是升序的，即遍历找出最符合题目要求的答案即可
                while (index < length1) {
                    temp = Math.abs(queries[i][0] - rooms[index][0]);
                    // 找到更小差值，或者差值一样，但是房间号更小
                    if (flag > temp || (flag == temp && result[i] > rooms[index][0])) {
                        result[i] = rooms[index][0];
                        flag = temp;
                    }
                    index++;
                }
            }
        }
        return result;
    }

    /**
     * 归并排序
     *
     * @param nums 待排序的数据组
     * @return 排序后的数据组
     */
    public static int[][] mergeSort(int[][] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[][] left = Arrays.copyOfRange(nums, 0, mid);
        int[][] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并数据组
     *
     * @param left  左数据组
     * @param right 右数据组
     * @return 归并后的数据组
     */
    public static int[][] merge(int[][] left, int[][] right) {
        int[][] result = new int[left.length + right.length][2];
        int index = 0;
        int i = 0;
        int j = 0;
        for (; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j];
                j++;
            } else if (j >= right.length) {
                result[index] = left[i];
                i++;
                //    根据房间大小排序
            } else if (left[i][1] > right[j][1]) {
                result[index] = right[j];
                j++;
            } else {
                result[index] = left[i];
                i++;
            }
        }
        return result;
    }

    /**
     * 二分查找不小于某数（即大于等于）的下标位置
     *
     * @param rooms   待查找数据组
     * @param minSize 某数
     * @return 下标位置
     */
    public static int findIndex(int[][] rooms, int minSize) {
        int left = 0;
        int right = rooms.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (rooms[mid][1] < minSize) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= rooms.length) {
            return -1;
        } else {
            if (rooms[left][1] >= minSize) {
                return left;
            } else {
                return left + 1;
            }
        }
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static String replaceDigits(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) { //注意越界
            int flag = 2 * i + 1;   //奇数下标
            str[flag] = (char) (str[flag - 1] + (str[flag] - '0'));  //转换为字符
        }
        return new String(str);
    }

    /**
     * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
     * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * 思路：对于m行n列的矩阵matrix，转置后matrix T为n行m列；一一赋值给转置矩阵
     *
     * @param matrix
     * @return
     */
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix11 = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix11[j][i] = matrix[i][j];
            }
        }
        return matrix11;
    }

    /**
     * 寻找两个正序数组中位数
     * arr[1,2,3,4]=(2+3)/2; arr[1,2,3]=3
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        //合并数组
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            temp[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            temp[k++] = nums2[j++];
        }
        //数组长度的奇偶
        int mid = temp.length >> 1;
        if ((temp.length & 1) == 1) {
            return (double) temp[mid];
        } else {
            return (double) (temp[mid - 1] + temp[mid]) / 2;

        }
    }

    /**
     * 制作m束花最少需要多久
     * 需求：花开后，从数组中删除，添加到花开表；从花开表查找满足k朵的制作花束，再减掉
     *
     * @param bloomDay bloomDay[i]第i束花开日期
     * @param m        需m束花
     * @param k        一束花需要k朵花
     * @return 返回最早等待日期。若无法完成则返回-1
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int n = bloomDay.length;
        int high = 0;       //最大花开日期
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        do {
            int mid = low + ((high - low) >> 1);
            if (canMake(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        } while (low < high);
        return low;
    }

    /**
     * result是前n个正整数的排列
     * 先求perm[0],再一步步求其他perm
     *
     * @param encoded
     * @return
     */
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] result = new int[n];
        int totle = 0;  //前n项的异或
        for (int i = 1; i <= n; i++) {
            totle ^= i;
        }
        int odd = 0;   //加密奇数位
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        result[0] = totle ^ odd;
        for (int i = 0; i < n - 1; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }

    /**
     * 不存在的情况：
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++) {
            index.put(arr[i], i);
        }
        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;
        for (int k = 0; k < len; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    int cand = longest.getOrDefault(i * len + j, 2) + 1;
                    longest.put(j * len + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        }
        return ans >= 3 ? ans : -1;
    }

    /**
     * 完成所有工作的最小时间
     * 思路：二分+回溯+剪枝
     * 优化：1优先安排工作时间长的使得搜索变得简单；2.缩小二分查找的上下界：下界不低于jobs中最大工作量，上界不高于所有工作时间和
     *
     * @param jobs 工作需花时间
     * @param k    工人数
     * @return 最小的最大工作时间
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        //jobs数组排升序排序
        Arrays.sort(jobs);
        int low = 0, high = jobs.length - 1;
        while (low < high) {
            jobs[low] = jobs[low] ^ jobs[high];
            jobs[high] = jobs[low] ^ jobs[high];
            jobs[low] = jobs[low] ^ jobs[high];
            low++;
            high--;
        }
        int l = jobs[0], r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        //如果工作已经安排完了
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }
        return false;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        dfs(k, 1, n, list);
        return lists;
    }

    public void dfs(int k, int index, int target, List<Integer> list) {
        if (target == 0 && k == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < index || k <= 0) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            dfs(k - 1, i + 1, target - i, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 比特位计算
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * 原理：a[2n]=a[n],a[2n+1]=a[2n]+1;
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] array = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) { //判断奇偶
                array[i] = array[i - 1] + 1;
            } else {
                array[i] = array[i >> 1];
            }
        }
        return array;
    }

    /*
     * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
     * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
     * 思路：pd[n][m]表示字符串前n位最长
     */
    public int getLongestPalindrome(String A, int n) {
        // write code here
        char[] ch = A.toCharArray();
        int[][] result = new int[n][n];
        return n;

    }

    public boolean isPalindrome(String str) {
        Stack<Character> s1 = new Stack<>();
        int len = str.length();
        int flag = 0;
        while (flag < len) {
            s1.push((char) str.indexOf(flag));
        }
        return str.equals(s1.toString());
    }

    public ListNode ReverseList(ListNode head) {
        Stack<Integer> stack1 = new Stack<>();
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            stack1.push(tmp.val);
            tmp = tmp.next;
            count++;
        }
        tmp = null;
        while (count >= 0) {
            tmp.val = stack1.pop();
            tmp = tmp.next;
            count--;
        }
        return tmp;
    }

    /*
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        return result;
    }

    /*
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串， 判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法 思路：利用棧的後進先出特性匹配括號
     */
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();

        for (char alp : s.toCharArray()) {
            if (alp == '(') {
                stack.push(')');
            } else if (alp == '[') {
                stack.push(']');
            } else if (alp == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != alp) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /*
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。 请写程序找出这两个只出现一次的数字。
     */
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {

    }

    /*
     * 实现函数 int sqrt(int x). 计算并返回x的平方根 思路：取1-x中间值，从两侧逼近x平方根
     */
    public int sqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x / mid > mid) {
                l = mid + 1;
            } else if (x / mid < mid) {
                r = mid - 1;
            } else if (x / mid == mid) {
                return mid;
            }
        }
        return r;
    }

    /*
     * N皇后问题是指在N*N的棋盘上要摆N个皇后， 要求任何两个皇后不同行，不同列也不再同一条斜线上，求给一个整数n，返回n皇后的摆法。
     */
    public int Nqueen(int n) {
        // write code here
        solve(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return number;
    }

    public void solve(int n, int len, boolean[] flag1, boolean[] flag2, boolean[] flag3) {
        if (n == len) {
            number++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!flag1[i] && !flag2[i + len] && !flag3[n - i + len - 1]) {
                flag1[i] = flag2[i + len] = flag3[n - i + len - 1] = true;
                solve(n, len + 1, flag1, flag2, flag3);
                flag1[i] = flag2[i + len] = flag3[n - i + len - 1] = false;
            }
        }
    }

    /*
     * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
     * 请你设计一个算法来计算可以获得的最大收益。 思路：快选，比较差值最大的两个
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int profit = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

    /*
     * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？ 找出数组S中所有满足条件的三元组。
     * 解题思路：result记录返回数组，设置标志位j,k记录左标、右标; 数组从左到右，
     * 循环遍历整个数组，取循环变量i右侧数组，从两侧向中间逼近，寻找三数和为0的值，值相同略过
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    if (num[i] + num[j] + num[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        result.add(list);
                        j++;
                        k--;
                        while (j < k && num[j] == num[j - 1]) {
                            j++;
                        }
                        while (j < k && num[k] == num[k + 1]) {
                            k--;
                        }
                    } else if (num[i] + num[j] + num[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    /*
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */
    public boolean Find(int target, int[][] array) {
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length - 1) {
            if (array[i][j] > target)
                i--;
            else if (array[i][j] < target)
                j++;
            else
                return true;
        }
        return false;
    }

    /*
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。 例如，当字符串为We Are
     * Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    // 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    public TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, java.util.HashMap<Integer, Integer> map) {

        if (pi > pj)
            return null;
        TreeNode head = new TreeNode(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
        head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
        return head;
    }

    /*
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2)
                    return array[0];
            }
        }
        return 0;
    }

    /*
     * 大家都知道斐波那契数列，现在要求输入一个整数n， 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     */
    public int Fibonacci(int n) {
        int a = 1, b = 1, c = 0;
        if (n < 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }

    /*
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    public class Solution1 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int first = stack2.pop();
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return first;
        }
    }

}
