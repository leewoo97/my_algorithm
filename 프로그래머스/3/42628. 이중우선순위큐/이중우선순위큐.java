import java.util.*;

class Solution {
    static StringTokenizer st;
    
    public int[] solution(String[] operations) {       
        DualPriorityQueue dpq = new DualPriorityQueue();
        
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String type = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            if(type.equals("I")){
                dpq.insert(value);
            }else if(type.equals("D")&&(value == 1)){
                dpq.deleteMax();
            }else if(type.equals("D")&&(value == -1)){
                dpq.deleteMin();
            }
        }
        
        int[] answer = new int[2];
        
        if(dpq.findSize()==0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            int maxValue = dpq.findMax();
            int minValue = dpq.findMin();
            answer[0] = maxValue;
            answer[1] = minValue;
        }
        return answer;
    }
}

class DualPriorityQueue {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    
    public DualPriorityQueue(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void insert(int value){
        minHeap.offer(value);
        maxHeap.offer(value);
    }
    
    public void deleteMax(){ //최대값 삭제
        if(!maxHeap.isEmpty()){
            int maxValue = maxHeap.poll();
            minHeap.remove(maxValue);
        }
    }
    
    public void deleteMin(){
        if(!minHeap.isEmpty()){
            int minValue = minHeap.poll();
            maxHeap.remove(minValue);
        }
    }
    
    public int findMax(){
        if(!maxHeap.isEmpty()){
            return maxHeap.peek();
        }
        throw new IllegalStateException("최대 힙이 비어있습니다.");
    }
    
    public int findMin(){
        if(!minHeap.isEmpty()){
            return minHeap.peek();
        }
        throw new IllegalStateException("최소 힙이 비어있습니다.");
    }
    
    public int findSize(){
        return maxHeap.size();
    }
}