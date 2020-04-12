/**
* Time:  O(nlogn)
* Space: O(n)
* */
class Solution {

        public int carFleet(int target, int[] position, int[] speed) {

            TreeMap<Integer, Double> map = new TreeMap<>();
 
            /** 按照位置坐标，存入map */
            for(int i=0; i < position.length; ++i){
      
                map.put(-position[i], (double)(target - position[i])/speed[i]);
            }

            int count = 0;
            double r = -1.0;

            /*for all car this value must > 0, so we can count for the car closeset to target*/
            for(double time:map.values()){
 
                if( time > r ){ // this car is unable to catch up previous one, form a new group and update the value
                    r = time;
                    count++;
                }
            }
            return count;
        }
}