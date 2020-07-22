class Solution {
 
        // https://youtu.be/G1g2GmGCSvc
     
        public int[] asteroidCollision(int[] asteroids) {

            Stack<Integer> s = new Stack<>();

            for(int i: asteroids) {

                    if (i > 0) {
                        s.push(i);
                    }

                    if (i <= 0) {

                        while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i) /** 绝对值比入侵者小 */) {
                            s.pop();
                        }

                        if (s.isEmpty() || s.peek() < 0) {
                            s.push(i);

                        }

                        if (i + s.peek() == 0) {
                            s.pop(); //equal
                        }
                    }
            }

            int[] res = new int[s.size()];

            for(int i = res.length - 1; i >= 0; i--){
                res[i] = s.pop();

            }

            return res;
        }
}