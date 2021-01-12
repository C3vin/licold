### 757.Set-Intersection-Size-At-Least-Two

对于这种涉及很多区间的题，第一个可以考虑的是，这些区间能否先排序，从而提供某种便利。

我们如果将这些区间按照后边界从小到大排序之后（相同后边界的情况下，显然只考虑区间跨度最短的），可以想见，这些区间其实互不影响。我们只要挨个处理每个区间，并对答案进行更新即可。也就是说，假设已经有了一个集合S满足前若干个interval的条件，此时遇到一个新的interval[a,b]，此时S应该如何更新呢？

一个最明显的特点是，我们待处理的这个interval[a,b]，一定在整体上会比S晚，具体的说就是interval的后边界b一定会大于S的后边界。那么发挥影响的其实就只是interval的前边界a了。

分类讨论a的位置查看对S的影响：
1. 如果[a,b]覆盖了S两个点，那么S就不用更新；
2. 如果[a,b]只覆盖了S一个点，那么这个点其实就一定是S的后边界，那么S需要再补一个点。这个点是什么呢?[a,b]的最后一个点，也就是b。这种做法是最“贪心”的，因为它最可能会与[a,b]之后的区间重合。
3. 如果[a,b]没有覆盖S，那么S就要加上什么呢，是[a,b]的最后两个点即可，同理也是用贪心的策略。

综上，我们其实只要每次关注集合S里的最靠右边的两个点即可，不断与下一个interval考察相对关系，更新S。


[Leetcode Link](https://leetcode.com/problems/set-intersection-size-at-least-two)