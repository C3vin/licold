class Solution {
    
  public int mySqrt(int x) {
      
    if (x < 2) return x;

    long num;
      
    long mi, left = 2, right = x / 2;
      
    while (left <= right) {
        
      mi = (right + left) / 2;
        
      num = (long) mi * mi;
        
      if (num > x) right = mi - 1;
      else if (num < x) left = mi + 1;
      else return (int) mi;
        
    }

    return (int) right;
  }
}
