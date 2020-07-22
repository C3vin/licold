### 395.Longest-Substring-with-At-Least-K-Repeating-Characters

此题初看很类似于双指针的题。但细细分析，如果想贪心地找到最长的符合条件的序列，前指针必须一次性遍历到最后才行。这样就不再是一个滑动窗口了（因为一端不得不固定）。因此此题不能用双指针做。

再想一下，如果不得不一遍把整个序列遍历完，那么我们就得到了所有字符和它出现的频次。对于那些出现次数少于k的字符，是“害群之马”，它们放在任何一个子序列中都会违反题意的。所以一个直观的想法是，将那些“害群之马”作为splitor，将原序列分割成若干子序列，然后递归调用函数本身，找到最长的有效子序列。递归的边界是，如果整个序列所有的字符频次都大于等于k，就可以返回序列的长度。


[Leetcode Link](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters)