### 45.Jump-Game-II

最直观的算法，遍历每一个位置i，根据这个位置可以更新所有由此下一步可以到达的位置dp[i+k]=dp[i]+1。但这种算法会超时，需要O(n*k)，k是平均能跳的步数。

更好的算法是：使用left和right来定界每一步所能达到的范围。则再下一步所能达到的范围，只要从nums[left]到nums[right]开始推算即可。不断依次推进，更新left和right，直至right抵达末尾。这期间走过了几步，就是最终答案。


[Leetcode Link](https://leetcode.com/problems/jump-game-ii)