import java.util.*;
class Solution {
    static Queue<String> queue;
    static Queue<Integer> depthQueue;
    static HashMap<String,Boolean> visited;
    static int result;
    
    public int solution(String begin, String target, String[] words) {
        queue = new LinkedList<>();
        depthQueue = new LinkedList<>();
        visited = new HashMap<>();
        result = 0;
        
        setHm(words);
        wordBFS(begin,target,words);
        
        int answer = result;
        return answer;
    }
    
    public void setHm(String[] words){
        for(int i=0; i<words.length; i++){
            visited.put(words[i],false);
        }
    }
    
    public void wordBFS(String begin, String target, String[] words){
        queue.add(begin);
        depthQueue.add(0);
        
        while(!queue.isEmpty()){
            String now = queue.poll();
            int depth = depthQueue.poll();
            // System.out.println(now);
            
            if(now.equals(target)){
                result = depth;
                return;
            }            
            
            for(int i=0; i<words.length; i++){
                if(!visited.get(words[i])&&wordCompareTarget(now, words[i])){
                    queue.add(words[i]);
                    depthQueue.add(depth+1);
                    visited.put(words[i],true);
                }
            }
        }
    }
    
    public boolean wordCompareTarget(String now, String word){
        int wordLength = word.length();
        String[] nowSplit = now.split("");
        String[] wordSplit = word.split("");
        
        int count = 0;
        
        for(int i=0; i<wordLength; i++){
            if(nowSplit[i].equals(wordSplit[i])){
                count++;
                // System.out.println("nowSplit : " + nowSplit[i] + " wordSplit : " + wordSplit[i] + " count : " + count);
            }
        }
        
        if(count==wordLength-1){
            return true;
        }else{
            return false;
        }
    }
}