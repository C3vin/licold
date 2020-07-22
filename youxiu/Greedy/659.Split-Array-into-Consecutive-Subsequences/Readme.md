### 659.Split-Array-into-Consecutive-Subsequences

用贪心法模拟最优策略。

设置一个数组的集合arrays，存放所有符合要求的序列。遍历nums的元素，把nums[i]接在当前序列集合里可以接上的最短的那个序列；如果没有可以接上的，就以自己为首元素开一个新序列。遍历结束后，看最后是否有序列的长度小于3。

如果高效地找到最短的序列呢？其实只要在序列集里从后往前找就可以了，因为每次新开辟的序列总是放在最后的。


[Leetcode Link](https://leetcode.com/problems/split-array-into-consecutive-subsequences)