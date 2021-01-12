### 115.Distinct-Subsequences

刷过一年的题之后，再做这道题就会很容易地看出这题属于two string convergence的套路。类似标签的题号有010,097,072,712,727.

令dp[i][j]表示```s[1:i]```中有多少个不同的子序列等于```t[1:j]```。

依照套路，我们首先分析如果s[i]==t[j]的情况。显然，这两个字符相等，我们就将注意力前移，集中在s[1:i-1]和t[1:j-1]上。dp[i-1][j-1]表示s[1:i-1]中有多少个不同的子序列等于t[1:j-1]，两边分别加上s[i]和t[j]之后，自然就有相同多数目的s[1:i]的不同子序列等于t[1:j]。所以算上这部分，```dp[i][j]+=dp[i-1][j-1]```。

如果s[i]!=t[j]的话，说明s[i]指望不上，我们就将注意力放在```s[1:i-1]```上，看里面有多少个不同子序列等于```t[1:j]```，直接拿过来用就行，反正加上了s[i]也不管事。所以这种情况下，```dp[i][j]+=dp[i-1][j]```.

注意：当s[i]==t[j]的时候，上述的第二种情况也是要累加进去的。原因也是显然的。

递推关系有了，那么边界条件呢？无非就是```dp[0][j]```和```dp[i][0]```的情况。显然，前者仍算是一种子序列，所以赋值为1，后者赋值为0.




[Leetcode Link](https://leetcode.com/problems/distinct-subsequences)