import java.util.NoSuchElementException;

class Vector2D {
    
    private int[][] vector;
    
    private int i = 0;  // 子元素里面的 元素的坐标

    private int k = 0;  // 子元素坐标
    
    public Vector2D(int[][] v) {
 
        this.vector = v;
    }
 
    private void advanceToNext() {

        while ( k < vector.length && i == vector[k].length ) {
            i = 0;
            k++;
        }
    }
    
    public int next() {
 
        if ( !hasNext() )  throw new NoSuchElementException();
 
        return vector[k][i++];
    }
    
    public boolean hasNext() {
       
        advanceToNext(); // 每一次都检查一下是否要advance
 
        return k < vector.length;
    }
}