/** Backtracking */
    public class Solution {

            List<List<String>> resultLst;
            ArrayList<String> currLst;

            public List<List<String>> partition(String s) {

                resultLst = new ArrayList<List<String>>();

                currLst = new ArrayList<String>();

                backTrack(s,0);

                return resultLst;
            }

            /** backTrack */
            public void backTrack(String s, int l){

                /** 检查是否 可以加入 总结果 */
                if(currLst.size()>0 && l >= s.length() ){

                    List<String> r = (ArrayList<String>) currLst.clone();

                    resultLst.add(r);
                }

                /** 1 遍历 */
                for(int i=l; i<s.length(); i++){

                    /** ~1 如果是回文 */
                    if(isPalindrome(s /** String */,l /** left */ ,i /** right */)){

                            /** ~ 1.1 如果是第一次循环，i=l --> 直接把这个字母加进来 */
                            if(l==i){
                                currLst.add(Character.toString(s.charAt(i)));
                            }

                            /** ~1.2 否则就把 "本次的subString" 放进去  */
                            else
                                currLst.add(s.substring(l,i+1)  );

                            /** ~2.1 继续backtracking */
                            backTrack(s,i+1);

                            currLst.remove(currLst.size()-1);

                    }
                }
            }

            /** isPalindrome: 检测是否是 Palindrome */
            public boolean isPalindrome(String str, int l, int r){
                if(l==r) return true;
                while(l<r){
                    if(str.charAt(l)!=str.charAt(r)) return false;
                    l++;r--;
                }
                return true;
            }
}
