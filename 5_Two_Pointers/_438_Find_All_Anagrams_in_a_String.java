class Solution {
    
       public List<Integer> findAnagrams(String s, String p) {
           
		List<Integer> result = new ArrayList<>();
           
		int len1 = s.length();
        int len2 = p.length();
           
		if (len2 > len1) return result;
		
		int[] anagram = new int[26];
           
		for (int i = 0; i < len2; ++i) 
		{
			anagram[p.charAt(i)-'a']++; // 主要操作p
			anagram[s.charAt(i)-'a']--; // 顺便操作s
		}
           
		if(allZero(anagram)) result.add(0); // 如果是开门红
		 
           
		for (int i = len2 ; i < len1; ++i) 
		{
			anagram[s.charAt(i) - 'a']--;           //新增就减一
			anagram[s.charAt(i - (len2 )) - 'a']++; //除去以前的字母
            
			if(allZero(anagram)) result.add(i-len2 + 1);
			 
		}
	 
		return result;
	}
    
    public boolean allZero(int[] freq)
	{
		for(int i=0;i<26;i++)
		{
			if(freq[i]!=0)
				return false;
		}
		return true;
	}
}