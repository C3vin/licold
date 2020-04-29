class Solution {
    
    //  https://yeqiuquan.blogspot.com/2018/05/836-rectangle-overlap.html  
    
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

            /** 只要一個滿足，就不重疊 **/
            return !(rec1[2] <= rec2[0] ||   // left
                     rec1[3] <= rec2[1] ||   // bottom
                     rec1[0] >= rec2[2] ||   // right
                     rec1[1] >= rec2[3]);    // top
        }
}