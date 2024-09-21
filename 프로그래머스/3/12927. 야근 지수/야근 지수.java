import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    
    public long solution(int n, int[] works) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        setPQ(works); //pq에 works값을 전부 넣기(이렇게하면 알아서 최대값 뽑아냄.)
        
        for(int i=0; i<n; i++){
            if(!pq.isEmpty()){ //pq가 비어있어있으면 Null오류 발생
                int maxValue = pq.poll();
                int newValue = maxValue-1;
                if(newValue>0){ //값이 0일경우 다시 넣지않음
                    pq.offer(newValue);
                }
            }
        }
        
        long answer = getResult();
        return answer;
    }
    
    public void setPQ(int[] works){
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
    }
    
    public long getResult(){
        long result = 0;
        while(!pq.isEmpty()){
            int value = pq.poll();
            result += value*value;
        }
        return result;
    }
}