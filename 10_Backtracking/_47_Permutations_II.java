class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(nums);
        
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        
        return list;
    }

    private void backtrack( List<List<Integer>> list, 
                             List<Integer> tempList, 
                             int [] nums, 
                             boolean [] used)
    {    
        if(tempList.size() == nums.length){
            
            list.add(new ArrayList<>(tempList));
            
        } else{
            
            for(int i = 0; i < nums.length; i++){
                
                if( ( used[i] ) || ( i > 0 && nums[i] == nums[i-1] && !used[i - 1] ) ) continue;
                 
                tempList.add(nums[i]);  used[i] = true; 
                
                backtrack(list, tempList, nums, used);
                 
                tempList.remove(tempList.size() - 1);  used[i] = false; 
            }
        }
    }
}


/**

这个方法在backtracking的时候的过程是这样的：

假如input：“abc"

第一层                           a                     b                 c
                                 /      \               /      \            /      \          
第二 层                     b        c           a        c        a        b
                               |          |             |         |         |         |
第三层                      c        b            c        a        b        a 

每次把某个字母放到某一层后要把这个字母设为used，所以不会在以后的层中再用到这个字母。




假如input=“abb'c"     （第二个b加了上标便于区分）可以发现排序的要求是b和b'不能同时放在某一层，但是可以出现在不同层。



不能同时放在某一层：


第一层                          a                     b                  b'              c                       //b和b'同时放在第一层，不可以
                                 /      \               /      \            /      \                                   
第二层                      b        c   ...      a        c  ...   a      b
                               |          |             |         |         |       |
第三层                                            ... ...

不然会出现这种情况：
第一层                       a       b      b' 
第二层                      ...       b'     b

于是最后出现重复的排列。。。

- 解决办法就是遇到重复出现的字母时（例如在第一层遇到了b'），只有在前一个设置为used了的情况下才能用之后重复的字母。

- 前面相同的字母used了说明它们放在了之前的不同层，不在当前层，所以可以在这一层放前面层出现了的字母

- 如果前面重复的字母没有标为used，就会出现一样的字母出现在不同path的同一层，就会出现重复（例如bb'a和b'ba）
  

**/