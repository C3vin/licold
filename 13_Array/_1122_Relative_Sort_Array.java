class Solution {
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] cnt = new int[1001];

        for(int n : arr1) cnt[n]++;

        int i = 0;

        /** 先把arr2塞进去arr1 */
        for(int n : arr2) {
          while(cnt[n]-- > 0) arr1[i++] = n;
        }

        /** 把剩下的塞进去arr1 */
        for(int n = 0; n < cnt.length; n++) {
            
              while(cnt[n]-- > 0)  arr1[i++] = n;
     
        }

        return arr1;
    }
}