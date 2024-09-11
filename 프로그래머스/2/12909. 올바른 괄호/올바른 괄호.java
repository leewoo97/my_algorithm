import java.util.*;

class Solution {
    static Queue<String> queue;
    
    boolean solution(String s) {
        // queueSet();
        // sSplit(s);
        int sum = 0;
        String[] parts = s.split("");
        for(int i=0; i<parts.length; i++){
            if(parts[i].equals("(")){
                sum++;
            }else{
                sum--;
            }
               
            if(sum<0){
                return false;
            }   
        }
        
        if(sum==0){
            return true;
        }else{
            return false;
        }
               
               
        // boolean answer = true;
        // answer = queueCheck();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        // return answer;
    }
    
    public static void queueSet(){
        queue = new LinkedList<>();
    }
    
    public static void sSplit(String s){
        String[] parts = s.split("");
        for(int i=0; i<parts.length; i++){
            queue.add(parts[i]);
        }
    }
    
    public static boolean queueCheck(){
        int sum = 0;
        while(!queue.isEmpty()){
            String temp = queue.poll();
            if(temp.equals("(")){
                sum++;
            }else{
                sum--;
            }
            
            if(sum<0){
                return false;
            }
        }
        if(sum==0){
            return true;    
        }
        
        return false;
    }
}