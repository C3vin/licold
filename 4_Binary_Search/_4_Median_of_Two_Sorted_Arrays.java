class Solution {
    
    public double findMedianSortedArrays(int input1[], int input2[]) {
         
        if (input1.length > input2.length)  findMedianSortedArrays(input2, input1);   /** input1 总是短 的那个 */
       
        int x = input1.length; int y = input2.length;  /** 获取input1和input2的长度 **/
 
        int low = 0;   /** 初始化 low 和 high **/
		int high = x;
         
        while (low <= high) {  /** 循环 */
             
				int partitionX = (low + high)/2;   /** 获取两个partition的长度 */
				int partitionY = (x + y + 1)/2 - partitionX;
	 
				/** 包含边界条件，获取这四大天王 */
				int maxLeftX  = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
				int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

				int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
				int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
 
				if (maxLeftX <= minRightY && maxLeftY <= minRightX) {  /** 满足 **/
						if ((x + y) % 2 == 0) { // 总长是偶数 
							return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
						} else { // 奇数
							return (double)Math.max(maxLeftX, maxLeftY);
						}
				/** 不满足 1 **/    
				} else if (maxLeftX > minRightY) { // Go on left side.
					    high = partitionX - 1;
				/** 不满足 2 **/  
				} else { // Go on right side.
				    	low = partitionX + 1;
				}
        }
         throw new IllegalArgumentException();
    }
}